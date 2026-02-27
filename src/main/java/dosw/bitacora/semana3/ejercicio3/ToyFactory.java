package dosw.bitacora.semana3.ejercicio3;

public class ToyFactory {

    // Dirige los pasos, siempre en el mismo orden
    public void constructDoll(ToyDollBuilder builder) {
        builder.buildHead();
        builder.buildBody();
        builder.buildArms();
        builder.buildLegs();
        builder.addAccessories();
    }
}
