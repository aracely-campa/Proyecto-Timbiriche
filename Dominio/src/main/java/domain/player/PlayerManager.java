
package domain.player;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author arace
 */
import java.util.ArrayList;
import java.util.List;

public class PlayerManager {
    private static PlayerManager instance; 
    private List<PlayerComponent> playersComponent;


    private PlayerManager() {
        this.playersComponent = new ArrayList<>();
    }


    public static PlayerManager getInstance() { 
        if (PlayerManager.instance == null) {
            PlayerManager.instance = new PlayerManager();
        }
        return PlayerManager.instance;
    }

    public void createPlayer(String name, PlayerController playerController, Player player, Integer id, boolean turnoJugador) {
        if (this.playersComponent.size() < 4) {
            PlayerComponent playerComponent = new PlayerComponent(playerController, player, name, id, turnoJugador);
            this.playersComponent.add(playerComponent);
            System.out.println("Player " + name + " is created.");
        } else {
            System.out.println("Players are already created.");
        }
    }

    public List<PlayerComponent> getPlayersComponents() {
        return this.playersComponent;
    }

    public List<Player> getPlayers() {
        List<Player> players = new ArrayList<>();
        for (PlayerComponent playerComponent : this.playersComponent) {
            players.add(playerComponent.getPlayer());
        }
        return players;
    }
}

