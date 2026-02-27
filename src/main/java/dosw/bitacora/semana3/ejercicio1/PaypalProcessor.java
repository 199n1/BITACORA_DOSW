package dosw.bitacora.semana3.ejercicio1;
public class PaypalProcessor extends PaymentProcessor {
    @Override
    protected Payment createPayment() {
        return new PaypalPayment();
    }
}
