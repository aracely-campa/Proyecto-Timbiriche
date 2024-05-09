package domainClasses;

import domain.game.Board;

public class DomainBoard {

    private static DomainBoard domainBoard;
    
    private Board board;

    public DomainBoard() {
        this.board = Board.getInstance();
    }

    public void createSmallBoard() {
        board.createSmallBoard();
    }

    public void createSmallBoardArray() {
        board.createSmallBoardArray();
    }

    public void createSmallBoardGraph() {
        board.createSmallBoardGraph();
    }

    public static DomainBoard getInstance() {
        if (domainBoard == null) {
            domainBoard = new DomainBoard();
        }
        return domainBoard;
    }

}
