package sockets.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import socktes.chat.EnumMensaje;

import socktes.chat.PaqueteDatos;

/**
 *
 * @author arace
 */
public class ConexionServidor implements Runnable, IProxyServidor {

    PaqueteDatos paqueteEnvioDatos;
    PaqueteDatos paqueteReciboDatos;
    int puerto = 9090;
    Socket servidorSocket;
    final String ip = "localhost";

    public ConexionServidor() {
    }

    @Override
    public void empaquetarParametros(String nombre, String mensaje, String ip) {
        paqueteEnvioDatos = new PaqueteDatos(nombre, mensaje, ip);
    }

    @Override
    public void iniciarSocket() {
        try {
            servidorSocket = new Socket(ip, puerto);
            PaqueteDatos paquete = new PaqueteDatos(EnumMensaje.SERVER);
            ObjectOutputStream paqueteDatos = new ObjectOutputStream(servidorSocket.getOutputStream());
            paqueteDatos.writeObject(paquete);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void enviarDatos() {
        try {
            ObjectOutputStream paqueteDatos = new ObjectOutputStream(servidorSocket.getOutputStream());
            paqueteDatos.writeObject(paqueteEnvioDatos);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void recibirDatos() {
        try {
            while (true) {
                ObjectInputStream paqueteDatos = new ObjectInputStream(servidorSocket.getInputStream());
                paqueteReciboDatos = (PaqueteDatos) paqueteDatos.readObject();
                desempaquetarDatos();
                paqueteEnvioDatos = paqueteReciboDatos;
                ChatServer.actualizarHistorial(paqueteReciboDatos);
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void cerrarSocket() {
        try {
            servidorSocket.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void desempaquetarDatos() {
        String nombre, mensaje, ip;
        nombre = paqueteReciboDatos.getNombre();
        mensaje = paqueteReciboDatos.getMensaje();
        ip = paqueteReciboDatos.getIp();
        System.out.println(nombre + ": " + mensaje + ", de la IP: " + ip);
    }

    public PaqueteDatos getPaqueteEnvioDatos() {
        return paqueteEnvioDatos;
    }

    public void setPaqueteEnvioDatos(PaqueteDatos paqueteEnvioDatos) {
        this.paqueteEnvioDatos = paqueteEnvioDatos;
    }

    public PaqueteDatos getPaqueteReciboDatos() {
        return paqueteReciboDatos;
    }

    public void setPaqueteReciboDatos(PaqueteDatos paqueteReciboDatos) {
        this.paqueteReciboDatos = paqueteReciboDatos;
    }

    @Override
    public void iniciarHilo() {
        run();
    }

    @Override
    public void run() {
        recibirDatos();
    }

}
