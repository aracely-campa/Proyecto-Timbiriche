/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.board;

/**
 *
 * @author luis-
 */
public class BoardComponent {

    private BoardModel boardModel;
    private BoardView boardView;
    private BoardController boardController;
    
    private static BoardComponent boardComponent;

    public BoardComponent() {
        this.boardModel = new BoardModel();
        boardModel.setAnchoTablero(976);
        boardModel.setLargoTablero(542);
        boardModel.setCoordenadaX(0);
        boardModel.setCoordenadaY(200);
        
        this.boardView = new BoardView(boardModel);
        this.boardController = new BoardController(boardView, boardModel);
    }

    public BoardController getBoardController() {
        return boardController;
    }

    public void setBoardController(BoardController boardController) {
        this.boardController = boardController;
    }

    public BoardModel getBoardModel() {
        return boardModel;
    }

    public void setBoardModel(BoardModel boardModel) {
        this.boardModel = boardModel;
    }

    public BoardView getBoardView() {
        return boardView;
    }

    public void setBoardView(BoardView boardView) {
        this.boardView = boardView;
    }
    
    public void refresh() {
        this.boardController.refreshBoard();
    }
    
    

    public static BoardComponent getInstance() {
        if (boardComponent == null) {
            boardComponent = new BoardComponent();
        }
        return boardComponent;
    }

}
