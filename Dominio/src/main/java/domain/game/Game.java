package domain.game;

import exceptions.GameException;

public class Game {

    private Game game;
    
    private Board board;
    
    private Player[] players;
    
    //Esto especifica si el jugador esta iniciado o no,
    // Ture == "Juego en curso", False == "Juego no en curso";
    private boolean gameStatus;
    
    public Integer tamanoDePartida;

    //Constructor por default
    public Game() {
    }

    public Game(Board board, Integer tamanoDePartida) {
        this.board = board;
        this.tamanoDePartida = tamanoDePartida;
    }
    
    private void startGame() throws GameException {
        if (gameStatus) {
            throw new GameException("El juego ya estaba iniciado, no se puede volver a iniciar.");
        }

        this.setGameIntoElements();
        this.setGameStarted();
    }
    
    private void finishGame() throws GameException{
        if(!(gameStatus)){
            throw new GameException("El juego aun no esta iniciado, no se puede terminar.");
        }
        removeGameElements();
        this.setGameFinished();
    }
    
    public Player[] createPlayerListWithSize(Integer tamanoInteger) throws GameException{
        
        if(this.players != null){
            throw new GameException("La lista ya esta instanciada, no se puede añadir");
        }
        
       return this.players = new Player[tamanoInteger];
    }
    
    private void setGameIntoElements() throws GameException {
        setGameIntoBoard();
    }
    
    private void removeGameElements() throws GameException{
        removeBoardOfGame();
    }
    
    private void removeBoardOfGame() throws GameException {
        if(this.board == null){
            throw new GameException("No se habia establecido un tablero antes.");
        }
        
        board.setBoard(null);
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
         for (Player players : this.players) {
             if(players == player){
                 return players.getId();
             }
        }
        
        
        return -1;
    }


    
    public void deletePlayer(Player player) throws GameException {

        if (player == null) {
            throw new GameException("El jugador que se esta intentando eliminar no existe o es nulo.");
        }

        for (int i = 0; i < players.length; i++) {
            if (this.players[i] == player) {
                this.players[i] = null;
            }
        }

    }

        
    public boolean matchCanStart(){
        return isMatchFull();
    }
    
    public void setGameFinished(){
        this.gameStatus = false;
    }

    public void setGameStarted(){
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

    @Override
    public String toString() {
        return "Game{" + "player=" + players + ", board=" + board + '}';
    }

}
