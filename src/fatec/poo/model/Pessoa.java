
package fatec.poo.model;

/**
 *
 * @author Henrique Carvalho
 */
public class Pessoa {
    private String cpf;
    private String nome;
    private String endereco;
    private String telefone;

    public Pessoa(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }
    
    //SETTERS
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }    

    public void setNome(String nome) {
        this.nome = nome;
    }   
    
    //GETTERS
    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }   
}
