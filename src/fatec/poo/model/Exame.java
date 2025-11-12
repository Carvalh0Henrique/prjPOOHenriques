package fatec.poo.model;

public class Exame {
    
    private int codigo;
    private String descricao;
    private String data;
    private String horario;
    private double valor;
    private Consulta consulta;


    public Exame(int codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }
    
    
    //SETTERS
    public void setData(String data) {
        this.data = data;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
    
    //GETTERS
    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getData() {
        return data;
    }

    public String getHorario() {
        return horario;
    }

    public double getValor() {
        return valor;
    }

    public Consulta getConsulta() {
        return consulta;
    }
}
