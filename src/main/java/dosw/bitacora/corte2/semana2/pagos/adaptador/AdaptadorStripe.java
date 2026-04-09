package dosw.bitacora.corte2.semana2.pagos.adaptador;

import dosw.bitacora.corte2.semana2.pagos.externo.ApiStripe;

public class AdaptadorStripe implements ProveedorPago {

    private final ApiStripe apiStripe;

    public AdaptadorStripe(ApiStripe apiStripe) {
        this.apiStripe = apiStripe;
    }

    @Override
    public boolean procesarPago(double monto) {
        int centavos = (int) (monto * 100);
        return apiStripe.cobrar(centavos);
    }
}