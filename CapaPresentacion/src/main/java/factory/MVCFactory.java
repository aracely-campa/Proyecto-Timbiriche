/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;

import mvc.board.BoardComponent;
import mvc.game.GameComponent;
import mvc.player.PlayerComponent;

/**
 *
 * @author luis-
 */
public class MVCFactory {
      
    private static MVCFactory mvcfactory;
    
     public static GameComponent instanceGameComponent(){
         return new GameComponent();
     }
     

     public static BoardComponent instanceBoardComponent(){
         return BoardComponent.getInstance();
     }
     
     public static MVCFactory getInstance(){
        if(mvcfactory == null){
            mvcfactory = new MVCFactory();
        }
        return mvcfactory;
    }
    
}
