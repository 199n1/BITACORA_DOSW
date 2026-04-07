package dosw.bitacora.corte1.semana3.ejercicio2;

public class XboxFactory implements ConsoleFactory {
    @Override
    public Controller createController() { return new XboxController(); }

    @Override
    public Game createGame() { return new XboxGame(); }

    @Override
    public UI createUI() { return new XboxUI(); }
}
