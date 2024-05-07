/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.game;

import domain.game.Player;
import mvc.board.BoardComponent;
import mvc.player.PlayerComponent;

/**
 *
 * @author luis-
 */
public class GameComponent {

    private GameModel gameModel = new GameModel();
    private GameView gameView = new GameView(gameModel);
    private GameController gameController = new GameController(gameModel, gameView);
    private static GameComponent gameComponent;

    private BoardComponent boardComponent;
    private PlayerComponent playerComponent;

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

    public GameModel getGameModel() {
        return gameModel;
    }

    public GameView getGameView() {
        return gameView;
    }

    public PlayerComponent getPlayerComponent(){
        return playerComponent;
    }
    
    public BoardComponent getBoardComponent() {
        return boardComponent;
    }

    public Player[] getPlayersOnGame(){
      return  this.gameController.getPlayersOnGame();
    }
    
    
    public void buildGame(){
        
    }
    
    
    public static GameComponent getInstance() {
        if (gameComponent == null) {
            gameComponent = new GameComponent();
        }
        return gameComponent;
    }

}
