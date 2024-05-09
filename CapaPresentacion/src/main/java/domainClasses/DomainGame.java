package domainClasses;

import com.itson.org.negocio.excepciones.PartidaException;
import com.itson.org.negocio.negocio.Partida;
import domain.game.Game;
import domain.game.Player;
import exceptions.GameException;

public class DomainGame {

    private static DomainGame domainGame;

    private final Game game;

    private Partida partida;

    public DomainGame() {
        this.game = Game.getInstance();
    }

    public void addPlayer(Player player) throws PartidaException {
        partida.anadirJugadorALaLista(player);
    }

    public void createPlayerListWithSize(Integer size) throws GameException {
        game.createPlayerListWithSize(size);
    }

    public void deletePlayer(Player player) throws GameException {
        game.deletePlayer(player);
    }

    public Player[] getPlayersOnGame() {
        return this.game.getPlayerList();
    }

    public static DomainGame getInstance() {
        if (domainGame == null) {
            domainGame = new DomainGame();
        }
        return domainGame;
    }
}
