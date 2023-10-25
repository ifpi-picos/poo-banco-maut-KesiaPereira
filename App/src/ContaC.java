public class ContaC extends Conta{

    private double chequeEspecial;
    private int transferenciasF;

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

    public void transferTax1(Conta contaFin, double valor){
        if (valor > (super.getSaldo() + chequeEspecial)){
            System.out.println("Saldo insuficiente.");
            return;
        }
        if (transferenciasF < 2){
            super.transfer(contaFin, valor);
        } else {
            double taxa = valor * 0.10;
            if (super.getSaldo() >= valor + taxa){
                super.transfer(contaFin, valor + taxa);
            } else {
                System.out.println("Saldo insuficiente.");
            }
        }
        transferenciasF++;
    }

}
