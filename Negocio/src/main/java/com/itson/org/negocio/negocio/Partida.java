package com.itson.org.negocio.negocio;

import domain.game.Player;
import com.itson.org.negocio.interfaces.IPartida;

public class Partida implements IPartida{

    @Override
    public Player anadirJugadorALaLista(Player player) {
        if(validarJugador()){
            //meterlo
        }
        
        return null;
    }

    @Override
    public Player eliminarJugadorDeLaLista(Player player) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public boolean validarJugador(){
        
        
        return true;
    }
    
    public boolean validarEspacioDeParitda(){
        
     //   if()
        
        return true;
    }
    
}
