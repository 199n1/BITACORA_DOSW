package dosw.bitacora.corte1.semana3.ejercicio1;

public class BankTransferPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Pago con Transferencia Bancaria por $ " + amount);
    }
}
