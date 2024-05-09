/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import events.BoardEvents;
import events.NodeEvents;
import events.PlayerEvents;

/**
 *
 * @author arace
 */
public interface MatchObserver {
    void eventOnNodeUpdate(NodeEvents evt);
    void eventOnBoardUpdate(BoardEvents evt);
    void eventOnPlayerUpdate(PlayerEvents evt);
//    void eventOnPlayerClickedTile(PlayerEvents evt, TileComponent tile);
}
