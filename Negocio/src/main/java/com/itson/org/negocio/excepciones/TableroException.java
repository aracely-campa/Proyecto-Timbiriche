/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.org.negocio.excepciones;

/**
 *
 * @author PC
 */
public class TableroException extends Exception {

    public TableroException() {

    }

    public TableroException(String message) {
        super(message);
    }

    public TableroException(String mesage, Throwable cause) {
        super(mesage, cause);
    }
}
