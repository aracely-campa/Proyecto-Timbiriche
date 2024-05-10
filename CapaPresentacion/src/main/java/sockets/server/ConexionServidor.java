package sockets.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import socktes.chat.EnumMensaje;
import socktes.chat.PaqueteDatos;

/**
 * ConexionServidor gestiona la comunicación con el servidor utilizando sockets,
 * implementa las funcionalidades necesarias para conectar, enviar y recibir
 * datos.
 */
public class ConexionServidor implements Runnable, IProxyServidor {

    private PaqueteDatos paqueteEnvioDatos;
    private PaqueteDatos paqueteReciboDatos;
    private final int puerto = 9090;
    private Socket servidorSocket;
    private final String ip = "localhost";

    public ConexionServidor() {
    }

    /**
     * Prepara un paquete de datos para ser enviado al servidor.
     *
     * @param nombre Nombre del remitente.
     * @param mensaje Mensaje a enviar.
     * @param ip IP del remitente.
     */
    @Override
    public void empaquetarParametros(String nombre, String mensaje, String ip) {
        paqueteEnvioDatos = new PaqueteDatos(nombre, mensaje, ip);
    }

    /**
     * Inicia la conexión con el servidor creando un socket y enviando un
     * paquete inicial.
     */
    @Override
    public void iniciarSocket() {
        try {
            servidorSocket = new Socket(ip, puerto);
            ObjectOutputStream paqueteDatos = new ObjectOutputStream(servidorSocket.getOutputStream());
            paqueteDatos.writeObject(new PaqueteDatos(EnumMensaje.SERVER));
        } catch (IOException ex) {
            System.out.println("Error al iniciar el socket: " + ex.getMessage());
        }
    }

    /**
     * Envía los datos empaquetados al servidor.
     */
    @Override
    public void enviarDatos() {
        try {
            ObjectOutputStream paqueteDatos = new ObjectOutputStream(servidorSocket.getOutputStream());
            paqueteDatos.writeObject(paqueteEnvioDatos);
        } catch (IOException ex) {
            System.out.println("Error al enviar datos: " + ex.getMessage());
        }
    }

    /**
     * Recibe datos del servidor y los procesa.
     */
    @Override
    public void recibirDatos() {
        try {
            while (true) {
                ObjectInputStream paqueteDatos = new ObjectInputStream(servidorSocket.getInputStream());
                paqueteReciboDatos = (PaqueteDatos) paqueteDatos.readObject();
                desempaquetarDatos();
                ChatServer.actualizarHistorial(paqueteReciboDatos);
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error al recibir datos: " + ex.getMessage());
        }
    }

    /**
     * Cierra la conexión del socket.
     */
    @Override
    public void cerrarSocket() {
        try {
            servidorSocket.close();
        } catch (IOException ex) {
            System.out.println("Error al cerrar el socket: " + ex.getMessage());
        }
    }

    /**
     * Extrae y muestra la información del paquete de datos recibido.
     */
    @Override
    public void desempaquetarDatos() {
        String nombre = paqueteReciboDatos.getNombre();
        String mensaje = paqueteReciboDatos.getMensaje();
        String ip = paqueteReciboDatos.getIp();
        System.out.println(nombre + ": " + mensaje + ", de la IP: " + ip);
    }

    /**
     * Inicia el hilo para procesar continuamente los datos entrantes.
     */
    @Override
    public void iniciarHilo() {
        new Thread(this).start();
    }

    /**
     * Método run del hilo, invoca recibirDatos para manejar la recepción
     * continua de información.
     */
    @Override
    public void run() {
        recibirDatos();
    }
}
