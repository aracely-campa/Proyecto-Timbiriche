package socktes.chat;

import java.util.Scanner;

/**
 *
 * @author arace
 */
public class Chat implements Runnable {

    static Scanner tec = new Scanner(System.in);
    static String nombre, mensaje, ip;
    static ProxyPlayer proxyPlayer = new ProxyPlayer();

    public static void main(String[] args) {
        Thread chat = new Thread(new Chat());
        chat.start();
    }

    @Override
    public void run() {
        System.out.println("--Bienvenido al chat timbiriche :D --");
        System.out.println("Ingresa tu nombre para poder chatear: ");
        nombre = tec.nextLine();
        System.out.println("Envia mensaje: ");
        proxyPlayer.iniciarSocket();
        proxyPlayer.iniciarHilo();
        do {
            System.out.print(nombre + ": ");
            mensaje = tec.nextLine();
            if (mensaje.equalsIgnoreCase("desconectar")) {
                break;
            }
            proxyPlayer.empaquetarParametros(nombre, mensaje, EnumMensaje.CLIENTE);
            proxyPlayer.enviarDatos();
        } while (true);
        proxyPlayer.cerrarSocket();
    }

}
