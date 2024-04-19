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

    Image poolImage;
    PlayerModel playerModel;

    public PlayerView(PlayerModel playerModel) {
        this.playerModel = playerModel;
        loadPlayerImage();
    }

    private void loadPlayerImage() {
        try {
            poolImage = ImageIO.read(new File(playerModel.getAvatarPath()));

        } catch (IOException e) {
            e.printStackTrace(); // Manejar la excepción de manera adecuada         

        }
    }
}
