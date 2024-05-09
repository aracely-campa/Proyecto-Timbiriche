package mvc.board;

import domain.game.Square;
import domain.graph.Node;
import domainClasses.DomainBoard;
import java.util.ArrayList;
import java.util.List;

public class BoardModel {

    private Square[][] boardArray;
    private List<Node> nodeList = new ArrayList();
    private DomainBoard domainBoard;

    private Integer coordenadaX;

    private Integer coordenadaY;

    private Integer anchoTablero;

    private Integer largoTablero;
    
    public BoardModel() {
        this.domainBoard = new DomainBoard();
    }
    
    public void inicializarValores(){
     this.largoTablero=700;
     this.anchoTablero=700;
     this.coordenadaX=0;
     this.coordenadaY=0;
    }
    
    public BoardModel(Square[][] boardArray, DomainBoard domainBoard) {
        this.boardArray = boardArray;
        this.domainBoard = domainBoard;
    }

    public void getSquaresPlayer() {

    }

    public void createSquares() {

    }

    public void deleteSquaresPlayers() {

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

    public Integer getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(Integer coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public Integer getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(Integer coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public Integer getAnchoTablero() {
        return anchoTablero;
    }

    public void setAnchoTablero(Integer anchoTablero) {
        this.anchoTablero = anchoTablero;
    }

    public Integer getLargoTablero() {
        return largoTablero;
    }

    public void setLargoTablero(Integer largoTablero) {
        this.largoTablero = largoTablero;
    }

}
