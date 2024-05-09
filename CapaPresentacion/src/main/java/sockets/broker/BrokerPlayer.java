
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
 *
 * @author arace
 */
public class BrokerPlayer implements Runnable {

    public void iniciarSocketCliente() {
        try {
            ServerSocket socketBroker = new ServerSocket(puertoPlayer);
            while (true) {
                Socket socketCliente;
                socketCliente = socketBroker.accept();
                Broker.direccionesPlayerSocket.add(socketCliente);
                Thread hilo = new Thread(new enviarInformacionCliente(socketCliente));
                hilo.start();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void run() {
        this.iniciarSocketCliente();
    }

    public class enviarInformacionCliente implements Runnable {

        Socket socketPlayer;

        public enviarInformacionCliente(Socket socketCliente) {
            this.socketPlayer = socketPlayer;

        }

        public void enviarInformacionServidor(Socket socketCliente) throws IOException {
            try {
                while (true) {
                    BrokerServer.socketRemitente = socketCliente;
                    PaqueteDatos paqueteDatosRecibido;
                    ObjectInputStream paqueteDatos = new ObjectInputStream(socketPlayer.getInputStream());
                    Socket socketEnviarServidor = Broker.direccionesServerSocket.get(0);
                    paqueteDatosRecibido = (PaqueteDatos) paqueteDatos.readObject();
                    ObjectOutputStream paqueteDatosEnvio = new ObjectOutputStream(socketEnviarServidor.getOutputStream());
                    paqueteDatosEnvio.writeObject(paqueteDatosRecibido);
                }
            } catch (IOException | ClassNotFoundException ex) {

                this.eliminarConexion();
            }
        }

        public void eliminarConexion() {
            try {
                Broker.direccionesPlayerSocket.remove(socketPlayer);
                this.socketPlayer.close();
            } catch (IOException ex) {
                System.out.println("No se pudo finalizar la conexion");
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
