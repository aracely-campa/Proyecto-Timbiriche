/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.game;

/**
 *
 * @author luis-
 */
public class GameComponent {

    private GameModel gameModel = new GameModel();
    private GameView gameView = new GameView(gameModel);
    private GameController gameController = new GameController(gameModel, gameView);
    private static GameComponent gameComponent;

    public GameComponent() {
    }

    public GameComponent(GameController gameController, GameModel gameModel, GameView gameView) {
        this.gameController = gameController;
        this.gameModel = gameModel;
        this.gameView = gameView;
    }

    public GameController getGameController() {
        return gameController;
    }

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

    public GameModel getGameModel() {
        return gameModel;
    }

    public void setGameModel(GameModel gameModel) {
        this.gameModel = gameModel;
    }

    public GameView getGameView() {
        return gameView;
    }

    public void setGameView(GameView gameView) {
        this.gameView = gameView;
    }

    public static GameComponent getInstance() {
        if (gameComponent == null) {
            gameComponent = new GameComponent();
        }
        return gameComponent;
    }

}
