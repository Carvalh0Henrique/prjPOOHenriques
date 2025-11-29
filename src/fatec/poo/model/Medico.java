
package fatec.poo.model;

import java.util.ArrayList;

/**
 *
 * @author Henrique Carvalho
 */
public class Medico extends Pessoa {
    private String crm;
    private String especialidade;
    private ArrayList<Consulta> consultas;

    public Medico(String crm, String especialidade, String cpf, String nome) {
        super(cpf, nome);
        this.crm = crm;
        this.especialidade = especialidade;

        consultas = new ArrayList<>();
    }
    
    //SETTERS
    public void setCrm(String crm) {
        this.crm = crm;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    

    //GETTERS
    public String getCrm() {
        return crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }   

    public void addConsulta(Consulta c) {
        consultas.add(c);
        c.setMedico(this);
    }
}
