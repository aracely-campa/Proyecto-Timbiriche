package domain.player;

import domain.game.Game;
import java.awt.Image;

/**
 *
 * @author arace La clase Player representa a un jugador en un juego.
 */
public class Player extends Game {

    private Image avatar; // La imagen del avatar del jugador
    private String name; // El nombre del jugador
    int score; // El puntaje del jugador
    int id; // El identificador del jugador
    private boolean isTurn; // El turno del jugador

    /**
     * Constructor de la clase Player.
     *
     * @param avatar La imagen del avatar del jugador.
     * @param name El nombre del jugador.
     * @param score El puntaje del jugador.
     * @param id El identificador del jugador.
     */
    public Player(Image avatar, String name, int score, int id) {
        this.avatar = avatar;
        this.name = name;
        this.score = score;
        this.id = id;
       
    }

    /**
     * Constructor por defecto de la clase Player.
     */
    public Player() {
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
     * Obtiene la imagen del avatar del jugador.
     *
     * @return La imagen del avatar del jugador.
     */
    public Image getAvatar() {
        return avatar;
    }

    /**
     * Establece la imagen del avatar del jugador.
     *
     * @param avatar La imagen del avatar del jugador.
     */
    public void setAvatar(Image avatar) {
        this.avatar = avatar;
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
     * @param isTurn El turno del jugador.
     */
    public void setTurn(boolean isTurn) {
        this.isTurn = isTurn;
    }

    /**
     * Obtiene el turno del jugador.
     *
     * @return El turno del jugador.
     */
    public boolean isTurn() {
        return isTurn;
    }

    /**
     * Devuelve una representación en cadena de texto del objeto Player.
     *
     * @return Una cadena que representa al objeto Player.
     */
    @Override
    public String toString() {
        return "Player{" + "avatar=" + avatar + ", name=" + name + ", score=" + score + ", id=" + id + '}';
    }
}
