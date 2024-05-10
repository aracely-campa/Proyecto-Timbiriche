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

/**
 * PlayerView es una clase que extiende JPanel para representar visualmente un
 * jugador en la interfaz de usuario. Muestra la imagen del avatar del jugador y
 * su nombre.
 */
public class PlayerView extends JPanel {

    private Image playerImage;  // Imagen del avatar del jugador.
    private PlayerModel playerModel;  // Modelo que contiene los datos del jugador.

    /**
     * Constructor de PlayerView que inicializa la vista con un modelo de
     * jugador específico. Configura las propiedades iniciales del panel y carga
     * la imagen del avatar del jugador.
     *
     * @param playerModel El modelo del jugador que contiene los datos
     * necesarios para la visualización.
     */
    public PlayerView(PlayerModel playerModel) {
        this.playerModel = playerModel;
        loadBoardImage();
        setPreferredSize(new Dimension(120, 150));  // Dimensiones preferidas del panel.
        setLayout(new FlowLayout());  // Configura el layout del panel.
    }

    /**
     * Carga la imagen del avatar del jugador desde la ruta especificada en el
     * modelo.
     */
    private void loadBoardImage() {
        if (playerModel.getAvatarPath() != null && !playerModel.getAvatarPath().isEmpty()) {
            try {
                playerImage = ImageIO.read(new File(playerModel.getAvatarPath()));
            } catch (IOException ex) {
                ex.printStackTrace();  // Imprime el error si la imagen no se puede cargar.
            }
        }
    }

    /**
     * Actualiza la vista del jugador cargando nuevamente la imagen del avatar y
     * solicitando a Swing que repinte el panel.
     */
    public void refresh() {
        loadBoardImage();
        revalidate();
        repaint();
    }

    /**
     * Sobrescribe el método paintComponent para personalizar la pintura del
     * panel. Dibuja la imagen del avatar y el nombre del jugador en el panel.
     *
     * @param g El objeto Graphics que se utiliza para dibujar en el panel.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        if (playerImage != null) {
            g2d.drawImage(playerImage, playerModel.getCoordenadaX(), playerModel.getCoordenadaY(), playerModel.getAnchoImagenJugador(), playerModel.getLargoImagenJugador(), this);
        }

        if (playerModel.getName() != null) {
            g2d.setColor(Color.BLACK);
            g2d.drawString(playerModel.getName(), playerModel.getCoordenadaNombreX(), playerModel.getCoordenadaNombreY());
        }
    }
}
