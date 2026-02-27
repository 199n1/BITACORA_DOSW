package dosw.bitacora.semana2.ejercicio1;

public class SMSCreator extends NotificacionCreator {
    @Override
    public Notificacion crearNotificacion() { return new NotificacionSMS(); }
}
