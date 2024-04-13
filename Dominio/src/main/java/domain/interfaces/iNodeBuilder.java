/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package domain.interfaces;

import domain.graph.Edge;
import domain.graph.Node;

/**
 *
 * @author HP 240 G8
 */
public interface iNodeBuilder {

    public void setUpperEdge(Edge edge);

    public void setDownEdge(Edge edge);

    public void setLeftEdge(Edge edge);

    public void setRightEdge(Edge edge);

    public void setID();

    public Node getProduct();

    public void reset();
}
