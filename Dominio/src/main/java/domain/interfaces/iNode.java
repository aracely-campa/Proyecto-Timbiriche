/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package domain.interfaces;

import domain.graph.Edge;

public interface iNode {
    
    public int getId();

    public void setId(int id);

    public Edge getUpperEdge();

    public void setUpperEdge(Edge upperEdge);

    public Edge getDownEdge();

    public void setDownEdge(Edge downEdge);

    public Edge getLeftEdge();

    public void setLeftEdge(Edge leftEdge);

    public Edge getRightEdge();
    
    public void setRightEdge(Edge rightEdge);

}
