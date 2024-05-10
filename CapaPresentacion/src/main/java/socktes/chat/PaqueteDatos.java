package socktes.chat;

import java.io.Serializable;

/**
 *
 * @author arace
 */
public class PaqueteDatos implements Serializable {

    private String nombre;  // Nombre del remitente del mensaje.
    private String ip;      // Dirección IP del remitente.
    private String mensaje; // Contenido del mensaje enviado.
    private Enum para;      // Destinatario del mensaje, utilizado para dirigir el paquete correctamente.

    /**
     * Constructor para crear un paquete de datos con información básica.
     *
     * @param nombre Nombre del remitente.
     * @param mensaje Mensaje enviado.
     * @param ip Dirección IP del remitente.
     */
    public PaqueteDatos(String nombre, String mensaje, String ip) {
        this.nombre = nombre;
        this.ip = ip;
        this.mensaje = mensaje;
    }

    /**
     * Constructor para crear un paquete de datos con información de destinatario.
     *
     * @param nombre Nombre del remitente.
     * @param mensaje Mensaje enviado.
     * @param ip Dirección IP del remitente.
     * @param para Destinatario del mensaje (Enum que define el destinatario).
     */
    public PaqueteDatos(String nombre, String mensaje, String ip, Enum para) {
        this.nombre = nombre;
        this.ip = ip;
        this.mensaje = mensaje;
        this.para = para;
    }

    /**
     * Constructor utilizado principalmente para señales o comandos específicos sin datos adicionales.
     *
     * @param para Destinatario o tipo de mensaje (Enum que define el tipo o destino del paquete).
     */
    public PaqueteDatos(Enum para) {
        this.para = para;
    }

    // Getters y setters para acceder y modificar los atributos de la instancia.

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Enum getPara() {
        return para;
    }

    public void setPara(Enum para) {
        this.para = para;
    }
}