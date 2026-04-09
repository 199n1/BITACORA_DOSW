package dosw.bitacora.corte2.semana2.pagos.adaptador;

import dosw.bitacora.corte2.semana2.pagos.externo.ApiPayPal;

public class AdaptadorPayPal implements ProveedorPago {

    private final ApiPayPal apiPayPal;

    public AdaptadorPayPal(ApiPayPal apiPayPal) {
        this.apiPayPal = apiPayPal;
    }

    @Override
    public boolean procesarPago(double monto) {
        apiPayPal.ejecutarPago(monto);
        return true;
    }
}