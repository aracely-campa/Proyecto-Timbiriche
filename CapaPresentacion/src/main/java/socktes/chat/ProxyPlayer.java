package socktes.chat;

/**
 *
 * @author arace
 */
public class ProxyPlayer implements IProxyPlayer {

    private ConexionPlayer conexionPlayer = new ConexionPlayer(); // Manejador de la conexión del jugador.

    /**
     * Empaqueta los parámetros necesarios para crear un paquete de datos que será enviado a través de la red.
     *
     * @param nombre El nombre del jugador o remitente del mensaje.
     * @param mensaje El contenido del mensaje a enviar.
     * @param tipo El tipo de mensaje, definido por la enumeración EnumMensaje.
     */
    @Override
    public void empaquetarParametros(String nombre, String mensaje, EnumMensaje tipo) {
        conexionPlayer.empaquetarParametros(nombre, mensaje, tipo);
    }

    /**
     * Inicia la conexión de socket para permitir la comunicación de red.
     */
    @Override
    public void iniciarSocket() {
        conexionPlayer.iniciarSocket();
    }

    /**
     * Cierra el socket de la conexión, finalizando la comunicación de red.
     */
    @Override
    public void cerrarSocket() {
        conexionPlayer.cerrarSocket();
    }

    /**
     * Recibe datos de la red, escuchando continuamente los mensajes entrantes.
     */
    @Override
    public void recibirDatos() {
        conexionPlayer.recibirDatos();
    }

    /**
     * Envía el paquete de datos creado por empaquetarParametros a través de la red.
     */
    @Override
    public void enviarDatos() {
        conexionPlayer.enviarDatos();
    }

    /**
     * Desempaqueta los datos recibidos de la red, extrayendo información como el remitente, el mensaje y otros detalles.
     */
    @Override
    public void desempaquetarDatos() {
        conexionPlayer.desempaquetarDatos();
    }

    /**
     * Inicia un hilo separado para manejar las operaciones de red de forma asíncrona, evitando bloquear la interfaz de usuario.
     */
    @Override
    public void iniciarHilo() {
        conexionPlayer.iniciarHilo();
    }
}