package com.itson.org.negocio.interfaces;

import com.itson.org.negocio.excepciones.PartidaException;
import domain.game.Player;

public interface IPartida {
    
    Player anadirJugadorALaLista(Player player) throws PartidaException;
    
    Player eliminarJugadorDeLaLista(Player player) throws PartidaException;
    
    Player anadirPuntoAJugador(Player player) throws PartidaException;
    
}
