import java.util.ArrayList;
import java.util.List;

public class Conta {

    private final int numAgencia;
    private final int numConta;
    private double saldo;
    private Cliente cliente;
    private List<Transacao> transacoes;
    Notificacao notificacao;


    public Conta(int numAgencia, int numConta, Cliente cliente, Notificacao notificacao){
        this.numAgencia = numAgencia;
        this.numConta = numConta;
        this.cliente = cliente;
        this.setSaldo(0.00);
        this.transacoes = new ArrayList<>();
        this.notificacao = notificacao;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getNumAgencia() {
        return numAgencia;
    }

    public int getNumConta() {
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
        setSaldo(getSaldo() + valor);
    }

    public void setNoticacao(Notificacao notificacao){
        this.notificacao = notificacao;
    }

    public void sacar(double valor){
        if (valor <= getSaldo()){
            setSaldo(getSaldo() - valor);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void transfer(Conta contaFin, double valor){
        if (valor <= getSaldo()){
            setSaldo(getSaldo() - valor);
            contaFin.deposito(valor);
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

}
