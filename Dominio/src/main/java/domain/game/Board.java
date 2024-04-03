/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain.game;

import domain.graph.Node;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author arace
 */
public class Board extends Game{
    
    private Square[][] boardArray;
    private List<Node> nodeList = new ArrayList();
    private NodeBuilder nodeBuilder = new NodeBuilder();
    private GraphManager graphManager = new GraphManager();

    public void createSmallBoard() {

        createSmallBoardArray();
        createSmallBoardGraph();
    }

    public void createSmallBoardArray() {
        boardArray = new Square[5][5];

        for (int i = 0; i < boardArray.length; i++) {
            for (int j = 0; j < boardArray[0].length; j++) {
                boardArray[i][j] = new Square();
            }
        }
    }

    public void createSmallBoardGraph() {

        for (int i = 0; i < boardArray.length; i++) {
            for (int j = 0; j < boardArray[0].length; j++) {
                nodeBuilder.setID();
                nodeList.add(nodeBuilder.getProduct());
                //System.out.println("ID:"+nodeBuilder.getProduct().getId());
                nodeBuilder.reset();
            }
        }

        for (int i = 0; i < boardArray.length; i++) {
            for (int j = 0; j < boardArray[0].length; j++) {
                //System.out.println(j + boardArray.length * i);
                //I = Y Coords
                //J = X Coords
                //N = boardArray.length
                //X+NY+1 = Index
                System.out.println("\nI: "+i+"J: "+j);
                //Sets then upper node to null if the tempNode belongs to the first row
                if (i == 0) {
                    //i+(n*(j-1))+1 gives the index of the item in the row below
                    graphManager.joinVerticalNodes(null, nodeList.get(j + boardArray.length * i));
                    graphManager.fixFirstRow(nodeList.get(j + boardArray.length * i));
                } else {
                    //i+3*j+1 gives the index of the item in the upper row
                    //i+2*j+1 gives the index of the item in the row below
                    graphManager.joinVerticalNodes(nodeList.get(j + boardArray.length * (i - 1)), nodeList.get(j + boardArray.length * i));
                    if (i==boardArray[0].length-1){
                    graphManager.fixLastRow(nodeList.get(j + boardArray.length * i));
                    }
                     
                }
                //Sets then Left node to null if the tempNode belongs to the first column
                if (j == 0) {
                    //i+4*j+2 gives the index of the previous item
                    graphManager.joinHorizontalNodes(null, nodeList.get(j + boardArray.length * i));
                    graphManager.fixFirstColumn(nodeList.get(j + boardArray.length * i));
                } else {
                    //i+4*j gives the index of the previous item
                    //i+4*j+2 gives the index of the previous item
                    graphManager.joinHorizontalNodes(nodeList.get(j + boardArray.length * i-1), nodeList.get(j + boardArray.length * i));
                    if(j==boardArray[0].length-1){
                    graphManager.fixLastColumn(nodeList.get(j + boardArray.length * i));
                    }
                }
                //nodeList.set(i + 4 * j + 1, tempNode);
            }

        }
    }

    public List getBoardNodes() {
        return nodeList;
    }

    public Square[][] getBoardArray() {
        return boardArray;
    }
}
