package sockets.broker;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * La clase Broker configura y gestiona las conexiones de red para los jugadores
 * y los servidores en una arquitectura de intermediario. Utiliza sockets para
 * establecer y mantener las conexiones.
 */
public class Broker {

    static int puertoServidor = 9090; // Puerto en el que escucha las conexiones del servidor.
    static int puertoPlayer = 9091;   // Puerto en el que escucha las conexiones de los jugadores.
    static List<Socket> direccionesServerSocket = new ArrayList<>(); // Almacena las conexiones activas de los servidores.
    static List<Socket> direccionesPlayerSocket = new ArrayList<>(); // Almacena las conexiones activas de los jugadores.
    static Thread hiloPlayer; // Hilo dedicado a manejar las conexiones de los jugadores.
    static Thread hiloServidor; // Hilo dedicado a manejar las conexiones del servidor.
    static BrokerPlayer brokerPlayer = new BrokerPlayer(); // Instancia del gestor de jugadores.
    static BrokerServer brokerServidor = new BrokerServer(); // Instancia del gestor de servidores.

    /**
     * Método main que inicia la aplicación. Configura y lanza los hilos para la
     * gestión de las conexiones de jugadores y servidores.
     *
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        hiloPlayer = new Thread(brokerPlayer); // Crea un hilo para manejar las conexiones de jugadores.
        hiloServidor = new Thread(brokerServidor); // Crea un hilo para manejar las conexiones de servidores.
        hiloPlayer.start(); // Inicia el hilo de jugadores.
        hiloServidor.start(); // Inicia el hilo de servidores.
    }
}
