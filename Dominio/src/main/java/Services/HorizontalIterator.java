/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import domain.graph.Edge;
import domain.graph.Node;
import domain.interfaces.iGraphIterator;

/**
 *
 * @author HP 240 G8
 */
public class HorizontalIterator implements iGraphIterator{
    
    private Node startingNode;
    private Node currentNode;

    @Override
    public Edge getNext() {

        currentNode=currentNode.getRightEdge().getEndingNode();
        return currentNode.getLeftEdge();
    }

    @Override
    public Boolean hasNext() {

        return currentNode.getRightEdge() != null;

    }

    @Override
    public void setStartingNode(Node node) {
        startingNode = node;
        currentNode = node;
    }

    
}
