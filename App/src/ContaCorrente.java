import java.time.LocalDate;

public class ContaCorrente extends Conta{

    private double chequeEspecial;
    private int transferenciaenciasFeitas;
    private LocalDate dataHoje = LocalDate.now();

    public ContaCorrente(String numeroAgencia, String numeroConta, Cliente cliente, double chequeEspecial, Notificacao notificacao) {
        super(numeroAgencia, numeroConta, cliente, notificacao);
        this.chequeEspecial = chequeEspecial;
        this.transferenciaenciasFeitas = 0;
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    private void taxaTransferenciaencia1(Conta contaDestino, double valor){
        if (valor > (super.getSaldo() + chequeEspecial)){
            System.out.println("Saldo insuficiente.");
            return;

        } else if (transferenciaenciasFeitas < 2){
            super.transferencia(contaDestino, valor);

            Transacao transferenciaencia = new Transacao("Transferenciaencia na corrente", valor, dataHoje);
            addTransacao(transferenciaencia);

            System.out.println("Tranferencia concluida.");

        } else {
            double taxa = valor * 0.10;
            if (super.getSaldo() >= valor + taxa){
                super.transferencia(contaDestino, valor + taxa);

                Transacao transferenciaencia = new Transacao("Transferenciaencia na corrente + taxa", valor, dataHoje);
            addTransacao(transferenciaencia);

                System.out.println("Tranferencia concluida. Taxa de 10% aplicada.");

            } else {
                System.out.println("Saldo insuficiente.");
            }
        }
        transferenciaenciasFeitas++;
    }

    @Override
    public void transferencia(Conta contaDestino, double valor){
        taxaTransferenciaencia1(contaDestino, valor);
    }

    @Override
    public String toString(){
        return "\nAgencia: " + this.getNumeroAgencia() +
               "\nConta: " + this.getNumeroConta() +
               "\nRendimento: " + this.getChequeEspecial();
    }

}
