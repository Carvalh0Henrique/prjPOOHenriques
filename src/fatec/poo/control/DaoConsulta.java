
package fatec.poo.control;

import fatec.poo.model.Consulta;
import fatec.poo.model.Medico;
import fatec.poo.model.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Henrique Carvalho
 */
public class DaoConsulta {
    private Connection conn;

    public DaoConsulta(Connection conn) {
        this.conn = conn;
    }
    
    public void inserir(Consulta consulta, Paciente paciente) {
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement("INSERT INTO tbConsulta(codigo, data, valor, FK_cpfMedico, FK_cpfPaciente) " + 
                                        "values (?, ?, ?, ?, ?)");
            
            ps.setInt(1, consulta.getCodigo());
            ps.setString(2, consulta.getData());
            ps.setDouble(3, consulta.getValor());
            ps.setString(4, consulta.getMedico().getCpf());
            ps.setString(5, paciente.getCpf());
            
            ps.execute();
        } catch(SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public void alterar(Consulta consulta) {
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement("UPDATE tbConsulta SET data = ?, valor = ?");
            
            ps.setString(1, consulta.getData());
            ps.setDouble(2, consulta.getValor());
            
            ps.execute();
        } catch(SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public void excluir(Consulta consulta) {
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement("DELETE FROM tbConsulta WHERE codigo = ?");
            
            ps.setInt(1, consulta.getCodigo());
            
            ps.execute();
        } catch(SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public Consulta consultar(int codigo) {
        Consulta c = null;
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement("SELECT * FROM tbConsulta WHERE codigo = ?");
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                c = new Consulta(codigo, rs.getString("Data"));
                c.setValor(rs.getDouble("Valor"));               
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return c;
    }
    
    public Medico buscarMedicoDaConsulta(int codigo) {
        Medico m = null;
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT FK_cpfMedico FROM tbConsulta WHERE Codigo = ?");
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                String cpf = rs.getString("FK_cpfMedico");
                
                DaoMedico dao = new DaoMedico(conn);
                m = dao.consultar(cpf);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return m;
    }
    
    public Paciente buscarPacienteDaConsulta(int codigo) {
        Paciente p = null;
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT FK_cpfPaciente FROM tbConsulta WHERE Codigo = ?");
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                String cpf = rs.getString("FK_cpfPaciente");
                DaoPaciente dao = new DaoPaciente(conn);
                p = dao.consultar(cpf);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return p;
    }

}
