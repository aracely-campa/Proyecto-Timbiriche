/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.node;

/**
 * NodeController es responsable de coordinar las interacciones entre el modelo
 * y la vista de un nodo. Gestiona la lógica de negocio que afecta al estado del
 * nodo y responde a las entradas del usuario transmitidas por la vista.
 */
public class NodeController {

    private NodeModel nodeModel; // Modelo que contiene los datos y la lógica del estado del nodo.
    private NodeView nodeView;   // Vista que proporciona la representación gráfica del nodo.

    /**
     * Constructor de NodeController que inicializa el controlador con un modelo
     * y una vista específicos.
     *
     * @param nodeModel El modelo del nodo que maneja los datos y la lógica de
     * estado.
     * @param nodeView La vista del nodo que maneja la representación visual.
     */
    public NodeController(NodeModel nodeModel, NodeView nodeView) {
        this.nodeModel = nodeModel;
        this.nodeView = nodeView;
    }

    /**
     * Devuelve el modelo del nodo asociado con este controlador.
     *
     * @return El modelo del nodo.
     */
    public NodeModel getNodeModel() {
        return nodeModel;
    }

    /**
     * Establece un nuevo modelo para el nodo.
     *
     * @param nodeModel El nuevo modelo del nodo.
     */
    public void setNodeModel(NodeModel nodeModel) {
        this.nodeModel = nodeModel;
    }

    /**
     * Devuelve la vista del nodo asociada con este controlador.
     *
     * @return La vista del nodo.
     */
    public NodeView getNodeView() {
        return nodeView;
    }

    /**
     * Establece una nueva vista para el nodo.
     *
     * @param nodeView La nueva vista del nodo.
     */
    public void setNodeView(NodeView nodeView) {
        this.nodeView = nodeView;
    }
}
