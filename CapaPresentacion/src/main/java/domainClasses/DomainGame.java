package domainClasses;

// Importaciones necesarias de otras clases y excepciones
import com.itson.org.negocio.excepciones.PartidaException;
import com.itson.org.negocio.negocio.Partida;
import domain.game.Game;
import domain.game.Player;
import exceptions.GameException;

/**
 * Usa el patrón Singleton para asegurar que sólo existe una instancia de ella misma, 
 * facilitando un acceso global a esta instancia y asegurando que la configuración 
 * y estado del juego son únicos y consistentes.
 * La clase DomainGame actúa como una fachada o interfaz hacia la clase Game,
 * facilitando la manipulación de juegos y la interacción con la clase Partida,
 * encapsulando la lógica específica de cómo el juego está implementado.
 */
public class DomainGame {

    // Instancia única de DomainGame para implementar el patrón Singleton
    private static DomainGame domainGame;

    // Instancia del juego que se encapsula en esta clase
    private final Game game;

    // Instancia de Partida que permite la gestión de jugadores dentro de un juego
    private Partida partida;

    /**
     * Constructor privado para el patrón Singleton.
     * Inicializa la instancia de Game asegurando que sea única.
     */
    public DomainGame() {
        this.game = Game.getInstance();
    }

    /**
     * Añade un jugador al juego gestionado por la instancia de Partida.
     *
     * @param player El jugador a añadir.
     * @throws PartidaException si ocurre un error al añadir el jugador a la partida.
     */
    public void addPlayer(Player player) throws PartidaException {
        partida.anadirJugadorALaLista(player);
    }

    /**
     * Crea una lista de jugadores con un tamaño especificado.
     *
     * @param size El tamaño deseado de la lista de jugadores.
     * @throws GameException si ocurre un error al crear la lista de jugadores.
     */
    public void createPlayerListWithSize(Integer size) throws GameException {
        game.createPlayerListWithSize(size);
    }

    /**
     * Elimina un jugador del juego.
     *
     * @param player El jugador a eliminar.
     * @throws GameException si ocurre un error al eliminar el jugador.
     */
    public void deletePlayer(Player player) throws GameException {
        game.deletePlayer(player);
    }

    /**
     * Obtiene la lista de jugadores actualmente en el juego.
     *
     * @return Un arreglo de jugadores.
     */
    public Player[] getPlayersOnGame() {
        return this.game.getPlayerList();
    }

    /**
     * Método estático para obtener la instancia única de DomainGame.
     * Si no existe, crea una nueva instancia.
     * 
     * @return la única instancia de DomainGame.
     */
    public static DomainGame getInstance() {
        if (domainGame == null) {
            domainGame = new DomainGame();
        }
        return domainGame;
    }
}
