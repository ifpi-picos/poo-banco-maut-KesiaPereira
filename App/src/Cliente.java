import java.util.List;
import java.time.LocalDate;

public class Cliente {

    private String nome;
    private final String cpf;
    private LocalDate dataNasc;
    List<Conta> contas;


    public Cliente(String nome, String cpf, LocalDate dataNasc){
        this.nome = nome;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
    }

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCpf(){
        return cpf;
    }

    public LocalDate GetDataNasc(){
        return dataNasc;
    }
    public void setDataNasc(LocalDate dataNasc){
        this.dataNasc = dataNasc;
    }

    public String toString(){
        return "\nNome: " + this.getNome() +
        "\nCPF: " + this.getCpf() +
        "\nNascimento: " + this.GetDataNasc();
    }

}
