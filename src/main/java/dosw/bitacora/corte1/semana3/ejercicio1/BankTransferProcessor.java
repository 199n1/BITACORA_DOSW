package dosw.bitacora.corte1.semana3.ejercicio1;

public class BankTransferProcessor extends PaymentProcessor {
    @Override
    protected Payment createPayment() {
        return new BankTransferPayment();
    }
}
