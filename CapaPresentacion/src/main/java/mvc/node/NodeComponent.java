/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.node;

/**
 *
 * @author arace
 */
public class NodeComponent {
    private NodeController nodeController;
    private NodeModel nodeModel;
    private NodeView nodeView;
    private static NodeComponent nodeComponent;

    public NodeComponent(NodeController nodeController, NodeModel nodeModel, NodeView nodeView) {
        this.nodeController = nodeController;
        this.nodeModel = nodeModel;
        this.nodeView = nodeView;
    }

    public NodeController getNodeController() {
        return nodeController;
    }

    public void setNodeController(NodeController nodeController) {
        this.nodeController = nodeController;
    }

    public NodeModel getNodeModel() {
        return nodeModel;
    }

    public void setNodeModel(NodeModel nodeModel) {
        this.nodeModel = nodeModel;
    }

    public NodeView getNodeView() {
        return nodeView;
    }

    public void setNodeView(NodeView nodeView) {
        this.nodeView = nodeView;
    }

    public static NodeComponent getNodeComponent() {
        return nodeComponent;
    }

    public static void setNodeComponent(NodeComponent nodeComponent) {
        NodeComponent.nodeComponent = nodeComponent;
    }
    
    
    
}