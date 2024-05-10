package sockets.broker;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import static sockets.broker.Broker.puertoServidor;
import socktes.chat.EnumMensaje;
import socktes.chat.PaqueteDatos;

/**
 * BrokerServer maneja las conexiones de entrada desde un servidor central y
 * reenvía mensajes a los clientes apropiados. Funciona como un servidor
 * intermediario dentro de una arquitectura de mensajería o juego en red.
 */
public class BrokerServer implements Runnable {

    static Socket servidorSocket; // Socket para aceptar conexiones del servidor principal.
    static Socket socketRemitente = new Socket(); // Socket desde el cual se recibe el último mensaje.

    /**
     * Constructor de BrokerServer que inicializa un socket.
     */
    public BrokerServer() {
        servidorSocket = new Socket();
    }

    /**
     * Inicia el servidor escuchando conexiones entrantes y procesando mensajes.
     */
    public void iniciarSocketServidor() {
        try (ServerSocket socketServer = new ServerSocket(Broker.puertoServidor)) {
            servidorSocket = socketServer.accept(); // Acepta la conexión del servidor principal.
            Broker.direccionesServerSocket.add(servidorSocket); // Agrega la conexión a la lista de servidores activos.
            while (true) {
                enviarInformacionCliente(servidorSocket); // Procesa y reenvía mensajes continuamente.
            }
        } catch (IOException ex) {
            System.out.println("Error en el servidor: " + ex.getMessage());
        }
    }

    /**
     * Reenvía información recibida desde el servidor a los clientes (jugadores)
     * correspondientes.
     *
     * @param socketServidor Socket del servidor desde el cual se recibe la
     * información.
     */
    public void enviarInformacionCliente(Socket socketServidor) {
        try {
            ObjectInputStream paqueteDatos = new ObjectInputStream(socketServidor.getInputStream());
            PaqueteDatos paqueteDatosRecibido = (PaqueteDatos) paqueteDatos.readObject();

            if (paqueteDatosRecibido.getPara() == EnumMensaje.PLAYER) {
                for (Socket socket : Broker.direccionesPlayerSocket) {
                    if (!socketRemitente.equals(socket)) {
                        ObjectOutputStream paqueteDatosEnvio = new ObjectOutputStream(socket.getOutputStream());
                        paqueteDatosEnvio.writeObject(paqueteDatosRecibido);
                    }
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(BrokerServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        iniciarSocketServidor();
    }

    // Getters y setters simplificados
    public static Socket getServidorSocket() {
        return servidorSocket;
    }

    public static void setServidorSocket(Socket servidorSocket) {
        BrokerServer.servidorSocket = servidorSocket;
    }

    public Socket getSocketRemitente() {
        return socketRemitente;
    }

    public void setSocketRemitente(Socket socketRemitente) {
        this.socketRemitente = socketRemitente;
    }
}
