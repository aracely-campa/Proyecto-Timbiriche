/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.node;

import domain.graph.Edge;
import domain.graph.Node;

/**
 * NodeModel representa un nodo en un modelo de datos, manteniendo referencias a
 * otros nodos adyacentes que representan los bordes superior, inferior,
 * izquierdo y derecho del nodo.
 */
public class NodeModel {

    private Node node;        // Nodo principal que representa este modelo.
    private Node upperEdge;   // Nodo en el borde superior.
    private Node downEdge;    // Nodo en el borde inferior.
    private Node leftEdge;    // Nodo en el borde izquierdo.
    private Edge rightEdge;   // Borde derecho representado por una clase específica Edge.

    /**
     * Constructor para NodeModel que inicializa el nodo con sus nodos
     * adyacentes y bordes.
     *
     * @param node Nodo principal del modelo.
     * @param upperEdge Nodo en el borde superior.
     * @param downEdge Nodo en el borde inferior.
     * @param leftEdge Nodo en el borde izquierdo.
     * @param rightEdge Borde derecho.
     */
    public NodeModel(Node node, Node upperEdge, Node downEdge, Node leftEdge, Edge rightEdge) {
        this.node = node;
        this.upperEdge = upperEdge;
        this.downEdge = downEdge;
        this.leftEdge = leftEdge;
        this.rightEdge = rightEdge;
    }

    /**
     * Devuelve el nodo principal.
     *
     * @return Nodo principal.
     */
    public Node getNode() {
        return node;
    }

    /**
     * Establece el nodo principal.
     *
     * @param node Nodo principal a establecer.
     */
    public void setNode(Node node) {
        this.node = node;
    }

    /**
     * Devuelve el nodo del borde superior.
     *
     * @return Nodo del borde superior.
     */
    public Node getUpperEdge() {
        return upperEdge;
    }

    /**
     * Establece el nodo del borde superior.
     *
     * @param upperEdge Nodo del borde superior a establecer.
     */
    public void setUpperEdge(Node upperEdge) {
        this.upperEdge = upperEdge;
    }

    /**
     * Devuelve el nodo del borde inferior.
     *
     * @return Nodo del borde inferior.
     */
    public Node getDownEdge() {
        return downEdge;
    }

    /**
     * Establece el nodo del borde inferior.
     *
     * @param downEdge Nodo del borde inferior a establecer.
     */
    public void setDownEdge(Node downEdge) {
        this.downEdge = downEdge;
    }

    /**
     * Devuelve el nodo del borde izquierdo.
     *
     * @return Nodo del borde izquierdo.
     */
    public Node getLeftEdge() {
        return leftEdge;
    }

    /**
     * Establece el nodo del borde izquierdo.
     *
     * @param leftEdge Nodo del borde izquierdo a establecer.
     */
    public void setLeftEdge(Node leftEdge) {
        this.leftEdge = leftEdge;
    }

    /**
     * Devuelve el borde derecho.
     *
     * @return Borde derecho.
     */
    public Edge getRightEdge() {
        return rightEdge;
    }

    /**
     * Establece el borde derecho.
     *
     * @param rightEdge Borde derecho a establecer.
     */
    public void setRightEdge(Edge rightEdge) {
        this.rightEdge = rightEdge;
    }

    /**
     * Proporciona una representación en cadena de la instancia actual del
     * modelo del nodo.
     *
     * @return Representación en cadena del modelo del nodo.
     */
    @Override
    public String toString() {
        return "NodeModel{" + "node=" + node + ", upperEdge=" + upperEdge + ", downEdge=" + downEdge + ", leftEdge=" + leftEdge + ", rightEdge=" + rightEdge + '}';
    }

}
