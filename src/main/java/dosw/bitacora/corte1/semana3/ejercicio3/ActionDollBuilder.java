package dosw.bitacora.corte1.semana3.ejercicio3;

public class ActionDollBuilder implements ToyDollBuilder {
    private ToyDoll doll = new ToyDoll();

    @Override
    public void buildHead()       { doll.setHead("Cabeza con casco de combate"); }

    @Override
    public void buildBody()       { doll.setBody("Cuerpo musculoso con armadura"); }

    @Override
    public void buildArms()       { doll.setArms("Brazos articulados con guantes"); }

    @Override
    public void buildLegs()       { doll.setLegs("Piernas con botas militares"); }

    @Override
    public void addAccessories()  { doll.setHasAccessories(true); }

    @Override
    public ToyDoll getResult()    { return doll; }
}
