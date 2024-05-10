/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.game;

/**
 *
 * @author luis-
 */
/**
 * GameView actúa como la vista en el patrón MVC para el juego, encargada de
 * presentar la representación visual del estado del juego almacenado en
 * GameModel.
 */
public class GameView {

    private GameModel gameModel; // Referencia al modelo del juego que contiene los datos y estado del juego.

    /**
     * Constructor de GameView que inicializa la vista con un modelo de juego
     * específico.
     *
     * @param gameModel El modelo del juego que esta vista debe representar.
     */
    public GameView(GameModel gameModel) {
        this.gameModel = gameModel;
    }

    /**
     * Método para cargar y preparar los recursos gráficos necesarios para el
     * juego. Esto podría incluir cargar imágenes, preparar interfaces de
     * usuario, entre otros preparativos visuales.
     */
    private void loadGame() {
        // Implementación de la carga de componentes visuales o configuración inicial de la vista.
    }

    /**
     * Obtiene el modelo del juego asociado con esta vista.
     *
     * @return El modelo del juego actual.
     */
    public GameModel getGameModel() {
        return gameModel;
    }

    /**
     * Establece o actualiza el modelo del juego asociado con esta vista.
     *
     * @param gameModel El nuevo modelo del juego.
     */
    public void setGameModel(GameModel gameModel) {
        this.gameModel = gameModel;
    }
}
