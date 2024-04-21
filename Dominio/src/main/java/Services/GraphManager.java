/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import domain.game.Player;
import domain.game.Square;
import domain.graph.Edge;
import domain.graph.Node;
import domain.interfaces.iGraphIterator;
import domain.interfaces.iGraphManager;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP 240 G8
 */
public class GraphManager implements iGraphManager{
    
    
    EdgeBuilder edgeBuilder = new EdgeBuilder();
    NodeBuilder nodeBuilder = new NodeBuilder();
    ScoreIterator scoreIterator = new ScoreIterator();
    HorizontalIterator horizontalIterator= new HorizontalIterator();
    VerticalIterator verticalIterator= new VerticalIterator();

    @Override
    public void joinVerticalNodes(Node nodeBeggining, Node nodeEnding) {
        
        System.out.println("Beggining node: "+nodeBeggining);
        System.out.println("Ending node: " + nodeEnding);
        edgeBuilder.setNodes(nodeBeggining, nodeEnding);
        if (nodeBeggining != null) {
            nodeBeggining.setDownEdge(edgeBuilder.getProduct());
        }
        if (nodeEnding != null) {
            nodeEnding.setUpperEdge(edgeBuilder.getProduct());
        }

        edgeBuilder.reset();
    }

    @Override
    public void joinHorizontalNodes(Node nodeBeggining, Node nodeEnding) {
        System.out.println("Beggining node: " + nodeBeggining);
        System.out.println("Ending node: " + nodeEnding);
        edgeBuilder.setNodes(nodeBeggining, nodeEnding);
        if (nodeBeggining != null) {
            nodeBeggining.setRightEdge(edgeBuilder.getProduct());
        }
        if (nodeEnding != null) {
            nodeEnding.setLeftEdge(edgeBuilder.getProduct());
        }
        edgeBuilder.reset();
    }

    @Override
    public void fixFirstRow(Node node) {

        //edgeBuilder.setNodes(null, node);
        //node.setUpperEdge(edgeBuilder.getProduct());
        //edgeBuilder.reset();
        
        node.setUpperEdge(null);
        
    }

    @Override
    public void fixLastRow(Node node) {
        //edgeBuilder.setNodes(node, null);
        //node.setDownEdge(edgeBuilder.getProduct());
        //edgeBuilder.reset();
        
        node.setDownEdge(null);

    }

    @Override
    public void fixFirstColumn(Node node) {
        //edgeBuilder.setNodes(null, node);
        //node.setLeftEdge(edgeBuilder.getProduct());
        //edgeBuilder.reset();    
        
        node.setLeftEdge(null);
    }

    @Override
    public void fixLastColumn(Node node) {
        //edgeBuilder.setNodes(node, null);
        //node.setRightEdge(edgeBuilder.getProduct());
        //edgeBuilder.reset();    
        
        node.setRightEdge(null);
    }

    @Override
    public Node createNode() {

        nodeBuilder.setID();
        Node node=nodeBuilder.getProduct();
        nodeBuilder.reset();
        return node;

    }
    
    /**
     * Después de la validación del negicio se recibe el nodo de la esquina superior izquierda para
     * fácilitar el calculo de coordenadas mediante operaciones de modulo
     * 
     *  id modulo cantidad de nodos por linea = coordenada horizontal
     *  id modulo cantidad de cuadros/edges por linea = coordenada vertical
     * 
     * @param node
     * @param boardSize
     * @return lista de coordenadas de los cuadros que se hayan cerrado
     * @throws java.lang.Exception
     */
    
    //Brain not braining anymore, imma have to check if this actually makes any sense later (
    //spoiler, I'm almost certain it does not make no sense at all)
    
