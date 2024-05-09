/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.node;

import domain.graph.Edge;
import domain.graph.Node;

/**
 *
 * @author arace
 */
public class NodeModel {

    private Node node;
    private Node upperEdge;
    private Node downEdge;
    private Node leftEdge;
    private Edge rightEdge;

    public Node getNode() {
        return node;
    }

    public NodeModel(Node node, Node upperEdge, Node downEdge, Node leftEdge, Edge rightEdge) {
        this.node = node;
        this.upperEdge = upperEdge;
        this.downEdge = downEdge;
        this.leftEdge = leftEdge;
        this.rightEdge = rightEdge;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public Node getUpperEdge() {
        return upperEdge;
    }

    public void setUpperEdge(Node upperEdge) {
        this.upperEdge = upperEdge;
    }

    public Node getDownEdge() {
        return downEdge;
    }

    public void setDownEdge(Node downEdge) {
        this.downEdge = downEdge;
    }

    public Node getLeftEdge() {
        return leftEdge;
    }

    public void setLeftEdge(Node leftEdge) {
        this.leftEdge = leftEdge;
    }

    public Edge getRightEdge() {
        return rightEdge;
    }

    public void setRightEdge(Edge rightEdge) {
        this.rightEdge = rightEdge;
    }

    @Override
    public String toString() {
        return "NodeModel{" + "node=" + node + ", upperEdge=" + upperEdge + ", downEdge=" + downEdge + ", leftEdge=" + leftEdge + ", rightEdge=" + rightEdge + '}';
    }

}
