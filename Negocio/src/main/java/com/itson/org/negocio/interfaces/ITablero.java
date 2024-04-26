package com.itson.org.negocio.interfaces;

import com.itson.org.negocio.excepciones.PartidaException;
import domain.game.Player;

public interface ITablero {
    
    Player anadirJugadorALaLista(Player player) throws PartidaException;
    
    Player eliminarJugadorDeLaLista(Player player) throws PartidaException;
    
    Player anadirPuntoAJugador(Player player, Integer puntos) throws PartidaException;
    
}
