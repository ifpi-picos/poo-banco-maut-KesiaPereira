import java.util.ArrayList;
import java.util.List;

public class Conta {
    private final String numAgencia;
    private final String numConta;
    private Double saldo;
    private Cliente cliente;
    private List<Transacao> transacoes;


    public Conta(String numAgencia, String numConta, Cliente cliente){
        this.numAgencia = numAgencia;
        this.numConta = numConta;
        this.cliente = cliente;
        this.saldo = 0.00;
        this.transacoes = new ArrayList<>();
    }

    public double getSaldo(){
        return saldo;
    }

    public void deposito(double valor){
        saldo += valor;
    }

    public void sacar(double valor){
        if (valor <= saldo){
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void transfer(Conta contaFin, double valor){
        if (valor <= saldo){
            saldo -= valor;
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