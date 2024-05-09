/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.board;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author luis-
 */
public class BoardView extends JPanel {
   
    private BoardModel boardModel;
    private Image boardBackground;
    public BoardView(BoardModel boardModel) {
        this.boardModel = boardModel;
//        setPreferredSize(new Dimension(966, 742));
//        setLayout(new AbsoluteLayout());
            setBackground(Color.red);

    }

    public BoardModel getBoardModel() {
        return boardModel;
    }

    public void setBoardModel(BoardModel boardModel) {
        this.boardModel = boardModel;
    }
    
    public void refresh() {
        revalidate();
        repaint();
    }
    
     public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        try {
            boardBackground = ImageIO.read(new File("src/main/resources/desingFrm/frmBoardGame.png"));
        } catch (IOException ex) {
            Logger.getLogger(BoardView.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (boardBackground != null) {
            g2d.drawImage(boardBackground, boardModel.getCoordenadaX(), boardModel.getCoordenadaY(), boardModel.getAnchoTablero(), boardModel.getLargoTablero(), this);
        }

}
}
