/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.org.negocio.excepciones;

/**
 *
 * @author PC
 */
public class AgregarJugadorException extends Exception {

    public AgregarJugadorException() {

    }

    public AgregarJugadorException(String message) {
        super(message);
    }

    public AgregarJugadorException(String mesage, Throwable cause) {
        super(mesage, cause);
    }
}
