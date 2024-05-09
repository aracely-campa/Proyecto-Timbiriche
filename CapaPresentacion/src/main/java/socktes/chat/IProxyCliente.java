package socktes.chat;

/**
 *
 * @author arace
 */
public interface IProxyCliente {

    public void empaquetarParametros(String nombre, String mensaje, Mensaje tipo);

    public void iniciarSocket();

    public void cerrarSocket();

    public void recibirDatos();

    public void enviarDatos();

    public void desempaquetarDatos();

    public void iniciarHilo();
}
