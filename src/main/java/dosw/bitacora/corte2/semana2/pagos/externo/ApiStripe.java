package dosw.bitacora.corte2.semana2.pagos.externo;

public class ApiStripe {

    public boolean cobrar(int montoCentavos) {
        System.out.println("[Stripe] Cobrando " + montoCentavos + " centavos");
        return true;
    }
}