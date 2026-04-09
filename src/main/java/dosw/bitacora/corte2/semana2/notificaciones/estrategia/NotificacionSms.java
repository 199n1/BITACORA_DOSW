package dosw.bitacora.corte2.semana2.notificaciones.estrategia;

public class NotificacionSms implements EstrategiaNotificacion {

    @Override
    public void enviar(String mensaje) {
        System.out.println("[SMS] " + mensaje);
    }
}