/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain.graph;

import domain.interfaces.iNode;

/**
 *
 * @author arace
 */
public class Node implements iNode{
    private int id;
    private Edge upperEdge;
    private Edge downEdge;
    private Edge leftEdge;
    private Edge rightEdge;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public Edge getUpperEdge() {
        return upperEdge;
    }

    @Override
    public void setUpperEdge(Edge upperEdge) {
        this.upperEdge = upperEdge;
    }

    @Override
    public Edge getDownEdge() {
        return downEdge;
    }

    @Override
    public void setDownEdge(Edge downEdge) {
        this.downEdge = downEdge;
    }

    @Override
    public Edge getLeftEdge() {
        return leftEdge;
    }

    @Override
    public void setLeftEdge(Edge leftEdge) {
        this.leftEdge = leftEdge;
    }

    @Override
    public Edge getRightEdge() {
        return rightEdge;
    }

    @Override
    public void setRightEdge(Edge rightEdge) {
        this.rightEdge = rightEdge;
    }

    @Override
    public String toString() {
        return "Node{" + "id=" + id + '}';
    }
}