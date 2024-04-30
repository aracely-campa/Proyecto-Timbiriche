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
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author HP 240 G8
 */
public class GraphManager implements iGraphManager{
    
    
    EdgeBuilder edgeBuilder = new EdgeBuilder();
    NodeBuilder nodeBuilder = new NodeBuilder();
    ScoreIterator scoreIterator = new ScoreIterator();
    SingleSquareIterator verticalIterator= new SingleSquareIterator();

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
    public List <CoordsDTO> getScoredSquaresCoords(Node node) throws Exception{
        
        scoreIterator.setStartingNode(node);
        List coordsList = new ArrayList<CoordsDTO>();
        Boolean playerIsScoringSoFar = true;
        
        while (scoreIterator.hasNext()){
            Edge edge= scoreIterator.getNext();
            if(edge!=null&&edge.getPlayer()==null){
                playerIsScoringSoFar = false;
            }
            if (scoreIterator.getStep() % 4 == 0 && playerIsScoringSoFar) {

                CoordsDTO coords = null;

                switch (scoreIterator.getStep() / 4) {
                    //Gets the upper left node of the iteration whose coordinates happen to be the same of the square we are iterating
                    //So we are pretty much getting those coordinates this way

                    case 1:
                        if (edge.getBegginingNode() != null&&edge.getBegginingNode().getUpperEdge()!=null) {
                            coords = edge.getBegginingNode().getUpperEdge().getBegginingNode().getCoords();
                        }
                        break;
                    case 2:
                        if (edge.getBegginingNode() != null&&edge.getBegginingNode().getLeftEdge()!=null) {
                        coords = edge.getBegginingNode().getLeftEdge().getBegginingNode().getCoords();
                        }
                        break;
                    case 3:
                        if (edge.getBegginingNode() != null&&edge.getBegginingNode().getLeftEdge()!=null) {
                        coords = edge.getBegginingNode().getCoords();
                        }
                        break;
                    case 4:
                        if (edge.getBegginingNode() != null&&edge.getBegginingNode().getUpperEdge()!=null) {
                        coords = edge.getBegginingNode().getCoords();
                        }
                        break;
                    default:
                        throw new Exception("wtf");
                }

                //((node.getId()) % (boardSize + 1), (node.getId()) % (boardSize));
                coordsList.add(coords);
            }
        }
        return coordsList;
    }

    public PlayerTracesDTO getPlayerTraces(Player player, List<Node> nodeList, int length) throws Exception {

        Set<CoordsDTO> squaresCoordsSet = new HashSet<>();
        Set<Node> verticalEdgesSet = new HashSet<>();
        Set<Node> horizontalEdgesSet = new HashSet<>();

        for (Node node : nodeList) {

            if (node.getUpperEdge() != null && node.getUpperEdge().getPlayer() == player) {
                verticalEdgesSet.add(node.getUpperEdge().getBegginingNode());
            }
            if (node.getLeftEdge() != null && node.getLeftEdge().getPlayer() == player) {
                horizontalEdgesSet.add(node.getLeftEdge().getBegginingNode());
            }
            if (node.getDownEdge() != null && node.getDownEdge().getPlayer() == player) {
                verticalEdgesSet.add(node);
            }
            if (node.getRightEdge() != null && node.getRightEdge().getPlayer() == player) {
                horizontalEdgesSet.add(node);
            }

            List <CoordsDTO> tempList=getAllSquaresAffectedByPlayer(player,nodeList);
            
            tempList.removeIf(Objects::isNull);
            
            squaresCoordsSet.addAll(tempList);

        }
        return new PlayerTracesDTO(new ArrayList<CoordsDTO>(squaresCoordsSet), new ArrayList<Node>(verticalEdgesSet),new ArrayList<Node>(horizontalEdgesSet));
    }

    private List<CoordsDTO> getAllSquaresAffectedByPlayer(Player player, List<Node> nodeList ) {

        for (Node node: nodeList){
            
        }


    }
}
