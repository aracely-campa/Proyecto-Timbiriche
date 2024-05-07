/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.game;

import domain.game.Board;
import domain.game.Game;
import domain.game.Player;
import mvc.player.PlayerModel;
import mvc.player.PlayerView;

/**
 *
 * @author luis-
 */
public class GameController {

    private GameModel gameModel;
    private GameView gameView;

    public GameController(GameModel gameModel, GameView gameView) {
        this.gameModel = gameModel;
        this.gameView = gameView;
    }

    public void createGame() {
        this.gameModel = new GameModel();
    }

    public GameModel getGameModel() {
        return gameModel;
    }

    public GameView getGameView() {
        return gameView;
    }

    public Player[] getPlayersOnGame() {
        return this.gameModel.getPlayersOnGame();
    }

    @Override
    public String toString() {
        return "GameController{" + "gameModel=" + gameModel + ", gameView=" + gameView + '}';
    }

}
