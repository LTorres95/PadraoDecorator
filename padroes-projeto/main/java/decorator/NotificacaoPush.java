package decorator;

public class NotificacaoPush extends NotificacaoDecorator {

    public NotificacaoPush(Notificacao notificacao) {
        super(notificacao);
    }

    @Override
    public void enviar(String mensagem) {
        notificacao.enviar(mensagem);
        System.out.println("[Push] " + mensagem);
    }

    @Override
    public String getDescricao() {
        return notificacao.getDescricao() + " + Push";
    }
}
