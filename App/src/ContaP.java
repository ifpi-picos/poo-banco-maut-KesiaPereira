public class ContaP extends Conta{

    private double rendimento;

    public ContaP(int numAgencia, int numConta, Cliente cliente, double rendimento) {
        super(numAgencia, numConta, cliente);
        this.rendimento = rendimento;
    }

    public double getRendimento() {
        return rendimento;
    }

    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }

    public void transferTax2(Conta contaFin, double valor){
        double taxa = valor * 0.10;
        if (super.getSaldo() >= valor + taxa){
            super.transfer(contaFin, valor + taxa);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void sacarTax(double valor){
        double taxa = valor * 0.05;
    }

}
