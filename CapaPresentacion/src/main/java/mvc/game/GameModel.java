/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.game;

import domain.game.Board;
import domain.game.Game;
import domain.game.Player;
import domainClasses.DomainBoard;
import domainClasses.DomainGame;

/**
 *
 * @author luis-
 */
public class GameModel {

    private DomainGame domainGame;

    private DomainBoard domainBoard;

    private boolean gameStarted = false;

    private Integer tamanoDePartida;

    public GameModel(Integer tamanoDePartida) {
        this.domainGame = new DomainGame();
        this.domainBoard = domainBoard;
        this.tamanoDePartida = tamanoDePartida;
    }

    public GameModel() {
    }

    public void createGame() {
        this.domainGame=domainGame;
    }

    public DomainGame getDomainGame() {
        return domainGame;
    }

    public void setDomainGame(DomainGame domainGame) {
        this.domainGame = domainGame;
    }

    public DomainBoard getDomainBoard() {
        return domainBoard;
    }

    public void setDomainBoard(DomainBoard domainBoard) {
        this.domainBoard = domainBoard;
    }

    public boolean isGameStarted() {
        return gameStarted;
    }

    public void setGameStarted(boolean gameStarted) {
        this.gameStarted = gameStarted;
    }

    public Integer getTamanoDePartida() {
        return tamanoDePartida;
    }

    public void setTamanoDePartida(Integer tamanoDePartida) {
        this.tamanoDePartida = tamanoDePartida;
    }

    @Override
    public String toString() {
        return "GameModel{" + ", gameStarted=" + gameStarted + ", tamanoDePartida=" + tamanoDePartida + '}';
    }

}
