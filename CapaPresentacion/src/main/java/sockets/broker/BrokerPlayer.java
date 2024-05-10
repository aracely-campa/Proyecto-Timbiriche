package sockets.broker;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import static sockets.broker.Broker.puertoPlayer;
import socktes.chat.PaqueteDatos;

/**
 * BrokerPlayer gestiona las conexiones de los jugadores en un hilo separado,
 * aceptando conexiones y pasando la información recibida al servidor principal.
 */
public class BrokerPlayer implements Runnable {

    /**
     * Inicia el socket del servidor para aceptar conexiones de jugadores.
     */
    public void iniciarSocketCliente() {
        try (ServerSocket socketBroker = new ServerSocket(Broker.puertoPlayer)) {
            while (true) {
                Socket socketCliente = socketBroker.accept();
                Broker.direccionesPlayerSocket.add(socketCliente);
                Thread hilo = new Thread(new EnviarInformacionCliente(socketCliente));
                hilo.start();
            }
        } catch (IOException ex) {
            System.out.println("Error al iniciar el socket del cliente: " + ex.getMessage());
        }
    }

    @Override
    public void run() {
        this.iniciarSocketCliente();
    }

    /**
     * Clase interna que gestiona la comunicación entre el jugador y el
     * servidor.
     */
    public class EnviarInformacionCliente implements Runnable {

        Socket socketPlayer;

        public EnviarInformacionCliente(Socket socketCliente) {
            this.socketPlayer = socketCliente;
        }

        /**
         * Envia información recibida del cliente al servidor.
         *
         * @param socketCliente Socket del cliente.
         * @throws IOException Si hay un error de E/S.
         */
        public void enviarInformacionServidor(Socket socketCliente) throws IOException {
            try {
                while (true) {
                    ObjectInputStream paqueteDatos = new ObjectInputStream(socketPlayer.getInputStream());
                    PaqueteDatos paqueteDatosRecibido = (PaqueteDatos) paqueteDatos.readObject();

                    Socket socketEnviarServidor = Broker.direccionesServerSocket.get(0);
                    ObjectOutputStream paqueteDatosEnvio = new ObjectOutputStream(socketEnviarServidor.getOutputStream());
                    paqueteDatosEnvio.writeObject(paqueteDatosRecibido);
                }
            } catch (IOException | ClassNotFoundException ex) {
                System.out.println("Error al enviar información al servidor: " + ex.getMessage());
                eliminarConexion();
            }
        }

        /**
         * Elimina la conexión del jugador y cierra el socket.
         */
        public void eliminarConexion() {
            try {
                Broker.direccionesPlayerSocket.remove(socketPlayer);
                socketPlayer.close();
            } catch (IOException ex) {
                System.out.println("No se pudo finalizar la conexión: " + ex.getMessage());
            }
        }

        @Override
        public void run() {
            try {
                enviarInformacionServidor(socketPlayer);
            } catch (IOException ex) {
                Logger.getLogger(BrokerPlayer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
