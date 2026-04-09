package dosw.bitacora.corte2.semana2.notificaciones;

import dosw.bitacora.corte2.semana2.notificaciones.estrategia.NotificacionEmail;
import dosw.bitacora.corte2.semana2.notificaciones.estrategia.NotificacionPush;
import dosw.bitacora.corte2.semana2.notificaciones.estrategia.NotificacionSms;
import dosw.bitacora.corte2.semana2.notificaciones.servicio.ServicioNotificacion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServicioNotificacionTest {

    private ServicioNotificacion servicio;

    @BeforeEach
    void inicializar() {
        servicio = ServicioNotificacion.obtenerInstancia();
    }

    @Test
    void testSingletonMismaInstancia() {
        ServicioNotificacion otra = ServicioNotificacion.obtenerInstancia();
        assertSame(servicio, otra);
    }

    @Test
    void testEstrategiaEmail() {
        servicio.establecerCanal("EMAIL");
        assertInstanceOf(NotificacionEmail.class, servicio.obtenerEstrategia());
    }

    @Test
    void testEstrategiaSms() {
        servicio.establecerCanal("SMS");
        assertInstanceOf(NotificacionSms.class, servicio.obtenerEstrategia());
    }

    @Test
    void testEstrategiaPush() {
        servicio.establecerCanal("PUSH");
        assertInstanceOf(NotificacionPush.class, servicio.obtenerEstrategia());
    }

    @Test
    void testCanalInvalidoLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> servicio.establecerCanal("TELEGRAM"));
    }

    @Test
    void testEnviarSinCanalLanzaExcepcion() {
        try {
            var campo = ServicioNotificacion.class.getDeclaredField("estrategia");
            campo.setAccessible(true);
            campo.set(servicio, null);
        } catch (Exception e) {
            fail("No se pudo resetear la estrategia");
        }
        assertThrows(IllegalStateException.class, () -> servicio.enviarNotificacion("Hola"));
    }

    @Test
    void testEnvioExitosoNoLanzaExcepcion() {
        servicio.establecerCanal("EMAIL");
        assertDoesNotThrow(() -> servicio.enviarNotificacion("Mensaje de prueba"));
    }
}