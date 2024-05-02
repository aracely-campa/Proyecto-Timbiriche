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
    private PlayerComponent playerComponent;

    public PlayerController(PlayerModel playerModel, PlayerView playerView) {
        this.playerModel = playerModel;
        this.playerView = playerView;
    }

    public PlayerController getPlayerController() {
        return playerController;
    }

    public void setPlayerController(PlayerController playerController) {
        this.playerController = playerController;
    }
   
    public void refresh(){
        this.playerView.repaint();
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

    public PlayerController() {
        this.playerComponent = PlayerComponent.getInstance();
    }

    public void updatePlayerDetails(String name, String avatarPath) {
        playerComponent.updatePlayerInfo(name, avatarPath);
    }
}
