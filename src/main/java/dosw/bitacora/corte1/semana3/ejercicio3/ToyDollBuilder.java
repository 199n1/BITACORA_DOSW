package dosw.bitacora.corte1.semana3.ejercicio3;

public interface ToyDollBuilder {
    void buildHead();
    void buildBody();
    void buildArms();
    void buildLegs();
    void addAccessories();
    ToyDoll getResult();
}
