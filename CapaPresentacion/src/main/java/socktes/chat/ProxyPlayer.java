package socktes.chat;

/**
 *
 * @author arace
 */
public class ProxyPlayer implements IProxyPlayer {

    private ConexionPlayer conexionPlayer = new ConexionPlayer();

    @Override
    public void empaquetarParametros(String nombre, String mensaje, EnumMensaje tipo) {
        conexionPlayer.empaquetarParametros(nombre, mensaje, tipo);
    }

    @Override
    public void iniciarSocket() {
        conexionPlayer.iniciarSocket();
    }

    @Override
    public void cerrarSocket() {
        conexionPlayer.cerrarSocket();
    }

    @Override
    public void recibirDatos() {
        conexionPlayer.recibirDatos();
    }

    @Override
    public void enviarDatos() {
        conexionPlayer.enviarDatos();
    }

    @Override
    public void desempaquetarDatos() {
        conexionPlayer.desempaquetarDatos();
    }

    @Override
    public void iniciarHilo() {
        conexionPlayer.iniciarHilo();
    }

}
