/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.game;

import domain.game.Board;
import domain.game.Game;
import domain.game.Player;
import domainClasses.DomainBoard;
import domainClasses.DomainGame;

/**
 *
 * @author luis-
 */
/**
 * GameModel gestiona el estado y la lógica del juego, manteniendo información como si el juego ha comenzado,
 * el tamaño de la partida, y las interacciones con otros componentes del dominio como DomainGame y DomainBoard.
 */
public class GameModel {

    private DomainGame domainGame; // Componente de dominio que gestiona la lógica específica del juego.
    private DomainBoard domainBoard; // Componente de dominio que gestiona el tablero del juego.

    private boolean gameStarted = false; // Indica si el juego ha comenzado.
    private Integer tamanoDePartida; // Tamaño de la partida, puede influir en la configuración del juego.

    /**
     * Constructor con tamaño de partida, inicializa los componentes del juego y establece el tamaño de la partida.
     *
     * @param tamanoDePartida El tamaño inicial de la partida.
     */
    public GameModel(Integer tamanoDePartida) {
        this.domainGame = new DomainGame();
        this.domainBoard = new DomainBoard();
        this.tamanoDePartida = tamanoDePartida;
    }

    /**
     * Constructor sin parámetros, útil para cuando no se necesita configurar inicialmente el tamaño de la partida.
     */
    public GameModel() {
    }

    /**
     * Crea o reinicia un juego, configurando o reconfigurando los componentes necesarios.
     */
    public void createGame() {
        // Aquí se deberían inicializar o reiniciar los componentes del juego según sea necesario.
    }

    /**
     * Obtiene el componente DomainGame actual.
     *
     * @return El componente DomainGame.
     */
    public DomainGame getDomainGame() {
        return domainGame;
    }

    /**
     * Establece un nuevo componente DomainGame.
     *
     * @param domainGame El nuevo componente DomainGame.
     */
    public void setDomainGame(DomainGame domainGame) {
        this.domainGame = domainGame;
    }

    /**
     * Obtiene el componente DomainBoard actual.
     *
     * @return El componente DomainBoard.
     */
    public DomainBoard getDomainBoard() {
        return domainBoard;
    }

    /**
     * Establece un nuevo componente DomainBoard.
     *
     * @param domainBoard El nuevo componente DomainBoard.
     */
    public void setDomainBoard(DomainBoard domainBoard) {
        this.domainBoard = domainBoard;
    }

    /**
     * Devuelve si el juego ha comenzado.
     *
     * @return true si el juego ha comenzado, false en caso contrario.
     */
    public boolean isGameStarted() {
        return gameStarted;
    }

    /**
     * Establece el estado de inicio del juego.
     *
     * @param gameStarted true para indicar que el juego ha comenzado, false de lo contrario.
     */
    public void setGameStarted(boolean gameStarted) {
        this.gameStarted = gameStarted;
    }

    /**
     * Obtiene el tamaño de la partida.
     *
     * @return El tamaño de la partida.
     */
    public Integer getTamanoDePartida() {
        return tamanoDePartida;
    }

    /**
     * Establece el tamaño de la partida.
     *
     * @param tamanoDePartida El nuevo tamaño de la partida.
     */
    public void setTamanoDePartida(Integer tamanoDePartida) {
        this.tamanoDePartida = tamanoDePartida;
    }
    
    /**
     * Obtiene la lista de jugadores actualmente en el juego.
     *
     * @return Array de jugadores que están participando en el juego.
     */
    public Player[] getPlayersOnGame(){
        return this.domainGame.getPlayersOnGame();
    }

    /**
     * Proporciona una representación en cadena del estado actual del modelo del juego.
     *
     * @return Cadena que representa el estado del modelo del juego.
     */
    @Override
    public String toString() {
        return "GameModel{" + ", gameStarted=" + gameStarted + ", tamanoDePartida=" + tamanoDePartida + '}';
    }
}
