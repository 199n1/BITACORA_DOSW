package dosw.bitacora.semana2.ejercicio1;

public class PushCreator extends NotificacionCreator {
    @Override
    public Notificacion crearNotificacion() { return new NotificacionPush(); }
}
