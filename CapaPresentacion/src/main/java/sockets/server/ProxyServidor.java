
package sockets.server;

/**
 *
 * @author arace
 */
public class ProxyServidor implements IProxyServidor{
    private ConexionServidor conexionServidor = new ConexionServidor();
    
    @Override
    public void empaquetarParametros(String nombre, String mensaje, String ip) {
        conexionServidor.empaquetarParametros(nombre, mensaje, ip);
    }

    @Override
    public void iniciarSocket() {
        conexionServidor.iniciarSocket();
    }

    @Override
    public void cerrarSocket() {
        conexionServidor.cerrarSocket();
    }

    @Override
    public void recibirDatos() {
        conexionServidor.cerrarSocket();
    }
    
    @Override
    public void enviarDatos() {
        conexionServidor.enviarDatos();
    }
    @Override
    public void desempaquetarDatos() {
    conexionServidor.desempaquetarDatos();
    }

    @Override
    public void iniciarHilo() {
        conexionServidor.iniciarHilo();
    }

   
}
