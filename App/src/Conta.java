import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Conta deveria ser abstrata para não permitir criar objetos diretamente a partir dela.
// No sistema só é permitido ter contas de dois tipos: corrente e poupança
public class Conta {

    private final String numeroAgencia;
    private final String numeroConta;
    protected double saldo;
    private Cliente cliente;
    private List<Transacao> transacoes;
    private Notificacao notificacao;
    private LocalDate dataHoje = LocalDate.now();


    public Conta(String numeroAgencia, String numeroConta, Cliente cliente,
            Notificacao notificacao) {
        this.numeroAgencia = numeroAgencia;
        this.numeroConta = numeroConta;
        this.cliente = cliente;
        this.saldo = 0.00;
        this.transacoes = new ArrayList<>();
        this.notificacao = notificacao;
    }

    public String getNumeroAgencia() {
        return numeroAgencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void deposito(double valor) {
        saldo += valor;
    }

    public Notificacao getNotificacao() {
        return notificacao;
    }

    public void setNotificacao(Notificacao notificacao) {
        this.notificacao = notificacao;
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;

            Transacao saque = new Transacao("Saque", valor, dataHoje);
            addTransacao(saque);

            System.out.println("Saque concluido.");

        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void transferencia(Conta contaDestino, double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            contaDestino.deposito(valor);

            Transacao deposito = new Transacao("Deposito", valor, dataHoje);
            addTransacao(deposito);

            System.out.println("Deposito concluido.");

        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public void addTransacao(Transacao transacao) {
        transacoes.add(transacao);
    }

}
