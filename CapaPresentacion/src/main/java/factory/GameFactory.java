/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;

import frm.FrmCreateGame;
import mvc.game.GameModel;

/**
 *
 * @author luis-
 */
public class GameFactory {
    
     public static FrmCreateGame createFrmCreateGame(GameModel gameModel) {
        return new FrmCreateGame(gameModel);
    }
     
     
    
}
