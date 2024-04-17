
package domain.player;

/**
 *
 * @author arace
 */
public class PlayerController {

    private static PlayerController instance;
    private Player player;

    private PlayerController() {

    }

    public static PlayerController get() {
        if (PlayerController.instance == null) {
            PlayerController.instance = new PlayerController();
        }

        return PlayerController.instance;
    }

    public Player createPlayer(String name) {
        Player player = new Player();
        player.setName(name);
        return player;
    }

    public Player getPlayer() {
        return this.player;
    }
}
