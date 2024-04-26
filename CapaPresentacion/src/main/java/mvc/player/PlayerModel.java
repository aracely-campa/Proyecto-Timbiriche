/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.player;

import domain.game.Player;
import enums.ImagesSourcers;

/**
 *
 * @author luis-
 */
public class PlayerModel {

    private Player player;
    private String avatarPath;
    
    private String name;

    public int turn;

    public PlayerModel() {
        this.player = new Player();
    }

    public PlayerModel(Player player, String avatarPath, String name, int turn) {
        this.player = player;
        this.avatarPath = avatarPath;
        this.name = name;
        this.turn = turn;
    }

    public PlayerModel(Player player, String avatarSelected) {
        this.player = player;
        this.name = avatarSelected;
        this.avatarPath = getAvatarImage(this.name);

    }

    public static String getAvatarImage(String name) {
        return switch (name) {
            case "Among_us_Blue" ->
                ImagesSourcers.getAvatarBlue();
            case "Among_us_Red" ->
                ImagesSourcers.getAvatarRed();
            case "Among_us_Green" ->
                ImagesSourcers.getAvatarGreen();
            case "Among_us_Yellow" ->
                ImagesSourcers.getAvatarYellow();
            default ->
                null;
        };
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setAvatarPath(Player player, String avatarPath) {
        this.avatarPath = avatarPath;
        this.player = player;
        
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PlayerModel{" + "player=" + player + ", avatarPath=" + avatarPath + ", name=" + name + ", turn=" + turn + '}';
    }

}
