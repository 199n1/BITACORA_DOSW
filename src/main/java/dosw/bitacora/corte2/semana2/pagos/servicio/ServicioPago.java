package dosw.bitacora.corte2.semana2.pagos.servicio;

import dosw.bitacora.corte2.semana2.pagos.adaptador.ProveedorPago;
import dosw.bitacora.corte2.semana2.pagos.cadena.ManejadorValidacion;

public class ServicioPago {

    private final ProveedorPago proveedor;
    private final ManejadorValidacion cadenaValidacion;

    public ServicioPago(ProveedorPago proveedor, ManejadorValidacion cadenaValidacion) {
        this.proveedor = proveedor;
        this.cadenaValidacion = cadenaValidacion;
    }

    public boolean pagar(double monto) {
        System.out.println("=== Procesando pago de $" + monto + " ===");
        boolean valido = cadenaValidacion.validar(monto);
        if (!valido) {
            System.out.println("=== Pago RECHAZADO ===");
            return false;
        }
        boolean resultado = proveedor.procesarPago(monto);
        System.out.println("=== Pago " + (resultado ? "EXITOSO" : "FALLIDO") + " ===");
        return resultado;
    }
}