/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainClasses;

import domain.game.Game;
import domain.game.Player;
import exceptions.GameException;

/**
 *
 * @author luis-
 */
public class DomainGame {

    private final Game game;

    public DomainGame() {
        this.game = Game.getInstance();
    }

    public void addPlayer(Player player) throws GameException {
        game.addPlayer(player);
    }

    public void comprobarEspacioEnPartida() throws GameException {
        game.comprobarEspacioEnPartida();

    }

    public void createPlayerListWithSize(Integer size) throws GameException {
        game.createPlayerListWithSize(size);
    }

    public void deletePlayer(Player player) throws GameException {
        game.deletePlayer(player);
    }

    public Player[] getPlayersOnGame(){
        return this.game.getPlayerList();
    }
    
}
