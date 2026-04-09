package dosw.bitacora.corte2.semana2.pagos.externo;

public class ApiTarjetaCredito {

    public String enviarCargo(double monto, String moneda) {
        System.out.println("[TarjetaCredito] Cargo de $" + monto + " " + moneda);
        return "APROBADO";
    }
}