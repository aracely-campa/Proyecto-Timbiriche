
package domainClasses;

import domain.game.Player;

public class DomainPlayer {

    private static DomainPlayer domainPlayer;

    public Player player;

    public DomainPlayer() {
        this.player = Player.getInstance();
    }

    public void getPlayerLines() {

    }

    public void removePlayerLines() {

    }

    public static DomainPlayer getInstance() {
        if (domainPlayer == null) {
            domainPlayer = new DomainPlayer();
        }
        return domainPlayer;
    }

}
