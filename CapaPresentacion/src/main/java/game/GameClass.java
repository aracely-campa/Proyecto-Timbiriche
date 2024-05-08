/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import domain.game.Player;
import events.BoardEvents;
import events.NodeEvents;
import events.PlayerEvents;
import interfaces.MatchObserver;
import javax.swing.JOptionPane;
import mvc.board.BoardView;
import mvc.game.GameComponent;
import mvc.player.PlayerView;

public class GameClass implements MatchObserver {

    public GameComponent gameComponent;

    private Player player;

    public GameClass(Player player) {
        this.player = player;
        this.gameComponent = new GameComponent();
    }
//public boolean hasTileSelected() {
//        return playerTileSelected != null;
//    }
    
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

    

//    @Override
//    public void eventOnBoardUpdate(BoardEvents evt) {
//          if (BoardEvents.LEFT_CLICK_ON_BOARD_EVENT.equals(evt)) {
//        if (hasTileSelected()) {
//            if (canPlaceTileOnBoard(playerTileSelected)) {
//                JOptionPane.showMessageDialog(null, "Has puesto la ficha: " + playerTileSelected.getTile().getId());
//                addTileToBoardList(getTileFromPlayer(playerTileSelected));
//                playerTileSelected = null;
//            } else {
//                JOptionPane.showMessageDialog(null, "No puedes colocar esa ficha en esa posición.");
//            }
//        } else {
//            JOptionPane.showMessageDialog(null, "You have to select a tile to set it on the board");
//        }
//    }
//    }

    @Override
    public void eventOnPlayerUpdate(PlayerEvents evt) {
        if (PlayerEvents.LEFT_CLICK_ON_PLAYER_EVENT.equals(evt)) {
            
            JOptionPane.showMessageDialog(null, "You clicked on a incorrect place or tile");
        }
    }

    @Override
    public void eventOnNodeUpdate(NodeEvents evt) {
         if (NodeEvents.LEFT_CLICK_ON_POOL_EVENT.equals(evt)) {
//            getTileFromPoolEvent();
        }
    }


}
