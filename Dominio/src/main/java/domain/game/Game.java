package domain.game;

import domain.player.Player;
import exceptions.GameException;

public class Game {

    private Player[] players;
    
    private Board board;
    
    private boolean gameStarted = false;
    
    private Game game;
    
    private Integer tamanoDePartida;

    //Constructor por default
    public Game() {
    }

    public Game(Player[] players, Board board, Integer tamanoDePartida) {
        this.players = players;
        this.board = board;
        this.tamanoDePartida = tamanoDePartida;

    }

    private void startGame() throws GameException {
        if (gameStarted) {
            throw new GameException("El juego ya estaba iniciado, no se puede volver a iniciar.");
        }

        this.setGameIntoElements();
        this.setGameStarted();

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
        if (isGameStarted()) {
            throw new GameException("El juego aun no ha comenzado, no se pueden agregar jugadores todavia.");
        }

        if (player == null) {
            throw new GameException("El Jugador ingresado es nuelo");
        }

        if (isMatchFull()) {
            throw new GameException("La partida esta llena, ya no recibe mas jugadores");
        }

        addPlayerToMatch(player);

        if (matchCanStart()) {
            startGame();
        }
    }

    private void addPlayerToMatch(Player player) {
        for (int i = 0; i < tamanoDePartida; i++) {
            if (comprobarEspacioEnPartida()) {
                players[i] = player;
                players[i].setId(i);
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

    public void deletePlayer(Player player) throws GameException {

        if (player == null) {
            throw new GameException("El jugador que se esta intentando eliminar no existe o es nulo.");
        }

        for (int i = 0; i < 4; i++) {
            if (this.players[i] == player) {
                this.players[i] = null;
            }
        }

    }

        
    public boolean matchCanStart(){
        return isMatchFull();
    }
    
    public void setGameFinished(){
        this.gameStarted = false;
    }

    public void setGameStarted(){
        this.gameStarted = true;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public boolean getGameStarted() {
        return gameStarted;
    }

    public Player[] getPlayer() {
        return players;
    }

    public void setPlayersWithList(Player[] player) {
        this.players = player;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public boolean isGameStarted() {
        return gameStarted;
    }

    @Override
    public String toString() {
        return "Game{" + "player=" + players + ", board=" + board + '}';
    }

}
