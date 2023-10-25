import java.time.LocalDate;

public class Main {
    private static final String numAgencia = "123456";
    private static final String numConta = "123456678";

    public static void main(String[] args){

        //Chamando as notificações.
        Notificacao notificacao = new Email();
        Notificacao notificacao2 = new Sms();
        
        //Criação de novo cliente.
        Cliente cliente = new Cliente("Fulano de Tal", "12345678910", LocalDate.of(2003, 04, 02));
        //Criação de nova conta.
        Conta conta = new Conta(numAgencia, numConta, cliente, notificacao);
        //Nova Conta poupança.
        ContaP contaPoupanca = new ContaP(numAgencia, numConta, cliente, 1000.00, notificacao2);
        //Nova conta corrente.
        ContaC contaCorrente = new ContaC("123456", "123456678", cliente, 600.00, notificacao2);
        //Novo endereço.
        Endereco endereco = new Endereco("R. La pra la", 123, "Centro", "Picos", "PI");

        conta.setSaldo(5000.00);
        
        //Verificação de dados.
        System.out.println("Dados do Cliente: " + cliente);
        System.out.println("Dados da Conta Poupanca: " + contaPoupanca);
        System.out.println("Dados da Conta Corrente: " + contaCorrente);
        System.out.println("Endreco do Cliente: " + endereco);

        //Criação da conta destino.
        Conta contaDestino = new Conta("654321", "87654321", new Cliente("Ciclano de Tal", "10987654321", LocalDate.of(2001, 02, 04)), notificacao);

        //Teste de depósito, saque e tranferencia.
        contaPoupanca.depositarRend(1000.00);
        contaPoupanca.sacar(200.00);
        contaCorrente.transfer(contaDestino, 500.00);

        //Teste de erro.
        contaPoupanca.transfer(contaDestino, 1600.00);

        System.out.println("Saldo da poupanca: " + contaPoupanca.getSaldo());
        System.out.println("Saldo da corrente: " + contaCorrente.getSaldo());

        //Notificações pelo email.
        notificacao.enviaNotif("Deposito", 1000.00);
        notificacao.enviaNotif("Saque", 200.00);
        notificacao.enviaNotif("Transferencia", 300.00);
        //Notificações pelo sms.
        notificacao2.enviaNotif("Deposito", 1000.00);
        notificacao2.enviaNotif("Saque", 200.00);
        notificacao2.enviaNotif("Transferencia", 300.00);
    }
}
