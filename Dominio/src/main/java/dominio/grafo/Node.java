/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio.grafo;

/**
 *
 * @author arace
 */
public class Node{
    private int id;
    private Edge upperEdge;
    private Edge downEdge;
    private Edge leftEdge;
    private Edge rightEdge;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Edge getUpperEdge() {
        return upperEdge;
    }

    public void setUpperEdge(Edge upperEdge) {
        this.upperEdge = upperEdge;
    }

    public Edge getDownEdge() {
        return downEdge;
    }

    public void setDownEdge(Edge downEdge) {
        this.downEdge = downEdge;
    }

    public Edge getLeftEdge() {
        return leftEdge;
    }

    public void setLeftEdge(Edge leftEdge) {
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
        return "Node{" + "id=" + id + '}';
    }
}
