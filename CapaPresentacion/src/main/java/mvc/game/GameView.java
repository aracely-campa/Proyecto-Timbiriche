/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.game;

/**
 *
 * @author luis-
 */
public class GameView {
    
    private GameModel gameModel;

    public GameView(GameModel gameModel) {
        this.gameModel = gameModel;
    }
    
    private void loadGame(){
        
    }

    public GameModel getGameModel() {
        return gameModel;
    }

    public void setGameModel(GameModel gameModel) {
        this.gameModel = gameModel;
    }
    
    
    
}
