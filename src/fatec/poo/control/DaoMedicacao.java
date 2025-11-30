/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.control;

import fatec.poo.model.Consulta;
import fatec.poo.model.Medicacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author h-and-rod
 */
public class DaoMedicacao {
    
    private Connection conn;
    
    public DaoMedicacao(Connection conn) {
        this.conn = conn;
    }
    
    public void inserir (Medicacao medicacao, Consulta consulta){
        PreparedStatement ps = null;
        
        try{
            ps = conn.prepareStatement("INSERT INTO tbMedicacao(nome, dosagem, qtdeDias, FK_codigoConsulta) VALUES (?, ?, ?, ?)");
            
            ps.setString(1, medicacao.getNome());
            ps.setString(2, medicacao.getDosagem());
            ps.setInt(3, medicacao.getQtdeDias());
            ps.setInt(4, consulta.getCodigo());
            
            ps.execute();
        }catch (SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public Medicacao consultar(String nome){
        
       Medicacao medicacao = null;
       PreparedStatement ps = null;
       
       try{
           ps = conn.prepareStatement("SELECT * FROM tbMedicacao WHERE " + "nome = ?");
           ps.setString(1, nome);
           
           ResultSet rs = ps.executeQuery();
           
           if (rs.next()){
               medicacao = new Medicacao(nome);
               medicacao.setDosagem(rs.getString("dosagem"));
               medicacao.setQtdeDias(rs.getInt("qtdeDias"));
           }                             
       } catch (SQLException ex){
           System.out.println(ex.toString());
       }
       
       return medicacao;         
    } 
    
    public void alterar(Medicacao medicacao){
        PreparedStatement ps = null;
        
        try{
            ps = conn.prepareStatement("UPDATE tbMedicacao SET dosagem = ?, qtdeDias = ? " + "WHERE nome = ?");
            
            ps.setString(1, medicacao.getDosagem());
            ps.setInt(2, medicacao.getQtdeDias());
            ps.setString(3, medicacao.getNome());
            
            ps.execute();
        } catch (SQLException ex){
            System.out.println(ex.toString());
            
        }
    }
    
    public void excluir(Medicacao medicacao){
        PreparedStatement ps = null;
        
        try{
           ps = conn.prepareStatement("DELETE FROM tbMedicacao WHERE nome = ?");
           
           ps.setString(1, medicacao.getNome());
           
           ps.execute();
           
        } catch (SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public Consulta buscarConsulta(String medNome){
        Consulta consulta = null;
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement("SELECT FK_codigoConsulta FROM tbMedicacao WHERE nome = ?");
            ps.setString(1, medNome);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
                int codigo = rs.getInt("FK_codigoConsulta");
                DaoConsulta daoConsulta = new DaoConsulta(conn);
                consulta = daoConsulta.consultar(codigo);
            }
            
        } catch (SQLException ex){
            System.out.println(ex);
        }
        
        return consulta;
    }
    
}
