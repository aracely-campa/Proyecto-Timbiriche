package com.itson.org.negocio.negocio;

import com.itson.org.negocio.excepciones.AgregarJugadorException;
import com.itson.org.negocio.excepciones.PartidaException;
import com.itson.org.negocio.excepciones.ValidarTamanoDePartidaException;
import domain.game.Player;
import com.itson.org.negocio.interfaces.IPartida;
import domain.game.Game;

public class Partida implements IPartida {

    Game game = Game.getInstance();

    @Override
    public Player anadirJugadorALaLista(Player player) throws PartidaException{

        try {
            if (validarAgregarJugadorALista(player)) {
               if(validarEspacioDeParitda()){
                   game.addPlayer(player);
               }
            } else {

            }
        } catch (AgregarJugadorException | ValidarTamanoDePartidaException e) {
            throw new PartidaException(e.getMessage());
        }

        return null;
    }

    @Override
    public Player eliminarJugadorDeLaLista(Player player) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean validarAgregarJugadorALista(Player player) throws AgregarJugadorException {

        if (player == null) {
            throw new AgregarJugadorException("El jugador ha sido |Null| al momento de tratar de  ingresarlo a la lista de la Partida");
        }

        if (player.getId() == 0) {
            throw new AgregarJugadorException("El |ID| del jugador ha sido nulo al momento de tratar de ingresarlo a la lista de la Partida");
        }

        if (player.getName().isBlank() || player.getName().isEmpty()) {
            throw new AgregarJugadorException("El |Nombre| del jugador ha sido nulo o estaba vacio al momento de tratar de ingresarlo a la lista de la Partida");
        }

        return true;
    }

    
    public boolean validarEspacioDeParitda() throws ValidarTamanoDePartidaException{

        if(game.getGamePlayerListSize() == 0){
        throw new ValidarTamanoDePartidaException("El |Tamaño| de la cantidad de jugadores que pueden entrar a la partida aun no ha sido definido");
        }
        
        if(game.canAddAPlayerToGame()){
            throw new ValidarTamanoDePartidaException("La |Cantidad| de jugadores que pueden entrar a la partida ya ha sido cubierta");
        }
        
        return true;
    }

    @Override
    public Player anadirPuntoAJugador(Player player) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
    

}
