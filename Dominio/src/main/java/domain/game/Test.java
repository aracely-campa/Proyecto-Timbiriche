/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package domain.game;

import domain.graph.Node;
import java.util.List;

/**
 *
 * @author HP 240 G8
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {


        Board board = new Board();
        board.createSmallBoard();
        Player Me= new Player("Me",0, 1);
        Player Luis= new Player("Luis",0, 2);
        Player Hinojosa= new Player("Hinojosa",0, 3);
        Player Chely= new Player("Chely",0, 4);
        
        
        List <Node> nodeList=board.getBoardNodes();
        Square[][] boardArray=board.getBoardArray();
        
        for (Node node: nodeList){
                    System.out.println("ID: "+node.getId());
                    System.out.println("UP: "+node.getUpperEdge());
                    System.out.println("LEFT: "+node.getLeftEdge());
                    System.out.println("DOWN: "+node.getDownEdge());
                    System.out.println("RIGHT: "+node.getRightEdge());
                    System.out.println();
        }
        
                    System.out.println("-------------------------");
        
        
        
        
        Node nodoInicio=nodeList.get(0);
        nodoInicio.getRightEdge().setPlayer(Luis);
        nodoInicio.getRightEdge().getEndingNode().getDownEdge().setPlayer(Me);
        nodoInicio.getDownEdge().setPlayer(Chely);
        nodoInicio.getDownEdge().getEndingNode().getRightEdge().setPlayer(Hinojosa);
        boardArray[0][0].setPlayer(Hinojosa);
        
        Node node14=nodeList.get(15);
        node14.getRightEdge().setPlayer(Luis);
        node14.getRightEdge().getEndingNode().getDownEdge().setPlayer(Me);
        node14.getDownEdge().setPlayer(Chely);
        node14.getDownEdge().getEndingNode().getRightEdge().setPlayer(Hinojosa);
        boardArray[2][1].setPlayer(Luis);

        Node node6 = nodeList.get(25);
        node6.getRightEdge().setPlayer(Me);
        node6.getRightEdge().getEndingNode().getDownEdge().setPlayer(Me);
        node6.getDownEdge().setPlayer(Me);
        node6.getDownEdge().getEndingNode().getRightEdge().setPlayer(Me);
        boardArray[4][1].setPlayer(Me);
        
        System.out.println("Edges\n----------");
        System.out.println(nodoInicio.getRightEdge());
        System.out.println(nodoInicio.getRightEdge().getEndingNode().getDownEdge());
        System.out.println(nodoInicio.getDownEdge());
        System.out.println(nodoInicio.getDownEdge().getEndingNode().getRightEdge());

        System.out.println(node14.getRightEdge());
        System.out.println(node14.getRightEdge().getEndingNode().getDownEdge());
        System.out.println(node14.getDownEdge());
        System.out.println(node14.getDownEdge().getEndingNode().getRightEdge());

        System.out.println(node6.getRightEdge());
        System.out.println(node6.getRightEdge().getEndingNode().getDownEdge());
        System.out.println(node6.getDownEdge());
        System.out.println(node6.getDownEdge().getEndingNode().getRightEdge());
        System.out.println("Squares w players\n----------");
        System.out.println(boardArray[0][0].getPlayer());
        System.out.println(boardArray[2][1].getPlayer());
        System.out.println(boardArray[4][1].getPlayer());
        System.out.println("----------");
        board.deletePlayerTraces(Luis);
        System.out.println("Luisless Squares\n----------");
        System.out.println(boardArray[0][0].getPlayer());
        System.out.println(boardArray[2][1].getPlayer());
        System.out.println(boardArray[4][1].getPlayer());
        System.out.println("----------");
        board.deletePlayerTraces(Me);
        System.out.println("Meless Squares\n----------");
        System.out.println(boardArray[0][0].getPlayer());
        System.out.println(boardArray[2][1].getPlayer());
        System.out.println(boardArray[4][1].getPlayer());
        System.out.println("Edges\n----------");
        System.out.println(nodoInicio.getRightEdge());
        System.out.println(nodoInicio.getRightEdge().getEndingNode().getDownEdge());
        System.out.println(nodoInicio.getDownEdge());
        System.out.println(nodoInicio.getDownEdge().getEndingNode().getRightEdge());

        System.out.println(node14.getRightEdge());
        System.out.println(node14.getRightEdge().getEndingNode().getDownEdge());
        System.out.println(node14.getDownEdge());
        System.out.println(node14.getDownEdge().getEndingNode().getRightEdge());

        System.out.println(node6.getRightEdge());
        System.out.println(node6.getRightEdge().getEndingNode().getDownEdge());
        System.out.println(node6.getDownEdge());
        System.out.println(node6.getDownEdge().getEndingNode().getRightEdge());


        
         System.out.println("------------------------------------------------------");
        System.out.println(nodeList);
        System.out.println("------------------------------------------------------");
        for (int i = 0; i <= boardArray.length; i++) {
            System.out.println();
            for (int j = 0; j <= boardArray[0].length; j++) {
                if (j != 0) {
                    System.out.print("---");
                }
                System.out.print("ID:" + nodeList.get(j + (boardArray.length+1) * i).getId());
            }
        }
        
        
        
        
        
        
    }

}