    @Override
    public List <CoordsDTO> getScoredSquaresCoords(Node node, int boardSize) throws Exception{
        
        scoreIterator.setStartingNode(node);
        List coordsList = new ArrayList<CoordsDTO>();
        Boolean playerIsScoringSoFar = true;
        
        while (scoreIterator.hasNext()){
            Edge edge= scoreIterator.getNext();
            if(edge.getPlayer()==null){
                playerIsScoringSoFar = false;
            }
            if (scoreIterator.getStep() % 4 == 0 && playerIsScoringSoFar) {
                
                CoordsDTO coords = null;
                                
                switch(scoreIterator.getStep()/4){
                    //Gets the upper left node of the iteration whose coordinates happen to be the same of the square we are iterating
                    //So we are pretty much getting those coordinates this way
                    
                    case 1: coords = edge.getBegginingNode().getCoords(); break;
                    case 2: coords = edge.getBegginingNode().getUpperEdge().getBegginingNode().getCoords(); break;
                    case 3: coords = edge.getBegginingNode().getLeftEdge().getBegginingNode().getCoords(); break;
                    case 4: coords = edge.getBegginingNode().getCoords(); break;
                    default: throw new Exception("wtf");
                }
                
                
                
                //((node.getId()) % (boardSize + 1), (node.getId()) % (boardSize));
                coordsList.add(coords);
            }
        }
        return coordsList;
    }

    public PlayerTracesDTO getPlayerTraces(Player player, List<Node> nodeList, int boardSize) {
        List horizontalNodes = getHorizontalEdgesMadeByPlayer(player, nodeList);
        List verticalNodes = getVerticalEdgesMadeByPlayer(player, nodeList);
        List coordsList = getAffectedSquares(horizontalNodes, verticalNodes, boardSize);

        return new PlayerTracesDTO(coordsList, verticalNodes, horizontalNodes);

    }

    public List<CoordsDTO> getAffectedSquares(List<Node> horizontalNodes, List<Node> verticalNodes, int boardSize) {

        List coordsList = new ArrayList<CoordsDTO>();

        for (Node node : horizontalNodes) {
            
        }

        for (Node node : verticalNodes) {

        }
        return coordsList;
    }

    public List<Node> getVerticalEdgesMadeByPlayer(Player player, List<Node> nodeList) {
        List verticalNodes = new ArrayList<Node>();

        //Math.sqrt(nodeList.size() = cantidad de nodos por row/column
        for (int i = 0; i < (int) Math.sqrt(nodeList.size()); i++) {

            //Math.sqrt(nodeList.size() = cantidad de nodos por row/column
            //Math.sqrt(nodeList.size()*i = current column's number
            //1+(int) Math.sqrt(nodeList.size()*i) = ID del primer nodo de la fila
            verticalIterator.setStartingNode(nodeList.get(1 + ((int) Math.sqrt(nodeList.size()) * i)));

            while (verticalIterator.hasNext()) {
                Edge edge = verticalIterator.getNext();
                if (edge.getPlayer() == player) {
                    verticalNodes.add(edge.getBegginingNode());
                }
            }
        }

        return verticalNodes;
    }

    public List<Node> getHorizontalEdgesMadeByPlayer(Player player, List<Node> nodeList) {

        List horizontalNodes = new ArrayList<Node>();

        //Math.sqrt(nodeList.size() = cantidad de nodos por row/column
        for (int i = 0; i < (int) Math.sqrt(nodeList.size()); i++) {
            
            //Math.sqrt(nodeList.size() = cantidad de nodos por row/column
            //Math.sqrt(nodeList.size()*i = current row's number
            //1+(int) Math.sqrt(nodeList.size()*i) = ID del primer nodo de la fila
            horizontalIterator.setStartingNode(nodeList.get(1 + ((int) Math.sqrt(nodeList.size()) * i)));

            while (horizontalIterator.hasNext()) {
                Edge edge = horizontalIterator.getNext();
                if (edge.getPlayer() == player) {
                    horizontalNodes.add(edge.getBegginingNode());
                }
            }
        }
        return horizontalNodes;
    }
}