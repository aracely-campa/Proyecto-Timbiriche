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
        try {
            playerImage = ImageIO.read(new File("src/main/resources/avatar/avatarBlue.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void refresh() {
        revalidate();
        repaint();
    }

       @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Dibuja la imagen en el JPanel
        g2d.drawImage(playerImage, 0, 0, 120, 130, this);
    }

}
