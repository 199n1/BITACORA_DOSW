package dosw.bitacora.corte2.semana2.notificaciones.fabrica;

import dosw.bitacora.corte2.semana2.notificaciones.estrategia.EstrategiaNotificacion;
import dosw.bitacora.corte2.semana2.notificaciones.estrategia.NotificacionEmail;
import dosw.bitacora.corte2.semana2.notificaciones.estrategia.NotificacionPush;
import dosw.bitacora.corte2.semana2.notificaciones.estrategia.NotificacionSms;

public class FabricaNotificacion {

    public static EstrategiaNotificacion crear(String tipo) {
        return switch (tipo.toUpperCase()) {
            case "EMAIL" -> new NotificacionEmail();
            case "SMS"   -> new NotificacionSms();
            case "PUSH"  -> new NotificacionPush();
            default -> throw new IllegalArgumentException("Canal no reconocido: " + tipo);
        };
    }
}