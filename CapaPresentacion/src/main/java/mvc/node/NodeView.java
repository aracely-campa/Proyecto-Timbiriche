/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.node;

import domain.graph.Node;
import javax.swing.JPanel;

/**
 *
 * @author arace
 */
public class NodeView extends JPanel{

    private NodeModel nodeModel;
    private Node node;

    public NodeView(NodeModel nodeModel) {
        this.nodeModel = nodeModel;
    }

}
