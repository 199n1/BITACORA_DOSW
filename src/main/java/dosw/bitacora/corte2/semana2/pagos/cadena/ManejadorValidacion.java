package dosw.bitacora.corte2.semana2.pagos.cadena;

public abstract class ManejadorValidacion {

    protected ManejadorValidacion siguiente;

    public ManejadorValidacion establecerSiguiente(ManejadorValidacion siguiente) {
        this.siguiente = siguiente;
        return siguiente;
    }

    public abstract boolean validar(double monto);

    protected boolean pasarAlSiguiente(double monto) {
        if (siguiente == null) return true;
        return siguiente.validar(monto);
    }
}