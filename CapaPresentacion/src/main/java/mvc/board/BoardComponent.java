package mvc.board;

public class BoardComponent {

    private BoardModel boardModel = new BoardModel();
    private BoardView boardView = new BoardView(boardModel);
    private BoardController boardController = new BoardController(boardView, boardModel);

    private static BoardComponent boardComponent;

    private BoardComponent() {
     boardModel.inicializarValores();
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
