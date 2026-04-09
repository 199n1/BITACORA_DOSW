package dosw.bitacora.corte2.semana2.pagos;

import dosw.bitacora.corte2.semana2.pagos.adaptador.AdaptadorPayPal;
import dosw.bitacora.corte2.semana2.pagos.adaptador.AdaptadorStripe;
import dosw.bitacora.corte2.semana2.pagos.adaptador.AdaptadorTarjetaCredito;
import dosw.bitacora.corte2.semana2.pagos.adaptador.AdaptadorTransferenciaBancaria;
import dosw.bitacora.corte2.semana2.pagos.adaptador.ProveedorPago;
import dosw.bitacora.corte2.semana2.pagos.cadena.ManejadorValidacion;
import dosw.bitacora.corte2.semana2.pagos.cadena.ValidadorFraude;
import dosw.bitacora.corte2.semana2.pagos.cadena.ValidadorLimite;
import dosw.bitacora.corte2.semana2.pagos.cadena.ValidadorSaldo;
import dosw.bitacora.corte2.semana2.pagos.externo.ApiPayPal;
import dosw.bitacora.corte2.semana2.pagos.externo.ApiStripe;
import dosw.bitacora.corte2.semana2.pagos.externo.ApiTarjetaCredito;
import dosw.bitacora.corte2.semana2.pagos.externo.ApiTransferenciaBancaria;
import dosw.bitacora.corte2.semana2.pagos.servicio.ServicioPago;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServicioPagoTest {

    private ManejadorValidacion construirCadena(double saldo, double limite) {
        ManejadorValidacion validadorSaldo  = new ValidadorSaldo(saldo);
        ManejadorValidacion validadorFraude = new ValidadorFraude();
        ManejadorValidacion validadorLimite = new ValidadorLimite(limite);
        validadorSaldo.establecerSiguiente(validadorFraude).establecerSiguiente(validadorLimite);
        return validadorSaldo;
    }

    @Test
    void testPagoExitosoConPayPal() {
        ProveedorPago proveedor = new AdaptadorPayPal(new ApiPayPal());
        ServicioPago servicio   = new ServicioPago(proveedor, construirCadena(1000, 500));
        assertTrue(servicio.pagar(200));
    }

    @Test
    void testPagoExitosoConStripe() {
        ProveedorPago proveedor = new AdaptadorStripe(new ApiStripe());
        ServicioPago servicio   = new ServicioPago(proveedor, construirCadena(1000, 500));
        assertTrue(servicio.pagar(100));
    }

    @Test
    void testPagoExitosoConTarjetaCredito() {
        ProveedorPago proveedor = new AdaptadorTarjetaCredito(new ApiTarjetaCredito());
        ServicioPago servicio   = new ServicioPago(proveedor, construirCadena(1000, 500));
        assertTrue(servicio.pagar(300));
    }

    @Test
    void testPagoExitosoConTransferencia() {
        ProveedorPago proveedor = new AdaptadorTransferenciaBancaria(new ApiTransferenciaBancaria());
        ServicioPago servicio   = new ServicioPago(proveedor, construirCadena(1000, 500));
        assertTrue(servicio.pagar(400));
    }

    @Test
    void testRechazadoPorSaldoInsuficiente() {
        ProveedorPago proveedor = new AdaptadorPayPal(new ApiPayPal());
        ServicioPago servicio   = new ServicioPago(proveedor, construirCadena(50, 1000));
        assertFalse(servicio.pagar(200));
    }

    @Test
    void testRechazadoPorFraude() {
        ProveedorPago proveedor = new AdaptadorStripe(new ApiStripe());
        ServicioPago servicio   = new ServicioPago(proveedor, construirCadena(99999, 99999));
        assertFalse(servicio.pagar(9500));
    }

    @Test
    void testRechazadoPorLimiteTransaccion() {
        ProveedorPago proveedor = new AdaptadorPayPal(new ApiPayPal());
        ServicioPago servicio   = new ServicioPago(proveedor, construirCadena(5000, 300));
        assertFalse(servicio.pagar(400));
    }

    @Test
    void testCadenaConSoloUnValidador() {
        ProveedorPago proveedor       = new AdaptadorStripe(new ApiStripe());
        ManejadorValidacion soloSaldo = new ValidadorSaldo(10000);
        ServicioPago servicio         = new ServicioPago(proveedor, soloSaldo);
        assertTrue(servicio.pagar(5000));
    }

    @Test
    void testTodosLosAdaptadoresImplementanProveedorPago() {
        assertInstanceOf(ProveedorPago.class, new AdaptadorPayPal(new ApiPayPal()));
        assertInstanceOf(ProveedorPago.class, new AdaptadorStripe(new ApiStripe()));
        assertInstanceOf(ProveedorPago.class, new AdaptadorTarjetaCredito(new ApiTarjetaCredito()));
        assertInstanceOf(ProveedorPago.class, new AdaptadorTransferenciaBancaria(new ApiTransferenciaBancaria()));
    }
}