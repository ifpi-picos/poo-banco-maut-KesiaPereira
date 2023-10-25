import java.time.LocalDate;

public class ContaP extends Conta{

    private double rendimento;

    public ContaP(String numAgencia, String numConta, Cliente cliente, double rendimento, Notificacao notificacao) {
        super(numAgencia, numConta, cliente, notificacao);
        this.rendimento = rendimento;
    }

    public double getRendimento() {
        return rendimento;
    }

    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }

    public void transferTax2(Conta contaDestino, double valor){
        double taxa = valor * 0.10;
        if (getSaldo() >= valor + taxa){
            super.transfer(contaDestino, valor + taxa);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void sacarTax1(double valor){
        double taxa = valor * 0.05;
        if (getSaldo() >= valor + taxa){
            saldo -= (valor + taxa);
            LocalDate dataHoje = LocalDate.now();
            Transacao sacar = new Transacao("Saque", -valor, dataHoje);
            addTransacao(sacar);
            Transacao sacarTax = new Transacao("Taxa de Saque", -taxa, dataHoje);
            addTransacao(sacarTax);
        } else {
            System.out.println("Saldo insuficiente");
        }
    }

    public void depositarRend(double valor){
        double rendimentoDeposit = valor * (rendimento/100.0);
        saldo += valor + rendimentoDeposit;
        LocalDate dataHoje = LocalDate.now();
        Transacao deposito = new Transacao("Deposito", valor, dataHoje);
        addTransacao(deposito);
        Transacao rendimento = new Transacao("Rendimento", rendimentoDeposit, dataHoje);
        addTransacao(rendimento);
    }

    @Override
    public void transfer(Conta contaDestino, double valor){
        transferTax2(contaDestino, valor);
    }

    @Override
    public void sacar(double valor){
        sacarTax1(valor);
    }

    @Override
    public String toString(){
        return "\nAgencia: " + this.getNumAgencia() +
               "\nConta: " + this.getNumConta() +
               "\nRendimento: " + this.getRendimento();
    }

}
