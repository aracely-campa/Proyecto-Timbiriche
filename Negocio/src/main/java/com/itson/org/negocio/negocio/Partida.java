package com.itson.org.negocio.negocio;

import com.itson.org.negocio.excepciones.AgregarJugadorException;
import com.itson.org.negocio.excepciones.AnadirPuntoAJugador;
import com.itson.org.negocio.excepciones.EliminarJugadorException;
import com.itson.org.negocio.excepciones.PartidaException;
import com.itson.org.negocio.excepciones.ValidarTamanoDePartidaException;
import domain.game.Player;
import com.itson.org.negocio.interfaces.IPartida;
import domain.game.Game;

public class Partida implements IPartida {

    Game game = Game.getInstance();

    @Override
    public Player anadirJugadorALaLista(Player player) throws PartidaException {

        try {
            if (validarAgregarJugadorALista(player)) {
                if (validarEspacioDeParitda()) {
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
    public Player eliminarJugadorDeLaLista(Player player) throws PartidaException {

        try {
            if (validarEliminarJugadorDeLaLista(player)) {
                this.game.deletePlayer(player);
            }
        } catch (EliminarJugadorException e) {
            throw new PartidaException(e.getMessage());
        }

        return player;
    }

    public boolean validarEliminarJugadorDeLaLista(Player player) throws EliminarJugadorException {

        if (player == null) {
            throw new EliminarJugadorException("El jugador ha sido |Null| al momento de tratar de  ingresarlo a la lista de la Partida");
        }

        if (player.getId() == 0) {
            throw new EliminarJugadorException("El |ID| del jugador ha sido nulo al momento de tratar de ingresarlo a la lista de la Partida");
        }

        if (player.getName().isBlank() || player.getName().isEmpty()) {
            throw new EliminarJugadorException("El |Nombre| del jugador ha sido nulo o estaba vacio al momento de tratar de ingresarlo a la lista de la Partida");
        }

        if (!(game.playerExistOnTheList(player))) {
            throw new EliminarJugadorException("El |Jugador| que se ha ingresado no existe en la lista de jugadores, entonces no se puede eliminar");
        }

        return true;
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

    public boolean validarEspacioDeParitda() throws ValidarTamanoDePartidaException {

        if (game.getGamePlayerListSize() == 0) {
            throw new ValidarTamanoDePartidaException("El |Tamaño| de la cantidad de jugadores que pueden entrar a la partida aun no ha sido definido");
        }

        if (game.canAddAPlayerToGame()) {
            throw new ValidarTamanoDePartidaException("La |Cantidad| de jugadores que pueden entrar a la partida ya ha sido cubierta");
        }

        return true;
    }

    public boolean validarAnadirPuntoAJugador(Player player, Integer puntos) throws AnadirPuntoAJugador {

        if (player == null) {
            throw new AnadirPuntoAJugador("El jugador ha sido |Null| al momento de tratar de  ingresarlo a la lista de la Partida");
        }

        if (player.getId() == 0) {
            throw new AnadirPuntoAJugador("El |ID| del jugador ha sido nulo al momento de tratar de ingresarlo a la lista de la Partida");
        }

        if (player.getName().isBlank() || player.getName().isEmpty()) {
            throw new AnadirPuntoAJugador("El |Nombre| del jugador ha sido nulo o estaba vacio al momento de tratar de ingresarlo a la lista de la Partida");
        }

        if (puntos == null || puntos <= 0) {
            throw new AnadirPuntoAJugador("El |Puntaje| a agregar al jugador ha sido nulo o era 0 al momento de tratar de ingresarlo al Puntaje del Jugador");
        }

        return true;
    }

    @Override
    public Player anadirPuntoAJugador(Player player, Integer puntos) throws PartidaException {

        try {
            if (validarAnadirPuntoAJugador(player, puntos)) {
                game.getPlayerOfList(player).addScore(puntos);
            }
        } catch (AnadirPuntoAJugador e) {
            throw new PartidaException(e.getMessage());
        }

        return player;
    }

}
