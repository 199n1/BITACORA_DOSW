package dosw.bitacora.semana3.ejercicio2;

public class GameEngine {
    private Controller controller;
    private Game game;
    private UI ui;

    // Solo conoce ConsoleFactory, nunca PlayStation o Xbox directamente
    public GameEngine(ConsoleFactory factory) {
        this.controller = factory.createController();
        this.game = factory.createGame();
        this.ui = factory.createUI();
    }

    public void run() {
        controller.connect();
        game.start();
        ui.render();
    }
}
