/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

/**
 *
 * @author luis-
 */
public class NodoException extends Exception {

    public NodoException(){

    }

    public NodoException(String message){
        super(message);
    }

    public NodoException(String mesage, Throwable cause){
        super(mesage,cause);
    }
    
    
    
}
