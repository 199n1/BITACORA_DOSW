package dosw.bitacora.corte1.semana3.ejercicio2;

public class PlayStationFactory implements ConsoleFactory {
    @Override
    public Controller createController() { return new PlayStationController(); }

    @Override
    public Game createGame() { return new PlayStationGame(); }

    @Override
    public UI createUI() { return new PlayStationUI(); }
}
