import java.util.ArrayList;
import java.util.List;

public class Conta {

    private final String numAgencia;
    private final String numConta;
    protected double saldo;
    private Cliente cliente;
    private List<Transacao> transacoes;
    private Notificacao notificacao;


    public Conta(String numAgencia, String numConta, Cliente cliente, Notificacao notificacao){
        this.numAgencia = numAgencia;
        this.numConta = numConta;
        this.cliente = cliente;
        this.saldo = 0.00;
        this.transacoes = new ArrayList<>();
        this.notificacao = notificacao;
    }

    public String getNumAgencia() {
        return numAgencia;
    }

    public String getNumConta() {
        return numConta;
    }
    
    public double getSaldo(){
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void deposito(double valor){
        saldo += valor;
    }

    public Notificacao getNotificacao(){
        return notificacao;
    }

    public void setNotificacao(Notificacao notificacao){
        this.notificacao = notificacao;
    }

    public void sacar(double valor){
        if (valor <= saldo){
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void transfer(Conta contaDestino, double valor){
        if (valor <= saldo){
            saldo -= valor;
            contaDestino.deposito(valor);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public List<Transacao> getTransacoes(){
        return transacoes;
    }

    public void addTransacao(Transacao transacao){
        transacoes.add(transacao);
    }

    public void setSaldo(double d) {
    }

}
