package fatec.poo.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author Henrique Andrade
 */
public class Paciente extends Pessoa {
    
    private LocalDate dataNascimento ;
    private double altura;
    private double peso;
    private ArrayList<Consulta> consultas;

    public Paciente(String cpf, String nome, LocalDate dataNascimento){
        super(cpf, nome);
        this.dataNascimento = dataNascimento;
        consultas = new ArrayList<Consulta>();
    }

    //SETTERS
    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    

    //GETTERS
    public String getDataNascimento() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataNascimento.format(dtf);
    }

    public double getAltura() {
        return altura;
    }

    public double getPeso() {
        return peso;
    }

    public double calcIMC(){
        return getPeso() / Math.pow(altura,2);
    }

    public int calcIdade(LocalDate dataAtual){
        return Period.between(dataNascimento, dataAtual).getYears();
    }
    
    public void addConsulta(Consulta c){
        consultas.add(c);
    }

}
