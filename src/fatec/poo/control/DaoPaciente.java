/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.control;

import fatec.poo.model.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author h-and-rod
 */
public class DaoPaciente {
    private Connection conn;
    
    public DaoPaciente(Connection conn){
        this.conn = conn;
    }
    
    public Paciente consultar(String cpf){
        PreparedStatement ps = null;
        Paciente p = null;
        
        try{
            ps = conn.prepareStatement("SELECT * FROM tbPaciente WHERE " + "cpf = ?");
            ps.setString(1, cpf);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
                p = new Paciente(rs.getString("cpf"), rs.getString("nome"), rs.getObject("data_nascimento", LocalDate.clas));
                p.setEndereco(rs.getString("endereco"));
                p.setTelefone(rs.getString("telefone"));
                p.setAltura(rs.getDouble("altura"));
                p.setPeso(rs.getDouble("peso"));
            }
        } catch(SQLException ex){
            System.out.println(ex.toString());
        }
        return(p);
    }
}
