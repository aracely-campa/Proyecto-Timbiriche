/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.player;

import domain.game.Player;

/**
 *
 * @author luis-
 */
public class PlayerComponent {

    private PlayerModel playerModel = new PlayerModel();
    private PlayerView playerView = new PlayerView(playerModel);

    private PlayerController playerController = new PlayerController(playerModel, playerView);

    private static PlayerComponent playerComponent;

    public PlayerComponent() {
    }

    public PlayerComponent(PlayerController playerController, PlayerModel playerModel, PlayerView playerView) {
        this.playerController = playerController;
        this.playerModel = playerModel;
        this.playerView = playerView;
    }

    public PlayerController getPlayerController() {
        return playerController;
    }

    public void setPlayerController(PlayerController playerController) {
        this.playerController = playerController;
    }

    public PlayerModel getPlayerModel() {
        return playerModel;
    }

    public void setPlayerModel(PlayerModel playerModel) {
        this.playerModel = playerModel;
    }

    public PlayerView getPlayerView() {
        return playerView;
    }

    public void setPlayerView(PlayerView playerView) {
        this.playerView = playerView;
    }

    public static PlayerComponent getInstance() {
        if (playerComponent == null) {
            playerComponent = new PlayerComponent();
        }
        return playerComponent;
    }

    public void updatePlayerInfo(String name, String avatarPath) {
        if (playerModel == null) {
            playerModel = new PlayerModel(new Player(), avatarPath, name, 0);
        } else {
            playerModel.setName(name);
            playerModel.setAvatarPath(playerModel.getPlayer(), avatarPath); // Asegúrate de ajustar si el setter cambia.
        }
    }

    @Override
    public String toString() {
        return "PlayerComponent{" + "playerController=" + playerController + ", playerModel=" + playerModel + ", playerView=" + playerView + '}';
    }

}
