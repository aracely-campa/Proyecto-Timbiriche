package socktes.chat;

/**
 *
 * @author arace
 */
public class ProxyCliente implements IProxyCliente {

    private ConexionCliente conexionCliente = new ConexionCliente();

    @Override
    public void empaquetarParametros(String nombre, String mensaje, Mensaje tipo) {
        conexionCliente.empaquetarParametros(nombre, mensaje, tipo);
    }

    @Override
    public void iniciarSocket() {
        conexionCliente.iniciarSocket();
    }

    @Override
    public void cerrarSocket() {
        conexionCliente.cerrarSocket();
    }

    @Override
    public void recibirDatos() {
        conexionCliente.recibirDatos();
    }

    @Override
    public void enviarDatos() {
        conexionCliente.enviarDatos();
    }

    @Override
    public void desempaquetarDatos() {
        conexionCliente.desempaquetarDatos();
    }

    @Override
    public void iniciarHilo() {
        conexionCliente.iniciarHilo();
    }

}
