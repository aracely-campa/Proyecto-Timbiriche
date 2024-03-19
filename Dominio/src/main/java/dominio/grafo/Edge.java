/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio.grafo;

/**
 *
 * @author HP 240 G8
 */
public class Edge {
 
    private Player player;
    private Node begginingNode;
    private Node endingNode;
    
    public Edge() {

    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Node getBegginingNode() {
        return begginingNode;
    }

    public void setBegginingNode(Node begginingNode) {
        this.begginingNode = begginingNode;
    }

    public Node getEndingNode() {
        return endingNode;
    }

    public void setEndingNode(Node endingNode) {
        this.endingNode = endingNode;
    }

    @Override
    public String toString() {
        if (player!=null){
            return "Edge{" + "player=" + player.getName() + ", begginingNode=" + begginingNode + ", endingNode=" + endingNode + '}';
        }
        return "Edge{" + "player=" + player + ", begginingNode=" + begginingNode + ", endingNode=" + endingNode + '}';
    }  
}