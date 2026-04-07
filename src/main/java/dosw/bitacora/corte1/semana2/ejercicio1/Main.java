package dosw.bitacora.corte1.semana2.ejercicio1;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<NotificacionCreator> canales = List.of(
                new EmailCreator(), new SMSCreator(), new PushCreator()
        );
        canales.forEach(c -> c.notificar("usuario@test.com", "Tu pedido llegó"));
    }
}
