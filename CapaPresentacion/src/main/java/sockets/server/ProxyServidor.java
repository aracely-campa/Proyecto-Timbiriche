package sockets.server;

/**
 * ProxyServidor actúa como un intermediario entre el cliente y una instancia de
 * ConexionServidor. Delega todas las operaciones relacionadas con la gestión de
 * la conexión del servidor a una instancia específica.
 */
public class ProxyServidor implements IProxyServidor {

    private ConexionServidor conexionServidor = new ConexionServidor(); // La instancia de ConexionServidor que maneja la conexión real.

    /**
     * Empaqueta los parámetros necesarios para enviar un mensaje.
     *
     * @param nombre El nombre del remitente.
     * @param mensaje El mensaje a enviar.
     * @param ip La dirección IP del remitente.
     */
    @Override
    public void empaquetarParametros(String nombre, String mensaje, String ip) {
        conexionServidor.empaquetarParametros(nombre, mensaje, ip);
    }

    /**
     * Inicia el socket para la conexión con el servidor.
     */
    @Override
    public void iniciarSocket() {
        conexionServidor.iniciarSocket();
    }

    /**
     * Cierra el socket de la conexión con el servidor.
     */
    @Override
    public void cerrarSocket() {
        conexionServidor.cerrarSocket();
    }

    /**
     * Recibe datos desde el servidor.
     */
    @Override
    public void recibirDatos() {
        conexionServidor.recibirDatos();
    }

    /**
     * Envía datos al servidor.
     */
    @Override
    public void enviarDatos() {
        conexionServidor.enviarDatos();
    }

    /**
     * Desempaqueta los datos recibidos desde el servidor.
     */
    @Override
    public void desempaquetarDatos() {
        conexionServidor.desempaquetarDatos();
    }

    /**
     * Inicia un hilo para manejar las operaciones de red de forma asíncrona.
     */
    @Override
    public void iniciarHilo() {
        conexionServidor.iniciarHilo();
    }
}
