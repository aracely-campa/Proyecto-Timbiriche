
package domainClasses;

import domain.game.Player;

/**
 * Se implementa el patrón Singleton para mantener una única instancia de la clase
 * La clase DomainPlayer actúa como una fachada o interfaz hacia la clase Player,
 * facilitando la manipulación y gestión de un objeto Player. Implementa el patrón Singleton
 * para asegurar una única instancia de esta clase dentro de la aplicación.
 */
public class DomainPlayer {

    // Instancia única de DomainPlayer para implementar el patrón Singleton.
    private static DomainPlayer domainPlayer;

    // Instancia pública de Player. Usualmente, sería mejor mantener esto privado para encapsular completamente.
    public Player player;

    /**
     * Constructor privado para el patrón Singleton.
     * Inicializa la instancia de Player asegurando que sea única.
     */
    public DomainPlayer() {
        this.player = Player.getInstance();
    }


    /**
     * Método estático para obtener la instancia única de DomainPlayer.
     * Si no existe, crea una nueva instancia.
     * 
     * @return la única instancia de DomainPlayer.
     */
    public static DomainPlayer getInstance() {
        if (domainPlayer == null) {
            domainPlayer = new DomainPlayer();
        }
        return domainPlayer;
    }
}
