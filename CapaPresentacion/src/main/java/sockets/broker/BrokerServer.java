
package sockets.broker;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import static sockets.broker.Broker.puertoServidor;
import socktes.chat.EnumMensaje;
import socktes.chat.PaqueteDatos;


/**
 *
 * @author arace
 */
public class BrokerServer implements Runnable {
           static Socket servidorSocket;
    static Socket socketRemitente = new Socket();

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
    
    public BrokerServer() {
        servidorSocket = new Socket();
    }

    public  void iniciarSocketServidor() {
        try {
            ServerSocket socketServer = new ServerSocket(puertoServidor);
            servidorSocket = socketServer.accept();
            Broker.direccionesServerSocket.add(servidorSocket);
            while (true) {
                this.enviarInformacionCliente(servidorSocket);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public  void enviarInformacionCliente(Socket socketServidor) {
        try {
            PaqueteDatos paqueteDatosRecibido;
            ObjectInputStream paqueteDatos = new ObjectInputStream(socketServidor.getInputStream());
            paqueteDatosRecibido = (PaqueteDatos) paqueteDatos.readObject();
            if (paqueteDatosRecibido.getPara() == EnumMensaje.PLAYER) {
                for (int i = 0; i < Broker.direccionesPlayerSocket.size(); i++) {
                    System.out.println(socketRemitente);
                    System.out.println(Broker.direccionesPlayerSocket.get(i));
                    if (!socketRemitente.equals(Broker.direccionesPlayerSocket.get(i))) {
                        Socket socketEnviarCliente = Broker.direccionesPlayerSocket.get(i);
                        ObjectOutputStream paqueteDatosEnvio = new ObjectOutputStream(socketEnviarCliente.getOutputStream());
                        paqueteDatosEnvio.writeObject(paqueteDatosRecibido);
                    }
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());

        }
    }

    @Override
    public void run() {
        iniciarSocketServidor();
    }

}
