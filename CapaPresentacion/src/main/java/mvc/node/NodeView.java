/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.node;

import domain.graph.Node;
import javax.swing.JPanel;

import javax.swing.JPanel;

/**
 * NodeView es un componente visual que representa un nodo en la interfaz
 * gráfica de usuario. Extiende JPanel, permitiendo personalizar la
 * representación gráfica del nodo gestionado por NodeModel.
 */
public class NodeView extends JPanel {

    private NodeModel nodeModel; // El modelo que contiene los datos y el estado del nodo que esta vista debe representar.

    /**
     * Constructor de NodeView que inicializa la vista con un modelo de nodo
     * específico.
     *
     * @param nodeModel El modelo del nodo que esta vista debe representar.
     */
    public NodeView(NodeModel nodeModel) {
        this.nodeModel = nodeModel;
        initializeUI();
    }

    /**
     * Inicializa la interfaz de usuario del componente, configurando
     * propiedades visuales básicas y preparando cualquier elemento gráfico
     * necesario para la representación del nodo.
     */
    private void initializeUI() {
        // Configurar el tamaño, el color de fondo u otros atributos estéticos.
        setOpaque(false); // Ejemplo de configuración: hace el fondo transparente.

        // Aquí podrían añadirse más configuraciones, como añadir subcomponentes o configurar layouts.
    }

    /**
     * Sobreescribe el método paintComponent para dibujar el nodo de acuerdo con
     * los datos del modelo. Este método es llamado automáticamente por la
     * infraestructura de Swing cuando es necesario redibujar el panel.
     *
     * @param g El objeto Graphics utilizado para realizar el dibujo.
     */
    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        // Ejemplo de dibujo: dibujar un círculo representando el nodo.
        g.drawOval(10, 10, 80, 80); // Estos valores son arbitrarios, deben ajustarse según el diseño.

        // Si el modelo contiene información específica de estilo o estado, debería usarse aquí para ajustar el dibujo.
    }
}
