/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.game;

import domain.game.Board;
import domain.game.Game;
import domain.game.Player;


/**
 *
 * @author luis-
 */
public class GameModel {
    
    private Game game;
        
    private Board board;
    
    private boolean gameStarted=false;
    
    private Integer tamanoDePartida;
    
    
    public GameModel(Game game, Board board, Player[] players, Integer tamanoDePartida) {
        this.game = new Game();
        this.board = board;
        this.tamanoDePartida = tamanoDePartida;
    }
    
    public GameModel() {
    }
    
    public void createGame(){
        this.game=game;
    }
    
    
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
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
        return "GameModel{" + "game=" + game  + ", gameStarted=" + gameStarted + ", tamanoDePartida=" + tamanoDePartida + '}';
    }
    
    
    
    
    
}
