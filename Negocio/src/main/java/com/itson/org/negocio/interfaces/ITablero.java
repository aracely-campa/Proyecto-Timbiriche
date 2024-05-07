package com.itson.org.negocio.interfaces;

import com.itson.org.negocio.excepciones.PartidaException;
import com.itson.org.negocio.excepciones.TableroException;
import domain.game.Player;
import domain.graph.Node;

public interface ITablero {
    
    Player unirNodosPorJugador(Player player, Node[] nodos) throws TableroException;
  
    
}
