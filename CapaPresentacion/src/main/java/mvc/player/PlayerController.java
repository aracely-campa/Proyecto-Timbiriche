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
public class PlayerController {

    private PlayerController playerController;
    private PlayerModel playerModel;
    private PlayerView playerView;

    public PlayerController(PlayerModel playerModel, PlayerView playerView) {
        this.playerModel = playerModel;
        this.playerView = playerView;
    }

    public PlayerController getPlayerController() {
        return playerController;
    }

    public PlayerModel getPlayerModel() {
        return playerModel;
    }

    public PlayerView getPlayerView() {
        return playerView;
    }

    public void refresh() {
        this.playerView.repaint();
    }

    public void setPlayerInfo(Player player, String avatarPath) {
        playerModel.setName(player.getName());
        playerModel.setPlayer(player);
        playerModel.setAvatarPath(avatarPath);
        playerView.refresh();
    }
}
