package com.itson.org.negocio.negocio;

import com.itson.org.negocio.excepciones.TableroException;
import com.itson.org.negocio.excepciones.validarNodosDisponiblesExceptions;
import com.itson.org.negocio.interfaces.ITablero;
import domain.game.Game;
import domain.game.Player;
import domain.graph.Node;

public class Tablero implements ITablero {

    Game game = Game.getInstance();

    @Override
    public Player unirNodosPorJugador(Player player, Node[] nodos) throws TableroException {
        try {

            if (validarNodosDisponibles(player, nodos)) {
                return null;
            }

        } catch (validarNodosDisponiblesExceptions e) {
            throw new TableroException(e.getMessage());
        }

        return null;
    }

    public boolean validarNodosDisponibles(Player player, Node[] nodos) throws validarNodosDisponiblesExceptions {
        if (player == null) {
            throw new validarNodosDisponiblesExceptions("El jugador ha sido |Null| al momento de tratar de  ingresarlo a la lista de la Partida");
        }

        if (player.getId() == 0) {
            throw new validarNodosDisponiblesExceptions("El |ID| del jugador ha sido nulo al momento de tratar de ingresarlo a la lista de la Partida");
        }

        if (player.getName().isBlank() || player.getName().isEmpty()) {
            throw new validarNodosDisponiblesExceptions("El |Nombre| del jugador ha sido nulo o estaba vacio al momento de tratar de ingresarlo a la lista de la Partida");
        }

        if (!(game.playerExistOnTheList(player))) {
            throw new validarNodosDisponiblesExceptions("El |Jugador| que se ha ingresado no existe en la lista de jugadores, entonces no se puede eliminar");
        }

        if (validasrNodosIndividualmente(nodos)) {
            throw new validarNodosDisponiblesExceptions("");

        }

        return true;

    }

    public boolean validasrNodosIndividualmente(Node[] nodos) throws validarNodosDisponiblesExceptions {

        for (Node nodes : nodos) {
            if (nodes == null) {
                return false;
            }
        }

        return true;

    }

//       @Override
//    public Player eliminarJugadorDeLaLista(Player player) throws PartidaException {
//
//        try {
//            if (validarEliminarJugadorDeLaLista(player)) {
//                this.game.deletePlayer(player);
//            }
//        } catch (EliminarJugadorException e) {
//            throw new PartidaException(e.getMessage());
//        }
//
//        return player;
//    }
//
//    public boolean validarEliminarJugadorDeLaLista(Player player) throws EliminarJugadorException {
//
//        if (player == null) {
//            throw new EliminarJugadorException("El jugador ha sido |Null| al momento de tratar de  ingresarlo a la lista de la Partida");
//        }
//
//        if (player.getId() == 0) {
//            throw new EliminarJugadorException("El |ID| del jugador ha sido nulo al momento de tratar de ingresarlo a la lista de la Partida");
//        }
//
//        if (player.getName().isBlank() || player.getName().isEmpty()) {
//            throw new EliminarJugadorException("El |Nombre| del jugador ha sido nulo o estaba vacio al momento de tratar de ingresarlo a la lista de la Partida");
//        }
//
//        if (!(game.playerExistOnTheList(player))) {
//            throw new EliminarJugadorException("El |Jugador| que se ha ingresado no existe en la lista de jugadores, entonces no se puede eliminar");
//        }
//
//        return true;
//    }
}
