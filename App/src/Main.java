import java.time.LocalDate;

public class Main {
    private static final String numAgencia1 = "123456";
    private static final String numConta1 = "123456678";

    private static final String numAgencia2 = "654321";
    private static final String numConta2 = "87654321";

    public static void main(String[] args){

        //Chamando as notificações.
        Notificacao notificacao1 = new Email();
        Notificacao notificacao2 = new Sms();
        
        //Criação de novos clientes.
        Cliente cliente1 = new Cliente("Fulano de Tal", "12345678910", LocalDate.of(2003, 04, 02));
                Endereco endereco1 = new Endereco("R. La pra la", 123, "Centro", "Picos", "PI");

        Cliente cliente2 = new Cliente("Ciclano de Tal", "10987654321", LocalDate.of(2001, 02, 04));
                Endereco endereco2 = new Endereco("R. Aqui pra ca", 321, "Centro", "Picos", "PI");


        //Criação de novas contas + contas poupança + contas corrente.
        Conta conta1 = new Conta(numAgencia1, numConta1, cliente1, notificacao1);
            ContaP contaPoupanca1 = new ContaP(numAgencia1, numConta1, cliente1, 1000, notificacao2);
            ContaC contaCorrente1 = new ContaC(numAgencia1, numConta1, cliente1, 600, notificacao2);

        Conta conta2 = new Conta(numAgencia2, numConta2, cliente2, notificacao1);
            ContaP contaPoupanca2 = new ContaP(numAgencia2, numConta2, cliente2, 1000, notificacao2);
            ContaC contaCorrente2 = new ContaC(numAgencia2, numConta2, cliente2, 600, notificacao2);


        //Verificação de dados.
        System.out.println("-------------------------------------------");
        System.out.println("-------------------------------------------");
        System.out.println("Dados do Cliente: " + cliente1);
        System.out.println("-------------------------------------------");
        System.out.println("Dados da Conta Poupanca: " + contaPoupanca1);
        System.out.println("-------------------------------------------");
        System.out.println("Dados da Conta Corrente: " + contaCorrente1);
        System.out.println("-------------------------------------------");
        System.out.println("Endreco do Cliente: " + endereco1);
        System.out.println("-------------------------------------------");

        System.out.println("-------------------------------------------");
        System.out.println("Dados do Cliente: " + cliente2);
        System.out.println("-------------------------------------------");
        System.out.println("Dados da Conta Poupanca: " + contaPoupanca2);
        System.out.println("-------------------------------------------");
        System.out.println("Dados da Conta Corrente: " + contaCorrente2);
        System.out.println("-------------------------------------------");
        System.out.println("Endreco do Cliente: " + endereco2);
        System.out.println("-------------------------------------------");

        //Teste de depósito, saque e tranferencia.
        System.out.println("-------------------------------------------");
        contaPoupanca1.deposito(1000);
        contaPoupanca2.deposito(500);
        contaPoupanca1.sacar(200);
        contaPoupanca2.sacar(100);
        contaCorrente1.deposito(500);
        contaCorrente2.deposito(250);
        contaCorrente1.transfer(contaCorrente2, 200);
        contaCorrente2.transfer(contaCorrente1, 200);
        System.out.println("-------------------------------------------");

        //Teste de erro.
        System.out.println("-------------------------------------------");
        contaPoupanca2.transfer(contaPoupanca1, 30000);
        System.out.println("-------------------------------------------");

        //Verificando saldos.
        System.out.println("-------------------------------------------");
        System.out.println("Cliente: " +  cliente1.getNome() +
                           "\nSaldo da poupanca: " + contaPoupanca1.getSaldo() +
                           "\nSaldo da corrente: " + contaCorrente1.getSaldo());
        System.out.println("-------------------------------------------");
        System.out.println("Cliente: " +  cliente2.getNome() +
                           "\nSaldo da poupanca: " + contaPoupanca2.getSaldo() +
                           "\nSaldo da corrente: " + contaCorrente2.getSaldo());
        System.out.println("-------------------------------------------");

        //Notificações pelo email.
        System.out.println("-------------------------------------------");
        notificacao1.enviaNotif("Deposito_Poupanca", 1000.00);
        notificacao1.enviaNotif("Saque_Poupanca", 200.00);
        notificacao1.enviaNotif("Deposito_Corrente", 500);
        notificacao1.enviaNotif("Transferencia_Corrente", 200.00);
        System.out.println("-------------------------------------------");
        //Notificações pelo sms.
        notificacao2.enviaNotif("Deposito_Poupanca", 500.00);
        notificacao2.enviaNotif("Saque_Poupanca", 100.00);
        notificacao2.enviaNotif("Deposito_Corrente", 250.00);
        notificacao2.enviaNotif("Transferencia_Corrente", 200.00);
        System.out.println("-------------------------------------------");
        System.out.println("-------------------------------------------");
    }
}
