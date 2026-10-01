package decorator;

public class NotificacaoSMS extends NotificacaoDecorator {

    public NotificacaoSMS(Notificacao notificacao) {
        super(notificacao);
    }

    @Override
    public void enviar(String mensagem) {
        notificacao.enviar(mensagem);
        System.out.println("[SMS] " + mensagem);
    }

    @Override
    public String getDescricao() {
        return notificacao.getDescricao() + " + SMS";
    }
}
