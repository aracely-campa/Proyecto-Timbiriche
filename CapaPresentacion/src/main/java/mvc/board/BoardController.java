/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.board;

import game.GameClass;
import interfaces.MatchObserver;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import javax.swing.SwingUtilities;

public class BoardController extends MouseAdapter {

    private BoardView boardView;
    private BoardModel boardModel;
    private ArrayList<MatchObserver> observadores;

    public BoardController(BoardView boardView, BoardModel boardModel) {
        this.boardView = boardView;
        this.boardModel = boardModel;
        this.observadores = new ArrayList<>();
        this.notificar();
    }

    public void addObserver(MatchObserver observador) {
        this.observadores.add(observador);
        System.out.println("Observador añadido: " + observador.getClass().getSimpleName());
        System.out.println("tamaño: " + observadores.size());
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

    private void notificar() {
        this.boardView.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.out.println("Mouse clicked");
                if (SwingUtilities.isLeftMouseButton(evt)) {
                    System.out.println("Mouse left clicked");
                    notificarObservadores();
                }
            }
        });
    }

    public void notificarObservadores() {
        System.out.println("Notificando a " + observadores.size() + " observadores");
        for (MatchObserver observer : observadores) {
            
            observer.eventOnBoardUpdate();
        }
    }

}
