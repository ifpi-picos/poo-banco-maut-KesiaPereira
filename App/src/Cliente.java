import java.util.List;
import java.time.LocalDate;

public class Cliente {

    private String nome;
    private final String cpf;
    private LocalDate dataNascimento;
    private List<Conta> contas;
    private List<Endereco> enderecos;


    public Cliente(String nome, String cpf, LocalDate dataNascimento){
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
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

    public LocalDate GetDataNascimento(){
        return dataNascimento;
    }

    public void setDataNasc(LocalDate dataNascimento){
        this.dataNascimento = dataNascimento;
    }

    public List<Conta> getContas(){
        return contas;
    }

    public void setContas(List<Conta> contas){
        this.contas = contas;
    }

    public List<Endereco> getEnderecos(){
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos){
        this.enderecos = enderecos;
    }

    @Override
    public String toString(){
        return "\nNome: " + this.getNome() +
               "\nCPF: " + this.getCpf() +
               "\nNascimento: " + this.GetDataNascimento();
    }

}
