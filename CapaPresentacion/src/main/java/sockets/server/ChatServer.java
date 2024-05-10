package sockets.server;

import java.util.ArrayList;
import java.util.List;
import socktes.chat.PaqueteDatos;

/**
 * ChatServer es responsable de gestionar un servidor de chat. Inicia y mantiene
 * la conexión del servidor, así como el historial de los mensajes del chat.
 */
public class ChatServer {

    final static int puerto = 9090; // Puerto en el que el servidor escuchará las conexiones entrantes.
    static ProxyServidor proxyServidor; // Manejador de conexiones y comunicaciones del servidor.
    static List<PaqueteDatos> historialChat = new ArrayList<>(); // Almacena el historial de todos los mensajes de chat.

    /**
     * Método principal que inicia el servidor de chat.
     *
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        iniciarServidor();
    }

    /**
     * Inicia el servidor configurando y ejecutando el proxy del servidor.
     * Captura y maneja excepciones relacionadas con la configuración de red.
     */
    public static void iniciarServidor() {
        try {
            proxyServidor = new ProxyServidor();
            proxyServidor.iniciarSocket(); // Inicia el socket para escuchar conexiones entrantes.
            proxyServidor.iniciarHilo(); // Inicia un hilo para manejar las conexiones entrantes y la comunicación de datos.

        } catch (Exception ex) {
            System.out.println("Error al iniciar el servidor: " + ex.getMessage());
        }
    }

    /**
     * Actualiza el historial de chat al recibir un nuevo paquete de datos y
     * notifica al proxy para enviar datos.
     *
     * @param paqueteDatos Nuevo paquete de datos recibido que será añadido al
     * historial.
     */
    public static void actualizarHistorial(PaqueteDatos paqueteDatos) {
        historialChat.add(paqueteDatos); // Añade el nuevo mensaje al historial.
        proxyServidor.enviarDatos(); // Envía el nuevo mensaje a todos los clientes conectados.
    }

}
