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

    private PaqueteDatos paqueteEnvioDatos; // Almacena el paquete de datos a enviar.
    private PaqueteDatos paqueteReciboDatos; // Almacena el paquete de datos recibido.
    private final int puerto = 9091; // Puerto de conexión.
    private Socket playerSocket; // Socket para la conexión del jugador.
    private final String ip = "localhost"; // Dirección IP para la conexión.

    public ConexionPlayer() {
    }

    /**
     * Empaqueta los parámetros para crear un paquete de datos a enviar.
     *
     * @param nombre Nombre del remitente.
     * @param mensaje Mensaje a enviar.
     * @param tipo Tipo de mensaje, definido por EnumMensaje.
     */
    @Override
    public void empaquetarParametros(String nombre, String mensaje, EnumMensaje tipo) {
        paqueteEnvioDatos = new PaqueteDatos(nombre, mensaje, ip, tipo);
    }

    /**
     * Inicia el socket conectando al servidor especificado por IP y puerto.
     */
    @Override
    public void iniciarSocket() {
        try {
            playerSocket = new Socket(ip, puerto);
        } catch (IOException ex) {
            System.out.println("Error al abrir el socket: " + ex.getMessage());
        }
    }

    /**
     * Envía el paquete de datos empacado a través del socket.
     */
    @Override
    public void enviarDatos() {
        try (ObjectOutputStream paqueteDatos = new ObjectOutputStream(playerSocket.getOutputStream())) {
            paqueteDatos.writeObject(paqueteEnvioDatos);
        } catch (IOException ex) {
            System.out.println("Error al enviar datos: " + ex.getMessage());
        }
    }

    /**
     * Cierra el socket de conexión.
     */
    @Override
    public void cerrarSocket() {
        try {
            playerSocket.close();
        } catch (IOException ex) {
            System.out.println("Error al cerrar el socket: " + ex.getMessage());
        }
    }

    /**
     * Recibe datos continuamente del servidor hasta que se cierra la conexión.
     */
    @Override
    public void recibirDatos() {
        try {
            while (!playerSocket.isClosed()) {
                ObjectInputStream paqueteDatos = new ObjectInputStream(playerSocket.getInputStream());
                paqueteReciboDatos = (PaqueteDatos) paqueteDatos.readObject();
                desempaquetarDatos();
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error al recibir datos: " + ex.getMessage());
        }
    }

    /**
     * Desempaqueta los datos recibidos y los muestra en la consola.
     */
    @Override
    public void desempaquetarDatos() {
        String nombre = paqueteReciboDatos.getNombre();
        String mensaje = paqueteReciboDatos.getMensaje();
        String ip = paqueteReciboDatos.getIp();
        System.out.println(nombre + ": " + mensaje + " (de IP: " + ip + ")");
    }

    /**
     * Inicia el hilo de ejecución para recibir datos.
     */
    @Override
    public void iniciarHilo() {
        Thread conexionCliente = new Thread(this);
        conexionCliente.start();
    }

    /**
     * Método run del hilo que inicia la recepción de datos.
     */
    @Override
    public void run() {
        recibirDatos();
    }
}