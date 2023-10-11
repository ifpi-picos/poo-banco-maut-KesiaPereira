import java.util.List;
import java.time.LocalDate;

public class Cliente {
    private String nome;
    private final String cpf;
    private LocalDate dataNasc;
    private String endereco;
    List<Conta> contas;


public Cliente(String nome, String cpf, LocalDate dataNasc, String endereco){
    this.nome = nome;
    this.cpf = cpf;
    this.dataNasc = dataNasc;
    this.endereco = endereco;
}
}