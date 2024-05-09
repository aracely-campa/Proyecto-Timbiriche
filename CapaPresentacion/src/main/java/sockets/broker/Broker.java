package sockets.broker;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author arace
 */
public class Broker {

    static int puertoServidor = 9090;
    static int puertoPlayer = 9091;
    static List<Socket> direccionesServerSocket = new ArrayList();
    static List<Socket> direccionesPlayerSocket = new ArrayList();
    static Thread hiloPlayer;
    static Thread hiloServidor;
    static BrokerPlayer brokerPlayer = new BrokerPlayer();
    static BrokerServer brokerServidor = new BrokerServer();

    public static void main(String[] args) {
        hiloPlayer = new Thread(brokerPlayer);
        hiloServidor = new Thread(brokerServidor);
        hiloPlayer.start();
        hiloServidor.start();
    }

}
