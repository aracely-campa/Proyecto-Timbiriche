/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import domain.graph.Node;
import java.util.List;

/**
 *
 * @author HP 240 G8
 */
public class PlayerTracesDTO {

    private List<CoordsDTO> squaresCoords;
    private List<Node> verticalEdgesList;
    private List<Node> horizontalEdgesList;

    public PlayerTracesDTO() {
    }

    public PlayerTracesDTO(List<CoordsDTO> squaresCoords, List<Node> verticalEdgesList, List<Node> horizontalEdgesList) {
        this.squaresCoords = squaresCoords;
        this.verticalEdgesList = verticalEdgesList;
        this.horizontalEdgesList = horizontalEdgesList;
    }

    public List<CoordsDTO> getSquaresCoords() {
        return squaresCoords;
    }

    public void setSquaresCoords(List<CoordsDTO> squaresCoords) {
        this.squaresCoords = squaresCoords;
    }

    public List<Node> getVerticalEdgesList() {
        return verticalEdgesList;
    }

    public void setVerticalEdgesList(List<Node> verticalEdgesList) {
        this.verticalEdgesList = verticalEdgesList;
    }

    public List<Node> getHorizontalEdgesList() {
        return horizontalEdgesList;
    }

    public void setHorizontalEdgesList(List<Node> horizontalEdgesList) {
        this.horizontalEdgesList = horizontalEdgesList;
    }
}
