package decorator;

public class NotificacaoApp implements Notificacao {

    @Override
    public void enviar(String mensagem) {
        System.out.println("[Aplicativo] " + mensagem);
    }

    @Override
    public String getDescricao() {
        return "Notificação no aplicativo";
    }

    public static class ExemploNotificacoes {

        public static void main(String[] args) {
            Notificacao notificacao = new NotificacaoEmail(
                    new NotificacaoPush(
                            new NotificacaoApp()
                    )
            );

            System.out.println("Canais: " + notificacao.getDescricao());
            notificacao.enviar("Seu pedido foi enviado.");
        }
    }
}
