package dosw.bitacora.semana3.ejercicio1;

public abstract class PaymentProcessor {

    // Factory Method: cada subclase implementa este método
    protected abstract Payment createPayment();

    // Usa el factory method internamente
    public void processPayment(double amount) {
        Payment payment = createPayment();
        payment.pay(amount);
    }
}
