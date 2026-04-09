package dosw.bitacora.corte2.semana2.pagos.adaptador;

import dosw.bitacora.corte2.semana2.pagos.externo.ApiTarjetaCredito;

public class AdaptadorTarjetaCredito implements ProveedorPago {

    private final ApiTarjetaCredito apiTarjetaCredito;

    public AdaptadorTarjetaCredito(ApiTarjetaCredito apiTarjetaCredito) {
        this.apiTarjetaCredito = apiTarjetaCredito;
    }

    @Override
    public boolean procesarPago(double monto) {
        String resultado = apiTarjetaCredito.enviarCargo(monto, "COP");
        return "APROBADO".equals(resultado);
    }
}