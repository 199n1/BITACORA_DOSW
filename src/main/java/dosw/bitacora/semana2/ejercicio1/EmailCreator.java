package dosw.bitacora.semana2.ejercicio1;

public class EmailCreator extends NotificacionCreator {
    @Override
    public Notificacion crearNotificacion() { return new NotificacionEmail(); }
}
