package com.itson.org.negocio.interfaces;

import domain.game.Player;

public interface IPartida {
    Player anadirJugadorALaLista(Player player);
    
    Player eliminarJugadorDeLaLista(Player player);
    
    
}
