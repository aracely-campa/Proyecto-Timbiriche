package domain.game;

import domain.game.Game;
import java.awt.Image;

/**
 *
 * @author arace La clase Player representa a un jugador en un juego.
 */
public class Player extends Game {

    private String name; // El nombre del jugador
    int score; // El puntaje del jugador
    Integer id; // El identificador del jugador
    private boolean turnoJugador; // El turno del jugador


    /**
     * Constructor por defecto de la clase Player.
     */
    public Player() {
    }

    /**
     * Constructor de la clase Player.
     *
     * @param name El nombre del jugador.
     * @param score El puntaje del jugador.
     * @param id El identificador del jugador.
     */
    public Player( String name, int score, int id) {
        this.name = name;
        this.score = score;
        this.id = id;
       
    }

    /**
     * Obtiene el nombre del jugador.
     *
     * @return El nombre del jugador.
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el nombre del jugador.
     *
     * @param name El nombre del jugador.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtiene el puntaje del jugador.
     *
     * @return El puntaje del jugador.
     */
    public int getScore() {
        return score;
    }

    /**
     * Establece el puntaje del jugador.
     *
     * @param score El puntaje del jugador.
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Obtiene el identificador del jugador.
     *
     * @return El identificador del jugador.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador del jugador.
     *
     * @param id El identificador del jugador.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Establece el turno del jugador.
     *
     * @param turnoJugador El turno del jugador.
     */
    public void setTurn(boolean turnoJugador) {
        this.turnoJugador = turnoJugador;
    }

    /**
     * Obtiene el turno del jugador.
     *
     * @return El turno del jugador.
     */
    public boolean haveTurn() {
        return turnoJugador;
    }

    /**
     * Devuelve una representación en cadena de texto del objeto Player.
     *
     * @return Una cadena que representa al objeto Player.
     */
    @Override
    public String toString() {
        return "Player{" + ", name=" + name + ", score=" + score + ", id=" + id + '}';
    }
}
