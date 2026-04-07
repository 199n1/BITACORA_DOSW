package dosw.bitacora.corte1.semana3.ejercicio1;

public abstract class PaymentProcessor {

    // Factory Method: cada subclase implementa este método
    protected abstract Payment createPayment();

    // Usa el factory method internamente
    public void processPayment(double amount) {
        Payment payment = createPayment();
        payment.pay(amount);
    }
}
