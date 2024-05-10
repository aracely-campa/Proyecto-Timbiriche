package socktes.chat;

import java.util.Scanner;

/**
 *
 * @author arace
 */

/**
 * Chat permite a los usuarios interactuar a través de una interfaz de consola para enviar mensajes.
 * Implementa Runnable para que pueda ser ejecutado en un hilo separado, permitiendo operaciones de red asíncronas.
 */
public class Chat implements Runnable {

    static Scanner tec = new Scanner(System.in); // Scanner para leer la entrada del usuario.
    static String nombre, mensaje, ip;
    static ProxyPlayer proxyPlayer = new ProxyPlayer(); // Instancia del ProxyPlayer que maneja la conexión.

    /**
     * Punto de entrada principal del programa. Inicia el hilo de chat.
     * 
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        Thread chat = new Thread(new Chat());
        chat.start();
    }

    /**
     * Método run que se ejecuta cuando el hilo del chat se inicia.
     */
    @Override
    public void run() {
        System.out.println("--Bienvenido al chat timbiriche :D --");
        System.out.println("Ingresa tu nombre para poder chatear: ");
        nombre = tec.nextLine();

        System.out.println("Envia mensaje: ");
        proxyPlayer.iniciarSocket();  // Inicia la conexión del socket.
        proxyPlayer.iniciarHilo();    // Inicia el hilo para la comunicación asincrónica.

        do {
            System.out.print(nombre + ": ");
            mensaje = tec.nextLine();
            if (mensaje.equalsIgnoreCase("desconectar")) { // Comando para desconectar.
                break;
            }
            proxyPlayer.empaquetarParametros(nombre, mensaje, EnumMensaje.PLAYER);
            proxyPlayer.enviarDatos();
        } while (true);

        proxyPlayer.cerrarSocket(); // Cierra la conexión del socket al finalizar el chat.
    }

}
