public class Conta {
    private final String numAgency;
    private final String numAccount;
    private Double saldo = 0.00;
    private Cliente cliente;
}

public Conta(String numAgency, String numAccount, Cliente cliente){
    this.numAgency = numAgency;
    this.numAccount = numAccount;
    this.cliente = cliente;
}

public double getSaldo(){
    return saldo;
}

public void depoist(double valor){
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
        contaFin.deposit(valor);
    } else {
        System.out.println("Saldo insuficiente.");
    }
}

