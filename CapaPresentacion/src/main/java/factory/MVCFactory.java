
package factory;

import mvc.board.BoardComponent;
import mvc.game.GameComponent;
import mvc.player.PlayerComponent;

/**
 * La clase MVCFactory es una implementación del patrón de diseño Factory y Singleton.
 * Está diseñada para crear y proporcionar instancias de diferentes componentes en una aplicación MVC,
 * asegurando que solo exista una instancia de cada componente según sea necesario.
 */
public class MVCFactory {
    
    // Variable estática que almacena la única instancia de MVCFactory.
    private static MVCFactory mvcfactory;
    
    // Constructor privado para prevenir la instanciación directa y asegurar el patrón Singleton.
    private MVCFactory() {}
    
    /**
     * Crea y retorna una nueva instancia de GameComponent.
     * Este método siempre crea una nueva instancia, considerar si esto es deseado o si se debería implementar algún tipo de caché o instancia única.
     * 
     * @return una nueva instancia de GameComponent.
     */
    public static GameComponent instanceGameComponent() {
        return new GameComponent();
    }
    
    /**
     * Retorna una instancia de BoardComponent utilizando un enfoque Singleton.
     * Este método garantiza que siempre se devuelva la misma instancia de BoardComponent, siguiendo el patrón Singleton.
     * 
     * @return la única instancia de BoardComponent.
     */
    public static BoardComponent instanceBoardComponent() {
        return BoardComponent.getInstance();
    }
    
    /**
     * Proporciona acceso a la única instancia de MVCFactory.
     * Si la instancia no existe, se crea una nueva. Este método está sincronizado para evitar problemas
     * en entornos multihilo.
     * 
     * @return la única instancia de MVCFactory.
     */
    public static synchronized MVCFactory getInstance() {
        if (mvcfactory == null) {
            mvcfactory = new MVCFactory();
        }
        return mvcfactory;
    }
}
