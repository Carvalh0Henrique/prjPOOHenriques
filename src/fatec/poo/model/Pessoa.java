
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
    
    public static boolean validarCPF(String cpf) {

        if (cpf.length() != 11) {
            return false;
        }

        if (cpf.chars().distinct().count() == 1) {
            return false;
        }

        int somaPrimeiroDigito = 0;

        for (int i = 0; i < 9; i++) {
            int digito = cpf.charAt(i) - '0';
            somaPrimeiroDigito += digito * (i + 1);
        }

        int restoPrimeira = somaPrimeiroDigito % 11;
        int digitoVerificador1 = (restoPrimeira == 10) ? 0 : restoPrimeira;

        int somaSegundoDigito = 0;
        int pesoInicial = 11;

        for (int i = 0; i < 9; i++) {
            int digito = cpf.charAt(i) - '0';
            somaSegundoDigito += digito * pesoInicial;
            pesoInicial--;
        }

        somaSegundoDigito += digitoVerificador1 * 2;

        int restoSegunda = (somaSegundoDigito * 10) % 11;
        int digitoVerificador2 = (restoSegunda == 10) ? 0 : restoSegunda;

        return digitoVerificador1 == (cpf.charAt(9) - '0') &&
               digitoVerificador2 == (cpf.charAt(10) - '0');
    }
}
