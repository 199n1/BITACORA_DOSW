package dosw.bitacora.corte1.semana1.Streams;

public class Transaction {
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