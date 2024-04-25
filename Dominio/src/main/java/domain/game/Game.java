package domain.game;

import exceptions.GameException;

public class Game {

    private static Game game;

    private Board board;

    private Player[] players;

    //Esto especifica si el jugador esta iniciado o no,
    // Ture == "Juego en curso", False == "Juego no en curso";
    private boolean gameStatus;

    private Integer tamanoDePartida;

    //Constructor por default
    public Game() {
    }

    public Game(Board board, Integer tamanoDePartida) {
        this.board = board;
        this.tamanoDePartida = tamanoDePartida;
    }

    private void startGame() {
        this.setGameIntoElements();
        this.setGameStarted();
    }

    private void finishGame() {
        removeGameElements();
        this.setGameFinished();
    }

    public Player[] createPlayerListWithSize(Integer tamanoInteger) {
        return this.players = new Player[tamanoInteger];
    }

    private void setGameIntoElements() {
        setGameIntoBoard();
    }

    private void removeGameElements() {
        removeBoardOfGame();
    }

    private void removeBoardOfGame() {
        board.setBoard(null);
    }

    private void setGameIntoBoard() {
        board.setGame(game);
    }

    public void addPlayer(Player player) {

        addPlayerToMatch(player);

        if (matchCanStart()) {
            startGame();
        }
    }

    private void addPlayerToMatch(Player player) {
        for (int i = 0; i < tamanoDePartida; i++) {
            if (comprovePlayersInGame()) {
                players[i] = player;
                players[i].setId(i);
                return;
            }
        }
    }

    public boolean comprovePlayersInGame() {
        return !(players.length > tamanoDePartida);
    }

    public boolean canAddAPlayerToGame() {
        return comprovePlayersInGame();
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
        for (Player players : this.players) {
            if (players == player) {
                return players.getId();
            }
        }

        return -1;
    }

    public int getGamePlayerListSize() {
        return tamanoDePartida;
    }

    public void deletePlayer(Player player) {
        for (int i = 0; i < players.length; i++) {
            if (this.players[i] == player) {
                this.players[i] = null;

            }
        }

    }

    public Player getPlayerOfList(Player player) {
        for (Player playerList : this.players) {
            if (player == playerList) {
             return playerList;
            }
        }

        return null;
    }

    public boolean matchCanStart() {
        return isMatchFull();
    }

    public void setGameFinished() {
        this.gameStatus = false;
    }

    public void setGameStarted() {
        this.gameStatus = true;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public boolean getGameStarted() {
        return gameStatus;
    }

    public Player[] getPlayerList() {
        return players;
    }

    public boolean playerExistOnTheList(Player player) {
        for (Player playerList : this.players) {
            if (player == playerList) {
                return true;
            }
        }

        return false;
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
        return gameStatus;
    }

    public static Game getInstance() {
        if (game == null) {
            game = new Game();
        }
        return game;
    }

    @Override
    public String toString() {
        return "Game{" + "player=" + players + ", board=" + board + '}';
    }

}
