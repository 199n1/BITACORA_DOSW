package dosw.bitacora.corte1.semana3.ejercicio4;

public class Main {
    public static void main(String[] args) {

        // Vehículo a gasolina (no necesita adaptador)
        GasPump pump = new GasPump();
        pump.supply(40);

        System.out.println("-----");

        // Vehículo eléctrico con cargador rápido
        FuelService fast = new FastChargerAdapter(new FastElectricCharger());
        fast.supply(40); // 40 * 8.0 = 320 kWh

        System.out.println("-----");

        // Vehículo eléctrico con cargador lento
        FuelService slow = new SlowChargerAdapter(new SlowElectricCharger());
        slow.supply(40); // 40 * 7.0 = 280 kWh
    }
}

