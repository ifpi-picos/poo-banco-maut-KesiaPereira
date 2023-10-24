public class ContaC extends Conta{

    private double chequeEspecial;

    public ContaC(int numAgencia, int numConta, Cliente cliente, double chequeEspecial) {
        super(numAgencia, numConta, cliente);
        this.chequeEspecial = chequeEspecial;
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

}
