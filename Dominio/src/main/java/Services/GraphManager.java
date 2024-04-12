/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import domain.graph.Node;
import domain.interfaces.iGraphManager;

/**
 *
 * @author HP 240 G8
 */
public class GraphManager implements iGraphManager{
    
    
    EdgeBuilder edgeBuilder = new EdgeBuilder();

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
    
}
