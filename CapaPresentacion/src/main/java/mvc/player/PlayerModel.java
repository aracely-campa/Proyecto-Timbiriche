/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.player;

import domain.game.Player;
import enums.ImagesSourcers;

/**
 *
 * @author luis-
 */
public class PlayerModel {
// Atributos relacionados con la posición y tamaño de la representación visual del jugador.

    private Player player;

    private String playerAvatarPath;

    private String playerName;

    public int playerTurn;

    private Integer coordenadaX;

    private Integer coordenadaY;

    private Integer coordenadaNombreX;

    private Integer coordenadaNombreY;

    private Integer anchoImagenJugador;

    private Integer largoImagenJugador;

    /**
     * Constructor por defecto que crea un nuevo jugador sin información
     * inicial.
     */
    public PlayerModel() {
        this.player = new Player();
    }

    /**
     * Constructor que inicializa el modelo del jugador con información
     * específica.
     *
     * @param player Objeto jugador.
     * @param playerAvatarPath Ruta del avatar del jugador.
     */
    public PlayerModel(Player player, String playerAvatarPath) {
        this.player = player;
        this.playerAvatarPath = playerAvatarPath;
        this.playerName = this.player.getName();
    }

    /**
     * Constructor completo que inicializa todos los atributos del modelo del
     * jugador.
     *
     * @param player Objeto jugador.
     * @param playerAvatarPath Ruta del avatar del jugador.
     * @param playerName Nombre del jugador.
     * @param coordenadaX Posición X del jugador en la interfaz.
     * @param coordenadaY Posición Y del jugador en la interfaz.
     * @param coordenadaNombreX Posición X del nombre del jugador en la
     * interfaz.
     * @param coordenadaNombreY Posición Y del nombre del jugador en la
     * interfaz.
     * @param anchoImagenJugador Ancho de la imagen del jugador.
     * @param largoImagenJugador Largo de la imagen del jugador.
     */
    public PlayerModel(Player player, String playerAvatarPath, String playerName, Integer coordenadaX, Integer coordenadaY, Integer coordenadaNombreX, Integer coordenadaNombreY, Integer anchoImagenJugador, Integer largoImagenJugador) {
        this.player = player;
        this.playerAvatarPath = playerAvatarPath;
        this.playerName = playerName;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.coordenadaNombreX = coordenadaNombreX;
        this.coordenadaNombreY = coordenadaNombreY;
        this.anchoImagenJugador = anchoImagenJugador;
        this.largoImagenJugador = largoImagenJugador;

    }

    /**
     * Inicializa valores predeterminados para las propiedades del jugador.
     */
    public void inicializarValores() {

        this.anchoImagenJugador = 100;
        this.largoImagenJugador = 100;

        this.coordenadaX = 50;
        this.coordenadaY = 80;
        this.coordenadaNombreX = 100;
        this.coordenadaNombreY = 50;

    }

    /**
     * Método estático para obtener la imagen del avatar basada en el nombre del
     * avatar.
     *
     * @param name Nombre del avatar.
     * @return Ruta de la imagen del avatar.
     */
    public static String getAvatarImage(String name) {
        return switch (name) {
            case "Among_us_Blue" ->
                ImagesSourcers.getAvatarBlue();
            case "Among_us_Red" ->
                ImagesSourcers.getAvatarRed();
            case "Among_us_Green" ->
                ImagesSourcers.getAvatarGreen();
            case "Among_us_Yellow" ->
                ImagesSourcers.getAvatarYellow();
            default ->
                null;
        };
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setAvatarPath(String avatarPath) {
        this.playerAvatarPath = avatarPath;
    }

    public String getAvatarPath() {
        return playerAvatarPath;
    }

    public String getName() {
        return playerName;
    }

    public void setName(String name) {
        this.playerName = name;
    }

    public String getPlayerAvatarPath() {
        return playerAvatarPath;
    }

    public void setPlayerAvatarPath(String playerAvatarPath) {
        this.playerAvatarPath = playerAvatarPath;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(int playerTurn) {
        this.playerTurn = playerTurn;
    }

    public Integer getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(Integer coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public Integer getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(Integer coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public Integer getCoordenadaNombreX() {
        return coordenadaNombreX;
    }

    public void setCoordenadaNombreX(Integer coordenadaNombreX) {
        this.coordenadaNombreX = coordenadaNombreX;
    }

    public Integer getCoordenadaNombreY() {
        return coordenadaNombreY;
    }

    public void setCoordenadaNombreY(Integer coordenadaNombreY) {
        this.coordenadaNombreY = coordenadaNombreY;
    }

    public Integer getAnchoImagenJugador() {
        return anchoImagenJugador;
    }

    public void setAnchoImagenJugador(Integer anchoImagenJugador) {
        this.anchoImagenJugador = anchoImagenJugador;
    }

    public Integer getLargoImagenJugador() {
        return largoImagenJugador;
    }

    public void setLargoImagenJugador(Integer largoImagenJugador) {
        this.largoImagenJugador = largoImagenJugador;
    }

}
