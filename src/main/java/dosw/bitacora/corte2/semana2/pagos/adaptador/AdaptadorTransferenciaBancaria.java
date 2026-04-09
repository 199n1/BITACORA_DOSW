package dosw.bitacora.corte2.semana2.pagos.adaptador;

import dosw.bitacora.corte2.semana2.pagos.externo.ApiTransferenciaBancaria;

public class AdaptadorTransferenciaBancaria implements ProveedorPago {

    private final ApiTransferenciaBancaria apiTransferencia;

    public AdaptadorTransferenciaBancaria(ApiTransferenciaBancaria apiTransferencia) {
        this.apiTransferencia = apiTransferencia;
    }

    @Override
    public boolean procesarPago(double monto) {
        apiTransferencia.iniciarTransferencia(monto);
        return true;
    }
}