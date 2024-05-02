/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.board;

import domain.game.Square;
import domain.graph.Node;
import domainClasses.DomainBoard;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luis-
 */
public class BoardModel {
    
    private Square[][] boardArray;
    private List<Node> nodeList = new ArrayList();
    private DomainBoard domainBoard;
    
    public BoardModel(){
        this.domainBoard= domainBoard;
    }
    
    public BoardModel(Square[][] boardArray, DomainBoard domainBoard) {
        this.boardArray = boardArray;
        this.domainBoard = domainBoard;
    }
    
    public void getSquaresPlayer(){
        
    }
    
    public void createSquares(){
        
    }
    
    public void deleteSquaresPlayers(){
    
    }
    
    public Square[][] getBoardArray() {
        return boardArray;
    }

    public void setBoardArray(Square[][] boardArray) {
        this.boardArray = boardArray;
    }

    public List<Node> getNodeList() {
        return nodeList;
    }

    public void setNodeList(List<Node> nodeList) {
        this.nodeList = nodeList;
    }

    public DomainBoard getDomainBoard() {
        return domainBoard;
    }

    public void setDomainBoard(DomainBoard domainBoard) {
        this.domainBoard = domainBoard;
    }
    
    
    
    

}
