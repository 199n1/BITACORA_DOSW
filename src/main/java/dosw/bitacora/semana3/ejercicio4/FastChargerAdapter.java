package dosw.bitacora.semana3.ejercicio4;

public class FastChargerAdapter implements FuelService {
    private FastElectricCharger charger;

    public FastChargerAdapter(FastElectricCharger charger) {
        this.charger = charger;
    }

    private double convertLitersToKWh(int liters) {
        return liters * 8.0;
    }

    @Override
    public void supply(int amount) {
        double kWh = convertLitersToKWh(amount);
        charger.fastCharge(kWh);
    }
}
