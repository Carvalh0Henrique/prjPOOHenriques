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
    
    
    }
}
