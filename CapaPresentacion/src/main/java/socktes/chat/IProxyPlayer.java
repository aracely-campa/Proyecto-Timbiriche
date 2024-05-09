package socktes.chat;

/**
 *
 * @author arace
 */
public interface IProxyPlayer {

    public void empaquetarParametros(String nombre, String mensaje, EnumMensaje tipo);

    public void iniciarSocket();

    public void cerrarSocket();

    public void recibirDatos();

    public void enviarDatos();

    public void desempaquetarDatos();

    public void iniciarHilo();
}
