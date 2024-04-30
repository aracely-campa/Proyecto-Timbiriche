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
public class SingleSquareIterator implements iGraphIterator {

    private Node startingNode;
    private Node currentNode;
    private int step;

    @Override
    public Edge getNext() {

        if (step == 1 ) {
            if (currentNode.getRightEdge() != null) {
                currentNode = currentNode.getRightEdge().getEndingNode();
                step++;
                return currentNode.getLeftEdge();
            }
            step = step + 4;
        } else if (step == 2 || step == 5 || step == 12 || step == 15) {
            if (currentNode.getUpperEdge()!= null) {
                currentNode = currentNode.getUpperEdge().getBegginingNode();
                step++;
                return currentNode.getDownEdge();
            }
            step = step + 4;
        } else if (step == 3 || step == 6 || step == 9 || step == 16) {
            if (currentNode.getLeftEdge()!= null) {
                currentNode = currentNode.getLeftEdge().getBegginingNode();
                step++;
                return currentNode.getRightEdge();
            }
            step = step + 4;
        } else if (step == 4 || step == 7 || step == 10 || step == 13) {
            if (currentNode.getDownEdge()!= null) {
                currentNode = currentNode.getDownEdge().getEndingNode();
                step++;
                return currentNode.getUpperEdge();
            }
            step = step + 4;
        }
        return null;
    }

       @Override
    public Boolean hasNext() {

        return step <= 4;

    }

    @Override
    public void setStartingNode(Node node) {
        startingNode = node;
        currentNode = node;
        step = 1;
    }
    
    public int getStep(){
        return step;
    }
}
