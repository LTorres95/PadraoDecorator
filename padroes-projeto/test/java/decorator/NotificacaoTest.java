package decorator;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NotificacaoTest {

    @Test
    void deveComporCanaisDeNotificacao() {
        Notificacao notificacao = new NotificacaoEmail(
                new NotificacaoPush(
                        new NotificacaoApp()
                )
        );

        assertEquals("Notificação no aplicativo + Push + E-mail", notificacao.getDescricao());
    }

    @Test
    void deveEnviarPelosCanaisCompostos() {
        Notificacao notificacao = new NotificacaoEmail(
                new NotificacaoPush(
                        new NotificacaoApp()
                )
        );
        ByteArrayOutputStream saida = new ByteArrayOutputStream();
        PrintStream saidaOriginal = System.out;

        try {
            System.setOut(new PrintStream(saida));
            notificacao.enviar("Seu pedido foi enviado.");
        } finally {
            System.setOut(saidaOriginal);
        }

        assertEquals(
                "[Aplicativo] Seu pedido foi enviado." + System.lineSeparator()
                        + "[Push] Seu pedido foi enviado." + System.lineSeparator()
                        + "[E-mail] Seu pedido foi enviado." + System.lineSeparator(),
                saida.toString()
        );
    }
}
