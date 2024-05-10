/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.player;

import domain.game.Player;
import game.GameClass;
import interfaces.MatchObserver;
import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

/**
 * PlayerController se encarga de coordinar las interacciones entre el modelo de
 * datos del jugador (PlayerModel) y la vista del jugador (PlayerView). También
 * notifica a los observadores sobre los cambios relevantes en el estado del
 * jugador.
 */
public class PlayerController {

    private PlayerModel playerModel; // Modelo que gestiona los datos y estado del jugador.
    private PlayerView playerView; // Vista que representa visualmente al jugador.
    private final List<MatchObserver> observers = new ArrayList<>(); // Lista de observadores interesados en los cambios del jugador.

    /**
     * Constructor de PlayerController que inicializa el controlador con un
     * modelo y una vista específicos.
     *
     * @param playerModel El modelo del jugador que contiene los datos y la
     * lógica del estado.
     * @param playerView La vista del jugador que maneja la representación
     * visual.
     */
    public PlayerController(PlayerModel playerModel, PlayerView playerView) {
        this.playerModel = playerModel;
        this.playerView = playerView;
    }

    /**
     * Devuelve el modelo del jugador asociado con este controlador.
     *
     * @return El modelo del jugador.
     */
    public PlayerModel getPlayerModel() {
        return playerModel;
    }

    /**
     * Devuelve la vista del jugador asociada con este controlador.
     *
     * @return La vista del jugador.
     */
    public PlayerView getPlayerView() {
        return playerView;
    }

    /**
     * Actualiza la vista del jugador para reflejar cualquier cambio en el
     * modelo.
     */
    public void refresh() {
        playerView.repaint();
    }

    /**
     * Suscribe un juego o una instancia de juego como observador del jugador.
     *
     * @param match La instancia de GameClass que observará los cambios.
     */
    public void suscribeToView(GameClass match) {
        this.addObserver(match);
    }

    /**
     * Añade un observador a la lista de observadores.
     *
     * @param observer El observador a añadir.
     */
    public void addObserver(GameClass observer) {
        observers.add(observer);
    }

    /**
     * Establece la información del jugador en el modelo y actualiza la vista.
     *
     * @param player El jugador cuyos datos deben establecerse.
     * @param avatarPath La ruta del archivo de imagen para el avatar del
     * jugador.
     */
    public void setPlayerInfo(Player player, String avatarPath) {
        playerModel.setName(player.getName());
        playerModel.setPlayer(player);
        playerModel.setAvatarPath(avatarPath);
        playerView.refresh();
    }

    /**
     * Notifica a todos los observadores sobre los cambios relevantes en el
     * jugador. Esta función debería ser implementada para llamar a métodos
     * específicos en los observadores.
     */
    public void notificarJugador() {

    }
}
