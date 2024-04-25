/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.player;

/**
 *
 * @author luis-
 */
public class PlayerController {
 private PlayerController playerController;
 private PlayerModel playerModel;
 private PlayerView playerView;

    public PlayerController(PlayerController playerController, PlayerModel playerModel, PlayerView playerView) {
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
 
}