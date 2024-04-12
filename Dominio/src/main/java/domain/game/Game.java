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

    private Integer tamanoDePartida;

    public Game() {
    }

    public Game(Player[] players, Board board, Integer tamanoDePartida) {
        this.players = players;
        this.board = board;
        this.tamanoDePartida = tamanoDePartida;

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
            throw new GameException("El juego ya estaba iniciado, no se puede volver a iniciar.");
        }

        this.setGameIntoElements();
        this.setInGame(true);

    }

    private void setGameIntoElements() throws GameException {
        setGameIntoBoard();
    }

    private void setGameIntoBoard() throws GameException {

        if (this.board == null) {
            throw new GameException("El tablero no esta inicializado.");
        }

        board.setGame(game);
    }




    public void addPlayer(Player player) throws GameException {
        if (isInGame()) {
            throw new GameException("El juego aun no ha comenzado, no se pueden agregar jugadores todavia.");
        }

        if (player == null) {
            throw new GameException("El Jugador ingresado es nuelo");
        }

        if (isMatchFull()) {
            throw new GameException("La partida esta llena, ya no recibe mas jugadores");
        }

        addPlayerToMatch(player);

        if (isMatchFull()) {
            startGame();
        }
    }

    private void addPlayerToMatch(Player player) {
        for (int i = 0; i < tamanoDePartida; i++) {
            if (comprobarEspacioEnPartida()) {
                players[i] = player;
                return;
            }
        }
    }
    public boolean comprobarEspacioEnPartida(){
        return !(players.length > tamanoDePartida);
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
            throw new GameException("El juego no esta iniciado todavia, no puedes eliminar el jugador.");
        }

        if (player == null) {
            throw new GameException("El jugador que se esta intentando eliminar no existe o es nulo.");
        }

        int foundIndex = findPlayerIndex(player);

        if (foundIndex != -1) {
            shiftPlayers(foundIndex);
        } else {
            throw new GameException("Tronó juego jijijij");
        }
    }

    @Override
    public String toString() {
        return "Game{" + "player=" + players + ", board=" + board + '}';
    }

}
