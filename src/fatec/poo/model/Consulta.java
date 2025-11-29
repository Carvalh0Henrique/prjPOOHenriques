
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
    private ArrayList<Exame> exames;
    private ArrayList<Medicacao> medicacoes;

    public Consulta(int codigo, String data) {
        this.codigo = codigo;
        this.data = data;
        
        exames = new ArrayList<>();
        medicacoes = new ArrayList<>();
    }
    
    //SETTERS
    public void setData(String data) {
        this.data = data;
    }
    
    
    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
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
    
    //ADDERS
    public void addExame(Exame e) {
        exames.add(e);
        e.setConsulta(this);
    }

    public void addMedicacao(Medicacao m) {
        medicacoes.add(m);
    }
    
    public double calcValorTotalPagar() {
        
        double totalExame = 0;
        
        for(int i = 0; i < exames.size(); i++) {
            totalExame += exames.get(i).getValor();
        }
        return (valor + totalExame);
    }
}
