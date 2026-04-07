package dosw.bitacora.corte1.semana3.ejercicio3;

public class ClassicDollBuilder implements ToyDollBuilder {
    private ToyDoll doll = new ToyDoll();

    @Override
    public void buildHead()       { doll.setHead("Cabeza con cabello rubio largo"); }

    @Override
    public void buildBody()       { doll.setBody("Cuerpo con vestido rosa"); }

    @Override
    public void buildArms()       { doll.setArms("Brazos suaves con manos pequeñas"); }

    @Override
    public void buildLegs()       { doll.setLegs("Piernas con zapatillas"); }

    @Override
    public void addAccessories()  { doll.setHasAccessories(false); }

    @Override
    public ToyDoll getResult()    { return doll; }
}
