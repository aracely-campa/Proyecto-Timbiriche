package domain.game;

import Services.CoordsDTO;
import Services.GraphManager;
import Services.PlayerTracesDTO;
import domain.graph.Edge;
import domain.graph.Node;
import domain.game.Player;
import java.util.ArrayList;
import java.util.List;

public class Board extends Game{
    
    private Square[][] boardArray;
    private List<Node> nodeList = new ArrayList();
    private GraphManager graphManager = new GraphManager();
    public static int size=5;

    public void createSmallBoard() {
        createSmallBoardArray();
        createSmallBoardGraph();
    }

    public void createSmallBoardArray() {
        boardArray = new Square[5][5];
        for (int i = 0; i < boardArray.length; i++) {
            for (int j = 0; j < boardArray[0].length; j++) {
                boardArray[i][j] = new Square();
            }
        }
    }

      public void createSmallBoardGraph() {
        for (int i = 0; i <= boardArray.length; i++) {
            for (int j = 0; j <= boardArray[0].length; j++) {
                nodeList.add(graphManager.createNode());
            }
        }

        for (int i = 0; i <= boardArray.length; i++) {
            for (int j = 0; j <= boardArray[0].length; j++) {
                //System.out.println(j + boardArray.length * i);
                //I = Y Coords
                //J = X Coords
                //N = boardArray.length
                //X+NY+1 = Index
                System.out.println("\nI: "+i+"J: "+j);
                //Sets then upper node to null if the tempNode belongs to the first row
                if (i == 0) {
                    //i+(n*(j-1))+1 gives the index of the item in the row below
                    graphManager.joinVerticalNodes(null, nodeList.get(j + (boardArray.length+1) * i));
                    graphManager.fixFirstRow(nodeList.get(j + boardArray.length * i));
                } else {
                    //i+3*j+1 gives the index of the item in the upper row
                    //i+2*j+1 gives the index of the item in the row below
                    graphManager.joinVerticalNodes(nodeList.get(j + (boardArray.length+1) * (i - 1)), nodeList.get(j + (boardArray.length+1) * i));
                    if (i==boardArray[0].length-1){
                    graphManager.fixLastRow(nodeList.get(j + (boardArray.length+1) * i));
                    }
                     
                }
                //Sets then Left node to null if the tempNode belongs to the first column
                if (j == 0) {
                    //i+4*j+2 gives the index of the previous item
                    graphManager.joinHorizontalNodes(null, nodeList.get(j + (boardArray.length+1) * i));
                    graphManager.fixFirstColumn(nodeList.get(j + (boardArray.length+1) * i));
                } else {
                    //i+4*j gives the index of the previous item
                    //i+4*j+2 gives the index of the previous item
                    graphManager.joinHorizontalNodes(nodeList.get(j + (boardArray.length+1) * i-1), nodeList.get(j + (boardArray.length+1) * i));
                    if(j==boardArray[0].length-1){
                    graphManager.fixLastColumn(nodeList.get(j + (boardArray.length+1) * i));
                    }
                }
                //nodeList.set(i + 4 * j + 1, tempNode);
            }

        }
    }

    public List getBoardNodes() {
        return nodeList;
    }

    public Square[][] getBoardArray() {
        return boardArray;
    }

    /**
     * Después de la verificación del negocio, recibe los métodos de izquierda a derecha o arriba a abajo y hace la distinción
     * entre ambos casos mediante el id (posición) para regresar el id ¿edge correspondiente (en relación al nodo inicio)
     * 
     * @param nodeBegining
     * @param nodeEnding
     * @return 
     */
    
    public Edge getEdge(Node nodeBegining, Node nodeEnding) {

        if (nodeBegining.getId() == nodeEnding.getId() + 1) {
            return nodeBegining.getRightEdge();
        }
        return nodeBegining.getDownEdge();

    }

    /**
     * Regresa el node desde la lista de nodos mediante el id, se le resta uno
     * pq el primer id es =1 pero el indice comienza en 0 pq algun desgraciado
     * decidió que era buena idea wtf
     *
     * @param id
     * @return
     */
    public Node getNodeById(int id) {
        return nodeList.get(id - 1);
    }

    /**
     * Setea el jugador a cada cuadro que se haya formado
     * 
     * @param player
     * @param nodeBegining
     * @param nodeEnding
     * @return true si se formó un cuadro y se seteo el jugador, false si no
     */
    
    public boolean setPlayerToSquares(Player player, Node nodeBegining, Node nodeEnding) throws Exception {

        List<CoordsDTO> coordsList = graphManager.getScoredSquaresCoords(nodeBegining);
        
        if (coordsList.isEmpty()){
            return false;
        }
        for(CoordsDTO coords: coordsList){
            boardArray[coords.getX()][coords.getY()].setPlayer(player);
        }
        return true;
    }
    /**
     * Borra alv los cuadros y y edges que haya hecho algún jugador
     * 
     * @return true si funcionó, false si valió vrg
     */
    public boolean deletePlayerTraces(Player player) throws Exception {

        PlayerTracesDTO traces = graphManager.getPlayerTraces(player, nodeList, boardArray.length, boardArray);
        List<CoordsDTO> coordsList = traces.getSquaresCoords();
        List<Node> horizontalNodes = traces.getHorizontalEdgesList();
        List<Node> verticalNodes = traces.getVerticalEdgesList();
        System.out.print(coordsList);
        //DELETE SQUARES
        for (CoordsDTO coords : coordsList) {
            if (coords.getX() < boardArray.length && coords.getY() < boardArray[0].length && boardArray[coords.getX()][coords.getY()].getPlayer() != null) {
                boardArray[coords.getX()][coords.getY()].setPlayer(null);
            }

        }

        for (Node node : horizontalNodes) {
            if (node.getRightEdge().getPlayer()!=null){
                node.getRightEdge().setPlayer(null);
            }
        }
        
        for (Node node: verticalNodes){
            if (node.getDownEdge().getPlayer()!=null){
                node.getDownEdge().setPlayer(null);
            }
        }
        
        return true;
    }
    
    
    
    
}