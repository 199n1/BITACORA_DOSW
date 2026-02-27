package dosw.bitacora.semana3.ejercicio1;

public class CreditCardPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Pago con Tarjeta de Credito por $ " + amount);
    }
}
