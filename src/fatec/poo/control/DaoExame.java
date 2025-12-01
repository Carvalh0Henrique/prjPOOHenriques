
package fatec.poo.control;

import fatec.poo.model.Exame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author h-and-rod
 */
public class DaoExame {
    private Connection conn;

    public DaoExame(Connection conn) {
        this.conn = conn;
    }    
    
    public void inserir(Exame exame){
        PreparedStatement ps = null;
        
        try{
            
            ps = conn.prepareStatement("INSERT INTO tbExame (codigo, descricao, data, horario, valor, FK_codigoConsulta) VALUES (?,?,?,?,?,?)");
            ps.setInt(1, exame.getCodigo());
            ps.setString(2, exame.getDescricao());
            ps.setString(3, exame.getData());
            ps.setString(4, exame.getHorario());
            ps.setDouble(5, exame.getValor());
            ps.setInt(6, exame.getConsulta().getCodigo());
            
            ps.execute();
        } catch (SQLException ex){
            System.out.println(ex.toString());
        }
    } 
    
    public void alterar(Exame exame){
        PreparedStatement ps = null;
        
        try{
            ps = conn.prepareStatement("UPDATE tbExame SET descricao = ?, data = ?, horario = ?, valor = ?" + 
                                       "WHERE codigo = ?");
            
            ps.setString(1, exame.getDescricao());
            ps.setString(2, exame.getData());
            ps.setString(3, exame.getHorario());
            ps.setDouble(4, exame.getValor());
            ps.setInt(5, exame.getCodigo());
            
            ps.execute();
            
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public Exame consultar(int codigo){
        Exame exame = null;
        PreparedStatement ps = null;
        
        try{
            ps = conn.prepareStatement("SELECT * FROM tbExame WHERE codigo = ?");
            ps.setInt(1, codigo);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                exame = new Exame(codigo, rs.getString("descricao"));
                exame.setData(rs.getString("data"));
                exame.setHorario(rs.getString("horario"));
                exame.setValor(rs.getDouble("valor"));
                
                DaoConsulta daoConsulta = new DaoConsulta(conn);
                exame.setConsulta(daoConsulta.consultar(Integer.parseInt(rs.getString("FK_codigoConsulta"))));
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return exame;
    }
    
    public void excluir(Exame exame) {
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement("DELETE FROM tbExame WHERE codigo = ?");
            
            ps.setInt(1, exame.getCodigo());
            
            ps.execute();
        } catch(SQLException ex) {
            System.out.println(ex.toString());
        }
    }
}
