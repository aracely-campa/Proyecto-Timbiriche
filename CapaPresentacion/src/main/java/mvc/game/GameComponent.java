package mvc.game;

import domain.game.Player;
import mvc.board.BoardComponent;
import mvc.player.PlayerComponent;

public class GameComponent {

    private GameModel gameModel;
    private GameView gameView;
    private GameController gameController;
    private static GameComponent gameComponent;

    private BoardComponent boardComponent;
    private PlayerComponent playerComponent;

    public GameComponent() {
        this.gameModel = new GameModel();
        this.gameView = new GameView(gameModel);
        this.gameController = new GameController(gameModel, gameView);
    }


    public GameController getGameController() {
        return gameController;
    }

    public GameModel getGameModel() {
        return gameModel;
    }

    public GameView getGameView() {
        return gameView;
    }

    public PlayerComponent getPlayerComponent() {
        return playerComponent;
    }

    public BoardComponent getBoardComponent() {
        return boardComponent;
    }

    public Player[] getPlayersOnGame() {
        return this.gameController.getPlayersOnGame();
    }

    public void buildGame() {

    }

    public static GameComponent getInstance() {
        if (gameComponent == null) {
            gameComponent = new GameComponent();
        }
        return gameComponent;
    }

}
