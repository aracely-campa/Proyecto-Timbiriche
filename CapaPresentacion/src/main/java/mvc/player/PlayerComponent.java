package mvc.player;

import domain.game.Player;

public class PlayerComponent {

    private PlayerModel playerModel;
    private PlayerView playerView;

    private PlayerController playerController;

    private static PlayerComponent playerComponent;

    public PlayerComponent() {
        this.playerModel = new PlayerModel();
        this.playerView = new PlayerView(playerModel);
        this.playerController = new PlayerController(playerModel, playerView);
        this.playerModel.inicializarValores();
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

    public void refresh() {
        this.playerController.refresh();
    }

    public static PlayerComponent getInstance() {
        if (playerComponent == null) {
            playerComponent = new PlayerComponent();
        }
        return playerComponent;
    }

    public void setPlayerInfo(Player player, String avatarPath) {
       this.playerController.setPlayerInfo(player, avatarPath);
    }
}
