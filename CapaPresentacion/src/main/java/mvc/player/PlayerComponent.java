package mvc.player;

import domain.game.Player;

/**
 * PlayerComponent encapsula todas las funcionalidades relacionadas con la gestión de un jugador,
 * integrando el modelo, la vista y el controlador en un solo componente para facilitar su manejo.
 */
public class PlayerComponent {

    private PlayerModel playerModel; // El modelo que gestiona los datos y el estado del jugador.
    private PlayerView playerView; // La vista que representa visualmente al jugador.
    private PlayerController playerController; // El controlador que coordina la interacción entre el modelo y la vista.

    /**
     * Constructor de PlayerComponent que inicializa el modelo, la vista y el controlador del jugador.
     * También inicializa los valores por defecto del modelo.
     */
    public PlayerComponent() {
        this.playerModel = new PlayerModel();
        this.playerView = new PlayerView(playerModel);
        this.playerController = new PlayerController(playerModel, playerView);
        this.playerModel.inicializarValores(); // Inicializa valores predeterminados del modelo.
    }

    /**
     * Devuelve el controlador del jugador.
     *
     * @return El controlador asociado con este componente de jugador.
     */
    public PlayerController getPlayerController() {
        return playerController;
    }

    /**
     * Establece un nuevo controlador para el jugador.
     *
     * @param playerController El nuevo controlador del jugador.
     */
    public void setPlayerController(PlayerController playerController) {
        this.playerController = playerController;
    }

    /**
     * Devuelve el modelo del jugador.
     *
     * @return El modelo asociado con este componente de jugador.
     */
    public PlayerModel getPlayerModel() {
        return playerModel;
    }

    /**
     * Establece un nuevo modelo para el jugador.
     *
     * @param playerModel El nuevo modelo del jugador.
     */
    public void setPlayerModel(PlayerModel playerModel) {
        this.playerModel = playerModel;
    }

    /**
     * Devuelve la vista del jugador.
     *
     * @return La vista asociada con este componente de jugador.
     */
    public PlayerView getPlayerView() {
        return playerView;
    }

    /**
     * Establece una nueva vista para el jugador.
     *
     * @param playerView La nueva vista del jugador.
     */
    public void setPlayerView(PlayerView playerView) {
        this.playerView = playerView;
    }

    /**
     * Actualiza la vista del jugador basándose en el estado actual del modelo.
     * Delega la acción de actualización al controlador.
     */
    public void refresh() {
        this.playerController.refresh();
    }

    /**
     * Establece la información del jugador y actualiza el modelo a través del controlador.
     *
     * @param player El jugador cuya información se establecerá.
     * @param avatarPath La ruta al archivo de imagen del avatar del jugador.
     */
    public void setPlayerInfo(Player player, String avatarPath) {
        this.playerController.setPlayerInfo(player, avatarPath);
    }
}
