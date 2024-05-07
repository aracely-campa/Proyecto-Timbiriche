/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.board;

/**
 *
 * @author luis-
 */
public class BoardView {

    private BoardModel boardModel;

    public BoardView(BoardModel boardModel) {
        this.boardModel = boardModel;

    }

    public BoardModel getBoardModel() {
        return boardModel;
    }

    public void setBoardModel(BoardModel boardModel) {
        this.boardModel = boardModel;
    }

}
