
package mvc.node;

/**
 * NodeComponent es una clase que actúa como fachada para agrupar todas las
 * funcionalidades relacionadas con un nodo específico en el sistema, incluyendo
 * su controlador, modelo y vista. Implementa el patrón Singleton para
 * garantizar una única instancia de este componente.
 */
public class NodeComponent {

    private NodeController nodeController; // Controlador para la lógica específica de interacción con el nodo.
    private NodeModel nodeModel;           // Modelo que almacena los datos y el estado del nodo.
    private NodeView nodeView;             // Vista que representa visualmente el nodo.
    private static NodeComponent nodeComponent; // Instancia estática para el patrón Singleton.

    /**
     * Constructor de NodeComponent que inicializa el controlador, el modelo y
     * la vista del nodo.
     *
     * @param nodeController El controlador del nodo.
     * @param nodeModel El modelo del nodo.
     * @param nodeView La vista del nodo.
     */
    public NodeComponent(NodeController nodeController, NodeModel nodeModel, NodeView nodeView) {
        this.nodeController = nodeController;
        this.nodeModel = nodeModel;
        this.nodeView = nodeView;
    }

    /**
     * Obtiene el controlador asociado con este componente de nodo.
     *
     * @return El controlador del nodo.
     */
    public NodeController getNodeController() {
        return nodeController;
    }

    /**
     * Establece un nuevo controlador para este componente de nodo.
     *
     * @param nodeController El nuevo controlador del nodo.
     */
    public void setNodeController(NodeController nodeController) {
        this.nodeController = nodeController;
    }

    /**
     * Obtiene el modelo asociado con este componente de nodo.
     *
     * @return El modelo del nodo.
     */
    public NodeModel getNodeModel() {
        return nodeModel;
    }

    /**
     * Establece un nuevo modelo para este componente de nodo.
     *
     * @param nodeModel El nuevo modelo del nodo.
     */
    public void setNodeModel(NodeModel nodeModel) {
        this.nodeModel = nodeModel;
    }

    /**
     * Obtiene la vista asociada con este componente de nodo.
     *
     * @return La vista del nodo.
     */
    public NodeView getNodeView() {
        return nodeView;
    }

    /**
     * Establece una nueva vista para este componente de nodo.
     *
     * @param nodeView La nueva vista del nodo.
     */
    public void setNodeView(NodeView nodeView) {
        this.nodeView = nodeView;
    }

    /**
     * Devuelve la única instancia del componente de nodo, creándola si es
     * necesario.
     *
     * @return La única instancia de NodeComponent.
     */
    public static NodeComponent getNodeComponent() {
        if (nodeComponent == null) {
            nodeComponent = new NodeComponent(null, null, null); // Considera inicializar con valores reales
        }
        return nodeComponent;
    }

    /**
     * Establece la instancia única del componente de nodo, útil para pruebas o
     * reconfiguraciones específicas.
     *
     * @param nodeComponent La nueva instancia de NodeComponent.
     */
    public static void setNodeComponent(NodeComponent nodeComponent) {
        NodeComponent.nodeComponent = nodeComponent;
    }
}
