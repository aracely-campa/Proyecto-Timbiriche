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
/**
 * GameController es el controlador en el patrón MVC, que gestiona las interacciones
 * entre el modelo del juego (GameModel) y la vista del juego (GameView).
 */
public class GameController {

    private GameModel gameModel; // El modelo del juego que contiene la lógica y el estado del juego.
    private GameView gameView; // La vista que presenta la representación visual del juego.

    /**
     * Constructor que inicializa el controlador con un modelo y una vista específicos.
     *
     * @param gameModel El modelo del juego que maneja la lógica del juego.
     * @param gameView La vista que muestra la interfaz de usuario del juego.
     */
    public GameController(GameModel gameModel, GameView gameView) {
        this.gameModel = gameModel;
        this.gameView = gameView;
    }

    /**
     * Crea un nuevo juego inicializando un nuevo modelo de juego.
     */
    public void createGame() {
        this.gameModel = new GameModel();
    }

    /**
     * Devuelve el modelo del juego.
     *
     * @return El modelo actual del juego.
     */
    public GameModel getGameModel() {
        return gameModel;
    }

    /**
     * Devuelve la vista del juego.
     *
     * @return La vista actual del juego.
     */
    public GameView getGameView() {
        return gameView;
    }

    /**
     * Obtiene la lista de jugadores actualmente en el juego desde el modelo.
     *
     * @return Un array de jugadores que están participando en el juego.
     */
    public Player[] getPlayersOnGame() {
        return this.gameModel.getPlayersOnGame();
    }

    /**
     * Proporciona una representación en cadena del estado actual del controlador,
     * incluyendo el estado del modelo y la vista.
     *
     * @return Una cadena que representa el estado del controlador.
     */
    @Override
    public String toString() {
        return "GameController{" + "gameModel=" + gameModel + ", gameView=" + gameView + '}';
    }

}
