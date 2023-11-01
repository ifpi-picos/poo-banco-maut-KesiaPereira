import java.time.LocalDate;

public class Main {
    private static final String numeroAgencia1 = "123456";
    private static final String numeroConta1 = "123456678";

    private static final String numeroAgencia2 = "654321";
    private static final String numeroConta2 = "87654321";

    public static void main(String[] args) {

        // Chamando as notificações.
        Notificacao notificacao1 = new Email();
        Notificacao notificacao2 = new Sms();

        // Criação de novos clientes.
        Cliente cliente1 = new Cliente("Fulano de Tal", "12345678910", LocalDate.of(2003, 04, 02));
        Endereco endereco1 = new Endereco("R. La pra la", 123, "Centro", "Picos", "PI");

        Cliente cliente2 = new Cliente("Ciclano de Tal", "10987654321", LocalDate.of(2001, 02, 04));
        Endereco endereco2 = new Endereco("R. Aqui pra ca", 321, "Centro", "Picos", "PI");


        // não era pra ser permitido criar objetos do tipo Conta
        Conta conta2 = new Conta(numeroAgencia2, numeroConta2, cliente2, notificacao1);
        // os tipos das variáveis devem ser sempre do tipo mais genérico: nesse caso
        // Conta é mais genérico e ContaCorrente é mais específico
        Conta cp = new ContaPoupanca(numeroAgencia2, numeroConta2, cliente2, 1000, notificacao2);
        Conta cc = new ContaCorrente(numeroAgencia2, numeroConta2, cliente2, 100, notificacao2);
        Conta cc2 = new ContaCorrente(numeroAgencia1, numeroConta1, cliente1, 100, notificacao2);


        cc.deposito(100);
        System.out.println(cc.getSaldo());
        cc.sacar(50);
        System.out.println(cc.getSaldo());
        cc.transferencia(cc2, 10);
        cc.transferencia(cc2, 10);
        cc.transferencia(cc2, 10);
        cc.transferencia(cc2, 10);
        cc.transferencia(cc2, 10);
        // essa transação deveria ser executada com o valor do cheque especial
        cc.transferencia(cc2, 10);
        System.out.println(cc.getSaldo());
        System.out.println(cc.getTransacoes());

        cp.deposito(100); // deposito não foi adcionado a lista de transacoes
        System.out.println(cp.getSaldo());
        cp.sacar(10);
        System.out.println(cp.getSaldo());
        System.out.println(cp.getTransacoes());
    }
}
