package sockets.server;

import java.util.ArrayList;
import java.util.List;

import socktes.chat.PaqueteDatos;

/**
 *
 * @author arace
 */
public class ChatServer {
    final static int puerto = 9090;
    static ProxyServidor proxyServidor;
    static List<PaqueteDatos> historialChat = new ArrayList();

    public static void main(String[] args) {
        iniciarServidor();
    }

    public static void iniciarServidor() {
        try {
            proxyServidor = new ProxyServidor();
            proxyServidor.iniciarSocket();
            proxyServidor.iniciarHilo();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void actualizarHistorial(PaqueteDatos paqueteDatos) {
        historialChat.add(paqueteDatos);
        proxyServidor.enviarDatos();
    }

}
