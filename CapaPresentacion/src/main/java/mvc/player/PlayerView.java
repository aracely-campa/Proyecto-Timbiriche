/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.player;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author luis-
 */
public class PlayerView {
    
    private PlayerController playerController;
    private Image poolImage;
    private PlayerModel playerModel;

    public PlayerView(PlayerModel playerModel) {
        this.playerModel = playerModel;

        loadPlayerImage();
    }

    private void loadPlayerImage() {
        try {
            if (playerModel.getAvatarPath() != null && new File(playerModel.getAvatarPath()).exists()) {
                poolImage = ImageIO.read(new File(playerModel.getAvatarPath()));
            } else {
                System.err.println("Error: Avatar image file not found or path is null.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading avatar image: " + e.getMessage());
        }
    }

    public void updateAvatar(String newAvatarPath) {
        playerModel.setAvatarPath(playerModel.getPlayer(), newAvatarPath);
        loadPlayerImage();
    }

    public Image getPoolImage() {
        return poolImage;
    }

    public void setPoolImage(Image poolImage) {
        this.poolImage = poolImage;
    }
}
