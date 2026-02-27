package dosw.bitacora.semana2.ejercicio1;

public abstract class NotificacionCreator {
    public abstract Notificacion crearNotificacion();

    public void notificar(String destinatario, String mensaje) {
        Notificacion n = crearNotificacion();
        n.enviar(destinatario, mensaje);
    }
}
