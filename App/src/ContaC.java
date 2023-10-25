import java.time.LocalDate;

public class ContaC extends Conta{

    private double chequeEspecial;
    private int transferenciasF;
    private LocalDate dataHoje = LocalDate.now();

    public ContaC(String numAgencia, String numConta, Cliente cliente, double chequeEspecial, Notificacao notificacao) {
        super(numAgencia, numConta, cliente, notificacao);
        this.chequeEspecial = chequeEspecial;
        this.transferenciasF = 0;
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public void transferTax1(Conta contaDestino, double valor){
        if (valor > (super.getSaldo() + chequeEspecial)){
            System.out.println("Saldo insuficiente.");
            return;
        } else if (transferenciasF < 2){
            super.transfer(contaDestino, valor);
            Transacao transferencia = new Transacao("Transferencia na corrente", valor, dataHoje);
            addTransacao(transferencia);
            System.out.println("Tranferencia concluida.");
        } else {
            double taxa = valor * 0.10;
            if (super.getSaldo() >= valor + taxa){
                super.transfer(contaDestino, valor + taxa);
                Transacao transferencia = new Transacao("Transferencia na corrente + taxa", valor, dataHoje);
            addTransacao(transferencia);
                System.out.println("Tranferencia concluida. Taxa de 10% aplicada.");
            } else {
                System.out.println("Saldo insuficiente.");
            }
        }
        transferenciasF++;
    }

    @Override
    public void transfer(Conta contaDestino, double valor){
        transferTax1(contaDestino, valor);
    }

    @Override
    public String toString(){
        return "\nAgencia: " + this.getNumAgencia() +
               "\nConta: " + this.getNumConta() +
               "\nRendimento: " + this.getChequeEspecial();
    }

}
