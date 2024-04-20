/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainClasses;

import domain.game.Board;

/**
 *
 * @author luis-
 */
public class DomainBoard {
    
    private Board board;

    public DomainBoard(Board board) {
        this.board = Board.getInstance();
    }
    
    public void createSmallBoard(){
        board.createSmallBoard();
    }
    
    public void createSmallBoardArray(){
        board.createSmallBoardArray();
    } 
    
    public void createSmallBoardGraph(){
        board.createSmallBoardGraph();
    }
    
    
}
