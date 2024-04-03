/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

/**
 *
 * @author luis-
 */
public class GameException extends Exception {
    
    public GameException(){
        
    }
    
    public GameException(String message){
        super(message);
    }
    
    public GameException(String mesage, Throwable cause){
        super(mesage,cause);
    }
    
    
    
}
