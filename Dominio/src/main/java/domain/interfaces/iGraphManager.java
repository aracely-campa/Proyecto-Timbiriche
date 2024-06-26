/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package domain.interfaces;

import Services.CoordsDTO;
import domain.graph.Node;
import java.util.List;

/**
 *
 * @author HP 240 G8
 */
public interface iGraphManager {

    public void joinHorizontalNodes(Node nodeBeggining, Node nodeEnding);

    public void joinVerticalNodes(Node nodeBeggining, Node nodeEnding);

    public void fixFirstRow(Node node);

    public void fixLastRow(Node node);

    public void fixFirstColumn(Node node);

    public void fixLastColumn(Node node);

    public Node createNode();

    public List<CoordsDTO> getScoredSquaresCoords(Node node) throws Exception;

    }
