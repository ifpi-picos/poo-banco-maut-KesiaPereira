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

}
