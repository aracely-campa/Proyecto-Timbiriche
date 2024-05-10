package domainClasses;

// Importación de clases necesarias para el funcionamiento de DomainBoard
import domain.game.Board;
import domain.graph.Node;
import java.util.List;

/**
 * Implementa el patrón Singleton, que se utiliza para asegurar que una clase 
 * tenga una única instancia en toda la aplicación. 
 * La clase DomainBoard actúa como una fachada o interfaz hacia la clase Board,
 * facilitando la manipulación de un tablero de juego y encapsulando la lógica
 * específica de cómo el tablero está implementado, ya sea como un arreglo o
 * como un grafo.
 */
public class DomainBoard {

    // Instancia única de DomainBoard para implementar el patrón Singleton
    private static DomainBoard domainBoard;

    // Instancia del tablero de juego que se encapsula en esta clase
    private Board board;

    /**
     * Constructor privado para el patrón Singleton. Inicializa la instancia de
     * Board asegurando que sea única.
     */
    public DomainBoard() {
        this.board = Board.getInstance();
    }

    /**
     * Crea un tablero de juego de tamaño pequeño usando la representación
     * interna predeterminada.
     */
    public void createSmallBoard() {
        board.createSmallBoard();
    }

    /**
     * Crea un tablero de juego de tamaño pequeño utilizando una matriz (array)
     * como representación.
     */
    public void createSmallBoardArray() {
        board.createSmallBoardArray();
    }

    /**
     * Crea un tablero de juego de tamaño pequeño utilizando un grafo como
     * representación.
     */
    public void createSmallBoardGraph() {
        board.createSmallBoardGraph();
    }

    /**
     * Obtiene la lista de nodos del tablero de juego, lo que permite acceder a
     * su estructura de grafo.
     *
     * @return lista de nodos del tablero.
     */
    public List<Node> getNodeList() {
        return board.getBoardNodes();
    }

    /**
     * Método estático para obtener la instancia única de DomainBoard. Si no
     * existe, crea una nueva instancia.
     *
     * @return la única instancia de DomainBoard.
     */
    public static DomainBoard getInstance() {
        if (domainBoard == null) {
            domainBoard = new DomainBoard();
        }
        return domainBoard;
    }

}
