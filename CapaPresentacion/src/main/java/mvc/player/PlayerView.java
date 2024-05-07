package mvc.player;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PlayerView extends JPanel {

    private Image poolImage;
    private PlayerModel playerModel;

    public PlayerView(PlayerModel playerModel) {
        this.playerModel = playerModel;
        
        this.playerModel.setAvatarPath("src/main/resources/avatar/avatarYellow.png");
        setBackground(Color.blue);
        setPreferredSize(new Dimension(1010, 110)); // Asegúrate de que esta dimensión es adecuada
        loadPlayerImage();
        setVisible(true);  // Asegura que el panel es visible
    }

private void loadPlayerImage() {
    System.out.println("Attempting to load image with path: " + playerModel.getAvatarPath());  // Depuración
    try {
        String avatarPath = playerModel.getAvatarPath();
        if (avatarPath != null) {
            File imageFile = new File(avatarPath);
            if (imageFile.exists()) {
                poolImage = ImageIO.read(imageFile);
            } else {
                System.err.println("Error: Avatar image file not found at " + avatarPath);
            }
        } else {
            System.err.println("Error: Avatar path is null.");
        }
        revalidate();
        repaint();
        this.setBackground(Color.RED); // Establece el color de fondo a rojo para pruebas

    } catch (IOException e) {
        e.printStackTrace();
        System.err.println("Error loading avatar image: " + e.getMessage());
    }
}



     public void refresh() {
 
            repaint();
        
    }
    

@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (poolImage != null) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.drawImage(poolImage, 0, 0, 100, 100, this);
        g2d.dispose();
        
        System.out.println("Image load status: " + (poolImage != null ? "Success" : "Failed"));

    }
    
    System.out.println("Image load status: " + (poolImage != null ? "Success" : "Failed"));

}

}
