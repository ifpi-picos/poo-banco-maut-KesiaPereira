import java.time.LocalDate;

public class ContaPoupanca extends Conta{

    private double rendimento;
    private LocalDate dataHoje = LocalDate.now();

    public ContaPoupanca(String numeroAgencia, String numeroConta, Cliente cliente, double rendimento, Notificacao notificacao) {
        super(numeroAgencia, numeroConta, cliente, notificacao);
        this.rendimento = rendimento;
    }

    public double getRendimento() {
        return rendimento;
    }

    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }

    private void taxaTransferenciaencia2(Conta contaDestino, double valor){
        double taxa = valor * 0.10;
        if (getSaldo() >= valor + taxa){
            super.transferencia(contaDestino, valor + taxa);

            Transacao transferenciaencia = new Transacao("Transferenciaencia na poupanca", valor, dataHoje);
            addTransacao(transferenciaencia);

            System.out.println("Tranferencia concluida.");

        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    private void taxaSacar1(double valor){
        double taxa = valor * 0.05;
        if (getSaldo() >= valor + taxa){
            saldo -= (valor + taxa);

            Transacao sacar = new Transacao("Saque na poupanca", -valor, dataHoje);
            addTransacao(sacar);

            System.out.println("Saque concluido.");

            Transacao taxaSacar = new Transacao("Taxa de saque", -taxa, dataHoje);
            addTransacao(taxaSacar);

            System.out.println("Taxa de 5% aplicada.");

        } else {
            System.out.println("Saldo insuficiente");
        }
    }

    public void depositarRendimento(double valor){
        double depositoRendimento = valor * (rendimento/100.0);
        saldo += valor + depositoRendimento;

        LocalDate dataHoje = LocalDate.now();

        Transacao deposito = new Transacao("Deposito", valor, dataHoje);
        addTransacao(deposito);

        System.out.println("Deposito concluido.");
        
        Transacao rendimento = new Transacao("Rendimento", depositoRendimento, dataHoje);
        addTransacao(rendimento);

        System.out.println("Rendimento aplicado.");
        
    }

    @Override
    public void transferencia(Conta contaDestino, double valor){
        taxaTransferenciaencia2(contaDestino, valor);
    }

    @Override
    public void sacar(double valor){
        taxaSacar1(valor);
    }

    @Override
    public String toString(){
        return "\nAgencia: " + this.getNumeroAgencia() +
               "\nConta: " + this.getNumeroConta() +
               "\nRendimento: " + this.getRendimento();
    }

}
