package socktes.chat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author arace
 */
public class ConexionPlayer implements Runnable, IProxyPlayer {

    PaqueteDatos paqueteEnvioDatos;
    PaqueteDatos paqueteReciboDatos;
    int puerto = 9091;
    Socket playerSocket;
    final String ip = "localhost";

    public ConexionPlayer() {
    }

    @Override
    public void empaquetarParametros(String nombre, String mensaje, EnumMensaje tipo) {
        paqueteEnvioDatos = new PaqueteDatos(nombre, mensaje, ip, tipo);
    }

    @Override
    public void iniciarSocket() {
        try {
            playerSocket = new Socket(ip, puerto);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void enviarDatos() {
        try {
            ObjectOutputStream paqueteDatos = new ObjectOutputStream(playerSocket.getOutputStream());
            paqueteDatos.writeObject(paqueteEnvioDatos);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void cerrarSocket() {
        try {
            playerSocket.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void recibirDatos() {
        try {
            while (true) {
                ObjectInputStream paqueteDatos = new ObjectInputStream(playerSocket.getInputStream());
                paqueteReciboDatos = (PaqueteDatos) paqueteDatos.readObject();
                desempaquetarDatos();
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void desempaquetarDatos() {
        String nombre, mensaje, ip;
        nombre = paqueteReciboDatos.getNombre();
        mensaje = paqueteReciboDatos.getMensaje();
        ip = paqueteReciboDatos.getIp();
        System.out.println(nombre + ": " + mensaje);
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
        Thread conexionCliente = new Thread(this);
        conexionCliente.start();
    }

    @Override
    public void run() {
        recibirDatos();
    }

}
