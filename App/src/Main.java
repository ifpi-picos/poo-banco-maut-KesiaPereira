import java.time.LocalDate;

public class Main {
    private static final String numeroAgencia1 = "123456";
    private static final String numeroConta1 = "123456678";

    private static final String numeroAgencia2 = "654321";
    private static final String numeroConta2 = "87654321";

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
        Conta conta1 = new Conta(numeroAgencia1, numeroConta1, cliente1, notificacao1);
            ContaPoupanca contaPoupanca1 = new ContaPoupanca(numeroAgencia1, numeroConta1, cliente1, 1000, notificacao2);
            ContaCorrente contaCorrente1 = new ContaCorrente(numeroAgencia1, numeroConta1, cliente1, 600, notificacao2);

        Conta conta2 = new Conta(numeroAgencia2, numeroConta2, cliente2, notificacao1);
            ContaPoupanca contaPoupanca2 = new ContaPoupanca(numeroAgencia2, numeroConta2, cliente2, 1000, notificacao2);
            ContaCorrente contaCorrente2 = new ContaCorrente(numeroAgencia2, numeroConta2, cliente2, 600, notificacao2);


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
        contaCorrente1.transferencia(contaCorrente2, 200);
        contaCorrente2.transferencia(contaCorrente1, 200);
        System.out.println("-------------------------------------------");

        //Teste de erro.
        System.out.println("-------------------------------------------");
        contaPoupanca2.transferencia(contaPoupanca1, 30000);
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
        notificacao1.enviarNotificacao("Deposito_Poupanca", 1000.00);
        notificacao1.enviarNotificacao("Saque_Poupanca", 200.00);
        notificacao1.enviarNotificacao("Deposito_Corrente", 500);
        notificacao1.enviarNotificacao("Transferenciaencia_Corrente", 200.00);
        System.out.println("-------------------------------------------");
        //Notificações pelo sms.
        notificacao2.enviarNotificacao("Deposito_Poupanca", 500.00);
        notificacao2.enviarNotificacao("Saque_Poupanca", 100.00);
        notificacao2.enviarNotificacao("Deposito_Corrente", 250.00);
        notificacao2.enviarNotificacao("Transferenciaencia_Corrente", 200.00);
        System.out.println("-------------------------------------------");
        System.out.println("-------------------------------------------");
    }
}
