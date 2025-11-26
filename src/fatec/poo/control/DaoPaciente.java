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
import java.time.LocalDate;

/**
 *
 * @author h-and-rod
 */
public class DaoPaciente {
    private Connection conn;

    public DaoPaciente(Connection conn) {
        this.conn = conn;
    }

    public Paciente consultar(String cpf) {
        PreparedStatement ps = null;
        Paciente p = null;

        try {
            ps = conn.prepareStatement("SELECT * FROM tbPaciente WHERE " + "cpf = ?");
            ps.setString(1, cpf);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                p = new Paciente(rs.getString("cpf"), rs.getString("nome"),
                        rs.getObject("data_nascimento", LocalDate.class));
                p.setEndereco(rs.getString("endereco"));
                p.setTelefone(rs.getString("telefone"));
                p.setAltura(rs.getDouble("altura"));
                p.setPeso(rs.getDouble("peso"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return (p);
    }

    public void inserir(Paciente paciente) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(
                    "INSERT INTO tbPaciente(cpf, nome, endereco, telefone, data_nascimento, altura, peso) VALUES (?,?,?,?,?,?)");

            ps.setString(1, paciente.getCpf());
            ps.setString(1, paciente.getNome());
            ps.setString(1, paciente.getEndereco());
            ps.setString(1, paciente.getTelefone());
            ps.setString(1, paciente.getDataNascimento());
            ps.setDouble(1, paciente.getAltura());
            ps.setDouble(1, paciente.getPeso());
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public void alterar(Paciente paciente) {
    PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(
                "UPDATE tbPaciente SET nome = ?, endereco = ?, telefone = ?, data_nascimento = ?, altura = ?, peso = ? " +
                "WHERE cpf = ?"
            );

            ps.setString(1, paciente.getNome());
            ps.setString(2, paciente.getEndereco());
            ps.setString(3, paciente.getTelefone());
            ps.setObject(4, paciente.getDataNascimento());
            ps.setDouble(5, paciente.getAltura());
            ps.setDouble(6, paciente.getPeso());
            ps.setString(7, paciente.getCpf());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }   
    
    public void excluir(Paciente paciente) {
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement("DELETE FROM tbPaciente WHERE cpf = ?");
            
            ps.setString(1, paciente.getCpf());
            
            ps.execute();
        } catch(SQLException ex) {
            System.out.println(ex.toString());
        }
    }

}
