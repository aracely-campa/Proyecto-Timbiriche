
package exceptions;

/**
 *
 * @author arace
 */
public class PlayerException extends Exception {

    public PlayerException() {
    }

    public PlayerException(String msg) {
        super(msg);
    }

    public PlayerException(String message, Throwable cause) {
        super(message, cause);
    }
}
