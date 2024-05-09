package socktes.chat;

import java.util.Scanner;

/**
 *
 * @author arace
 */
public class ChatBroker implements Runnable {

    static Scanner tec = new Scanner(System.in);
    static String nombre, mensaje, ip;
    static ProxyCliente proxyCliente = new ProxyCliente();

    public static void main(String[] args) {
        Thread chat = new Thread(new ChatBroker());
        chat.start();
    }

    @Override
    public void run() {
        System.out.println("--Bienvenido al chat timbiriche :D --");
        System.out.println("Ingresa tu nombre para poder chatear: ");
        nombre = tec.nextLine();
        System.out.println("Envia mensaje: ");
        proxyCliente.iniciarSocket();
        proxyCliente.iniciarHilo();
        do {
            System.out.print(nombre + ": ");
            mensaje = tec.nextLine();
            if (mensaje.equalsIgnoreCase("desconectar")) {
                break;
            }
            proxyCliente.empaquetarParametros(nombre, mensaje, Mensaje.CLIENTE);
            proxyCliente.enviarDatos();
        } while (true);
        proxyCliente.cerrarSocket();
    }

}
