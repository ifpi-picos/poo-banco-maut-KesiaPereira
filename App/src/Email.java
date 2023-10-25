public class Email implements Notificacao{
    @Override
    public void enviaNotif(String operacao, double valor){
        System.out.println("Enviar notificacao por email");
        System.out.println("Operacao desejada: " + operacao);
        System.out.println("Valor: " + valor);
        System.out.println("Notificacao enviada!");
    }
}