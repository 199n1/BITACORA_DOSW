package dosw.bitacora.semana3.ejercicio1;

public class PaypalPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Pago con PayPal por $ " + amount);
    }
}
