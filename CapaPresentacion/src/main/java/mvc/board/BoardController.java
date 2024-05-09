/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.board;

import interfaces.MatchObserver;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import javax.swing.SwingUtilities;

/**
 *
 * @author luis-
 */
public class BoardController extends MouseAdapter {
    
    private BoardView boardView;
    private BoardModel boardModel;
    private ArrayList<MatchObserver> observadores = new ArrayList<>();
    
    public BoardController(BoardView boardView, BoardModel boardModel) {
        this.boardView = boardView;
        this.boardModel = boardModel;
        notificar();
    }
    
    public void addObserver(MatchObserver observadores) {
        this.observadores.add(observadores);
    }
    
    public BoardView getBoardView() {
        return boardView;
    }
    
    public void setBoardView(BoardView boardView) {
        this.boardView = boardView;
    }
    
    public BoardModel getBoardModel() {
        return boardModel;
    }
    
    public void setBoardModel(BoardModel boardModel) {
        this.boardModel = boardModel;
    }
    
    public void refreshBoard() {
        this.boardView.repaint();
    }
    
    public void notificar() {
        this.boardView.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (SwingUtilities.isLeftMouseButton(evt)) {
                    notificarObservadores();
                }
            }
        }
        );
    }
    
    public void notificarObservadores() {
        for (MatchObserver observer : observadores) {
            observer.eventOnBoardUpdate();
        }
    }
    
}
