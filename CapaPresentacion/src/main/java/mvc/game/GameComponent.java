package mvc.game;

import domain.game.Player;
import mvc.board.BoardComponent;
import mvc.node.NodeComponent;
import mvc.player.PlayerComponent;

/**
 * GameComponent actúa como una fachada central para la gestión de los componentes del juego.
 * Encapsula el modelo, la vista, y el controlador del juego, y proporciona acceso a otros componentes
 * específicos del juego como el tablero, los jugadores y los nodos.
 */
public class GameComponent {

    private GameModel gameModel; // Modelo que gestiona la lógica y estado del juego.
    private GameView gameView; // Vista que proporciona la representación gráfica del juego.
    private GameController gameController; // Controlador que maneja la interacción entre el modelo y la vista.
    private static GameComponent gameComponent; // Instancia estática para implementar el patrón Singleton.

    private BoardComponent boardComponent; // Componente que gestiona el tablero de juego.
    private PlayerComponent playerComponent; // Componente que gestiona los jugadores del juego.
    private NodeComponent nodeComponent; // Componente que gestiona los nodos del juego.

    /**
     * Constructor de GameComponent que inicializa el modelo, la vista y el controlador del juego.
     */
    public GameComponent() {
        this.gameModel = new GameModel();
        this.gameView = new GameView(gameModel);
        this.gameController = new GameController(gameModel, gameView);
    }

    /**
     * Devuelve el controlador del juego.
     *
     * @return el controlador del juego actual.
     */
    public GameController getGameController() {
        return gameController;
    }

    /**
     * Devuelve el modelo del juego.
     *
     * @return el modelo del juego actual.
     */
    public GameModel getGameModel() {
        return gameModel;
    }

    /**
     * Devuelve la vista del juego.
     *
     * @return la vista del juego actual.
     */
    public GameView getGameView() {
        return gameView;
    }

    /**
     * Devuelve el componente que gestiona los jugadores.
     *
     * @return el componente de jugadores actual.
     */
    public PlayerComponent getPlayerComponent() {
        return playerComponent;
    }

    /**
     * Devuelve el componente que gestiona el tablero.
     *
     * @return el componente del tablero actual.
     */
    public BoardComponent getBoardComponent() {
        return boardComponent;
    }

    /**
     * Devuelve los jugadores actualmente en el juego.
     *
     * @return un array de jugadores en el juego.
     */
    public Player[] getPlayersOnGame() {
        return this.gameController.getPlayersOnGame();
    }

    /**
     * Método para construir o inicializar componentes adicionales del juego.
     */
    public void buildGame() {
        // Implementación pendiente.
    }

    /**
     * Devuelve el componente que gestiona los nodos.
     *
     * @return el componente de nodos actual.
     */
    public NodeComponent getNodeComponent() {
        return nodeComponent;
    }

    /**
     * Método estático para obtener la única instancia de GameComponent, siguiendo el patrón Singleton.
     * Si no existe, se crea una nueva instancia.
     *
     * @return la única instancia de GameComponent.
     */
    public static GameComponent getInstance() {
        if (gameComponent == null) {
            gameComponent = new GameComponent();
        }
        return gameComponent;
    }
}
