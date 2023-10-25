public class Sms implements Notificacao{
    @Override
    public void enviarNotificacao(String operacao, double valor){
        System.out.println("Enviar notificacao por sms");
        System.out.println("Operacao desejada: " + operacao);
        System.out.println("Valor: " + valor);
        System.out.println("Notificacao enviada!");
    }
}