/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import domain.graph.Edge;
import domain.graph.Node;
import domain.interfaces.iEdgeBuilder;
import domain.game.Player;

/**
 *
 * @author HP 240 G8
 */
public class EdgeBuilder implements iEdgeBuilder {

    private Edge product = new Edge();

    @Override
    public void setNodes(Node beggining, Node ending) {
        product.setBegginingNode(beggining);
        product.setEndingNode(ending);
    }

    @Override
    public void setPlayer(Player player) {
        product.setPlayer(player);
    }

    @Override
    public Edge getProduct() {
        return product;
    }

    @Override
    public void reset() {
        product = new Edge();
    }

}
