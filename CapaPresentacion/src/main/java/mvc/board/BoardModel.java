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
    
    
    public Integer columns=40;
    public Integer rows=40;
    private Integer size = (int) Math.floor(700/columns);
    public Integer circleSize=(int) Math.floor(size/6);
    public Integer cellSize= size;
    private Integer origin = (int) ((700-cellSize*columns)/2);
    public Integer originX=origin;
    public Integer originY=origin;
    public Integer smollCircleSize=circleSize/2;
    
    public BoardModel() {
        this.domainBoard = new DomainBoard();
    }
    
    public void inicializarValores(){
     this.largoTablero=700;
     this.anchoTablero=700;
     this.coordenadaX=00;
     this.coordenadaY=00;
     
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
