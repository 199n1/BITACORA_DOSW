package dosw.bitacora.corte1.semana3.ejercicio4;

public class SlowChargerAdapter implements FuelService {
    private SlowElectricCharger charger;

    public SlowChargerAdapter(SlowElectricCharger charger) {
        this.charger = charger;
    }

    private double convertLitersToKWh(int liters) {
        return liters * 7.0;
    }

    @Override
    public void supply(int amount) {
        double kWh = convertLitersToKWh(amount);
        charger.slowCharge(kWh);
    }
}