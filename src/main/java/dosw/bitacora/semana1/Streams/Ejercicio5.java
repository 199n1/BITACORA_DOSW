package dosw.bitacora.semana1.Streams;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

class Transaction {
    String id;
    double amount;
    boolean approved;

    public Transaction(String id, double amount, boolean approved) {
        this.id = id;
        this.amount = amount;
        this.approved = approved;
    }

    public boolean isApproved() { return approved; }

    @Override
    public String toString() {
        return "Transaction{id='" + id + "', amount=" + amount + ", approved=" + approved + "}";
    }
}

public class Ejercicio5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Transaction> transactions = new ArrayList<>();

        System.out.print("¿Cuántas transacciones? ");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("Transacción " + (i + 1) + ":");
            System.out.print("ID: ");
            String id = scanner.nextLine();

            System.out.print("Monto: ");
            double amount = Double.parseDouble(scanner.nextLine());

            System.out.print("Aprobada (true/false): ");
            boolean approved = Boolean.parseBoolean(scanner.nextLine());

            transactions.add(new Transaction(id, amount, approved));
        }

        boolean hasUnapproved = transactions.stream()
                .peek(t -> System.out.println("Procesando: " + t))
                .anyMatch(t -> !t.isApproved());

        boolean isValid = !hasUnapproved;

        System.out.println("¿El lote de transacciones es válido?: " + isValid);
        scanner.close();
    }
}
