/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;

import frm.FrmLobby;
import frm.FrmPersonalization;
import mvc.player.PlayerModel;

/**
 *
 * @author luis-
 */
public class PlayerFactory {
    
    public static FrmPersonalization frmPersonalization(PlayerModel playerModel) {
        return new FrmPersonalization(playerModel);
    }
    
    public static FrmLobby frmLobby(PlayerModel playerModel){
        return new FrmLobby(playerModel);
    }
    
}
