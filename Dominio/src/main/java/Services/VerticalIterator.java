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
public class VerticalIterator implements iGraphIterator {

    private Node startingNode;
    private Node currentNode;

    @Override
    public Edge getNext() {

        currentNode = currentNode.getDownEdge().getEndingNode();
        return currentNode.getUpperEdge();
    }

    @Override
    public Boolean hasNext() {

        return currentNode.getDownEdge() != null;

    }

    @Override
    public void setStartingNode(Node node) {
        startingNode = node;
        currentNode = node;
    }
}
