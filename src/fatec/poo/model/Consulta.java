
package fatec.poo.model;

import java.util.ArrayList;

/**
 *
 * @author Henrique Carvalho
 */
public class Consulta {
    private int codigo;
    private String data;
    private double valor;
    private Medico medico;
    private Paciente paciente;
    private ArrayList<Exame> exames;

    public Consulta(int codigo, String data) {
        this.codigo = codigo;
        this.data = data;
        
        exames = new ArrayList<Exame>();
    }
    
    //SETTERS
    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }   

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;        
    }       
    
    //GETTERS
    public int getCodigo() {
        return codigo;
    }

    public String getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }

    public Medico getMedico() {
        return medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }
           
    public void addExame(Exame e) {
        exames.add(e);
        e.setConsulta(this);
    }
    
    public double calcValorTotalPagar() {
        
        double totalExame = 0;
        
        for(int i = 0; i < exames.size(); i++) {
            totalExame += exames.get(i).getValor();
        }
        return (valor + totalExame);
    }
}
