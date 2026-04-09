package dosw.bitacora.corte2.semana2.pagos.cadena;

public class ValidadorFraude extends ManejadorValidacion {

    private static final double UMBRAL_FRAUDE = 9000.0;

    @Override
    public boolean validar(double monto) {
        System.out.println("[Validacion] Verificando fraude...");
        if (monto > UMBRAL_FRAUDE) {
            System.out.println("[RECHAZADO] Monto sospechoso: $" + monto);
            return false;
        }
        System.out.println("[OK] Sin senales de fraude");
        return pasarAlSiguiente(monto);
    }
}