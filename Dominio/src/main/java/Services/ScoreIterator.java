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
public class ScoreIterator implements iGraphIterator {

    private Node startingNode;
    private Node currentNode;
    int step;

    public ScoreIterator() {

    }

    @Override
    public Edge getNext() {
        if (step == 1 || step == 8 || step == 11 || step == 14) {
            currentNode = currentNode.getRightEdge().getEndingNode();
            step++;
            return currentNode.getLeftEdge();
        } else if (step == 2 || step == 5 || step == 12 || step == 15) {
            currentNode = currentNode.getUpperEdge().getBegginingNode();
            step++;
            return currentNode.getDownEdge();
        } else if (step == 3 || step == 6 || step == 9 || step == 16) {
            currentNode = currentNode.getLeftEdge().getBegginingNode();
            step++;
            return currentNode.getRightEdge();
        } else if (step == 4 || step == 7 || step == 10 || step == 13) {
            currentNode = currentNode.getDownEdge().getEndingNode();
            step++;
            return currentNode.getUpperEdge();
        }
        return null;
    }

    @Override
    public Boolean hasNext() {

        return step <= 16;

    }

    public void setStartingNode(Node node) {
        startingNode = node;
        currentNode = node;
        step = 1;
    }
}
