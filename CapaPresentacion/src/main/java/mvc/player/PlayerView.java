package mvc.player;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PlayerView extends JPanel {

    private Image playerImage;
    private PlayerModel playerModel;

    public PlayerView(PlayerModel playerModel) {
        this.playerModel = playerModel;
        loadBoardImage();
        setPreferredSize(new Dimension(120, 130));
        setLayout(new FlowLayout());
    }

    private void loadBoardImage() {
        if (playerModel.getAvatarPath() != null && !playerModel.getAvatarPath().isEmpty()) {
            try {
                playerImage = ImageIO.read(new File(playerModel.getAvatarPath()));
            } catch (IOException ex) {
                ex.printStackTrace();
                // Handle error, perhaps set a default image
            }
        }
    }

    public void refresh() {
        loadBoardImage(); // Reload image from the updated avatar path
        revalidate();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        if (playerImage != null) {
            g2d.drawImage(playerImage, 0, 0, 120, 130, this);
        }
    }
}
