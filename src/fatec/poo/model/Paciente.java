package fatec.poo.model;

import java.time.LocalDate;

/**
 *
 * @author Henrique Andrade
 */
public class Paciente extends Pessoa {
    
    private LocalDate dataNascimento ;
    private double altura;
    private double peso;

    public Paciente(String cpf, String nome, LocalDate dataNascimento){
        super(cpf, nome);
        this.dataNascimento = dataNascimento;
    }


    //SETTERS
    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }


    //GETTERS
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public double getAltura() {
        return altura;
    }

    public double getPeso() {
        return peso;
    }

    public double calcIMC(){
        return getPeso() / Math.pow(getAltura(),2);
    }

    public int calcIdade(LocalDate dataAtual){
        return  dataAtual.compareTo(getDataNascimento());
    }
    
    
}
