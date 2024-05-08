/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import domain.game.Player;
import mvc.board.BoardView;
import mvc.game.GameComponent;
import mvc.player.PlayerView;

public class GameClass {

    public GameComponent gameComponent;

    private Player player;

    public GameClass(Player player) {
        this.player = player;
        this.gameComponent = new GameComponent();
    }

//    //Suscripcion a los eventos
//    public void suscribeToBoardView() {
//        this.gameComponent.suscribeToBoard(this);
//    }
//    
//    public void suscribeToPoolView() {
//        this.gameComponent.suscribeToPool(this);
//    }
//    
//    public void suscribeToPlayerView() {
//        this.gameComponent.suscribeToPlayer(this);
//    }
    public Player[] getPlayersOnGame() {
        return this.gameComponent.getPlayersOnGame();
    }

    public BoardView getBoardView() {
        return gameComponent.getBoardComponent().getBoardView();

    }

    public PlayerView getPlayerView() {
        return gameComponent.getPlayerComponent().getPlayerView();
    }

}
