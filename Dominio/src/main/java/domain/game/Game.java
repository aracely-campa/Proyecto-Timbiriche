/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain.game;

import domain.player.Player;
import exceptions.GameException;

/*
 *
 * @author arace
 */
public class Game {

    private Player[] players;
    private Board board;
    private boolean inGame = false;
    private Game game;

    public Game() {
    }

    public Game(Player[] players, Board board) {
        this.players = players;
        this.board = board;

    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public boolean isInGame() {
        return inGame;
    }

    public void setInGame(boolean inGame) {
        this.inGame = inGame;
    }

    public Player[] getPlayer() {
        return players;
    }

    public void setPlayer(Player[] player) {
        this.players = player;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public boolean isInGame(boolean inGame) {
        return inGame;
    }

    public void setInGame() {
        this.inGame = inGame;
    }

    private void startGame() throws GameException {
        if (inGame) {
            throw new GameException("Trono juego jjjj");
        }

        this.setGameIntoElements();
        this.setInGame(true);

    }

    private void setGameIntoElements() throws GameException {
        setGameIntoBoard();
        setGameIntoPlayers();
    }

    private void setGameIntoPlayers() throws GameException {

        if (this.players == null || this.players.length < 1) {
            throw new GameException("Trono juego jjjj");
        }

        for (Player player : players) {

            if (player == null) {
                throw new GameException("Trono juego jjjj");
            }

            player.setGame(this);
        }

    }

    private void setGameIntoBoard() throws GameException {

        if (this.board == null) {
            throw new GameException("Trono juego jjjj");
        }

        board.setGame(game);
    }

    private int getPlayerIndexTurn() {
        for (int i = 0; i < this.players.length; i++) {
            Player playerSelected = this.players[i];
            if (playerSelected != null && playerSelected.isTurn()) {
                return i;
            }
        }
        return -1;
    }

    private void passTurn() throws GameException {
        int playerIndexTurn = this.getPlayerIndexTurn();
        int nextTurn;

        if (playerIndexTurn == -1) {
            throw new GameException("Trono juego jjjj");
        }

        if (playerIndexTurn == (this.players.length - 1)) {
            nextTurn = 0;
        } else {
            nextTurn = playerIndexTurn + 1;
        }

    }

    public void addPlayer(Player player) throws GameException {
        if (isInGame()) {
            throw new GameException("Trono juego jjjj");
        }

        if (player == null) {
            throw new GameException("Trono juego jjjj");
        }

        if (isMatchFull()) {
            throw new GameException("Trono juego jjjj");
        }

        addPlayerToMatch(player);

        if (isMatchFull()) {
            startGame();
        }
    }

    private void addPlayerToMatch(Player player) {
        for (int i = 0; i < 4; i++) {
            if (players[i] == null) {
                players[i] = player;
                return;
            }
        }
    }

    private boolean isMatchFull() {
        for (Player player : players) {
            if (player == null) {
                return false;
            }
        }
        return true;
    }

    private int findPlayerIndex(Player player) {
        for (int i = 0; i < 4; i++) {
            if (this.players[i] == player) {
                return i;
            }
        }
        return -1;
    }

    private void shiftPlayers(int index) {
        for (int i = index; i < 3; i++) {
            this.players[i] = this.players[i + 1];
        }
        this.players[3] = null;
    }

    public void deletePlayer(Player player) throws GameException {
        if (isInGame()) {
            throw new GameException("Trono juego jjjj");
        }

        if (player == null) {
            throw new GameException("Trono juego jjjj");
        }

        int foundIndex = findPlayerIndex(player);

        if (foundIndex != -1) {
            shiftPlayers(foundIndex);
        } else {
            throw new GameException("Trono juego jjjj");
        }
    }

    @Override
    public String toString() {
        return "Game{" + "player=" + players + ", board=" + board + '}';
    }

}
