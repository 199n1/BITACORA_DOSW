package dosw.bitacora.corte2.semana2.notificaciones.servicio;

import dosw.bitacora.corte2.semana2.notificaciones.estrategia.EstrategiaNotificacion;
import dosw.bitacora.corte2.semana2.notificaciones.fabrica.FabricaNotificacion;

public class ServicioNotificacion {

    private static volatile ServicioNotificacion instancia;
    private EstrategiaNotificacion estrategia;

    private ServicioNotificacion() {}

    public static ServicioNotificacion obtenerInstancia() {
        if (instancia == null) {
            synchronized (ServicioNotificacion.class) {
                if (instancia == null) {
                    instancia = new ServicioNotificacion();
                }
            }
        }
        return instancia;
    }

    public void establecerCanal(String tipo) {
        this.estrategia = FabricaNotificacion.crear(tipo);
    }

    public void enviarNotificacion(String mensaje) {
        if (estrategia == null) {
            throw new IllegalStateException("Debe configurar un canal antes de enviar.");
        }
        estrategia.enviar(mensaje);
    }

    public EstrategiaNotificacion obtenerEstrategia() {
        return estrategia;
    }
}