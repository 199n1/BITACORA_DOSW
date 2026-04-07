package dosw.bitacora.corte1.semana2.ejercicio1;

public class NotificacionEmail implements Notificacion {
    @Override
    public void enviar(String destinatario, String mensaje){
        System.out.println("[EMAIL]para:" + destinatario + "|" + mensaje);

    }
}
