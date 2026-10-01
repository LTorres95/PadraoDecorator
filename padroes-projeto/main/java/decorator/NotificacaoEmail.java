package decorator;

public class NotificacaoEmail extends NotificacaoDecorator {

    public NotificacaoEmail(Notificacao notificacao) {
        super(notificacao);
    }

    @Override
    public void enviar(String mensagem) {
        notificacao.enviar(mensagem);
        System.out.println("[E-mail] " + mensagem);
    }

    @Override
    public String getDescricao() {
        return notificacao.getDescricao() + " + E-mail";
    }
}
