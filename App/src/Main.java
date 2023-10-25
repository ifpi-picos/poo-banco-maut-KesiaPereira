import java.time.LocalDate;

public class Main {
    public static void main(String[] args){

        Notificacao notificacao = new Email();
        
        Cliente cliente = new Cliente("Fulano de Tal", "12345678910", LocalDate.of(2003, 04, 02));
        ContaP contaPoupanca = new ContaP("123456", "123456678", cliente, 1000.00, notificacao);

        contaPoupanca.deposito(1000.00);
        contaPoupanca.sacar(200.00);

        Conta contaDestino = new Conta("654321", "87654321", new Cliente("Ciclano de Tal", "10987654321", LocalDate.of(2001, 02, 04)), notificacao);
        contaPoupanca.transfer(contaDestino, 300.00);

        System.out.println("Saldo da poupanca: " + contaPoupanca.getSaldo());

        notificacao.enviaNotif("Deposito", 1000.00);
        notificacao.enviaNotif("Saque", 200.00);
        notificacao.enviaNotif("Transferencia", 300.00);
    }
}
