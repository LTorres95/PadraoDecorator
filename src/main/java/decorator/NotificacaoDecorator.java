package decorator;

public abstract class NotificacaoDecorator implements Notificacao {
    protected final Notificacao notificacao;

    protected NotificacaoDecorator(Notificacao notificacao) {
        this.notificacao = notificacao;
    }

    @Override
    public String getDescricao() {
        return notificacao.getDescricao();
    }
}
