
package sockets.server;

/**
 *
 * @author arace
 */
public interface IProxyServidor {

    public void empaquetarParametros(String nombre, String mensaje, String ip);

    public void iniciarSocket();

    public void cerrarSocket();

    public void recibirDatos();

    public void enviarDatos();

    public void desempaquetarDatos();
    
    public void iniciarHilo();
}
