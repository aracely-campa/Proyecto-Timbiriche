/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.board;

import domain.graph.Node;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author luis-
 */
public class BoardView extends JPanel {
   
    private BoardModel boardModel;
    private Image boardBackground;
    private List <Node> nodeList;
    public BoardView(BoardModel boardModel) {
        this.boardModel = boardModel;
        boardModel.getDomainBoard().createSmallBoard();
        nodeList=boardModel.getDomainBoard().getNodeList();
//        setPreferredSize(new Dimension(966, 742));
//        setLayout(new AbsoluteLayout());
            setBackground(Color.white);

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
        paintBoard(g);
    }

    private void paintBoard(Graphics g) {

        g.setColor(Color.BLUE);
        g.fillRect(boardModel.originX + boardModel.circleSize / 2, boardModel.originY + boardModel.circleSize / 2, boardModel.circleSize + boardModel.cellSize - boardModel.circleSize, boardModel.circleSize + boardModel.cellSize - boardModel.circleSize);
        for (int i = 0; i <= boardModel.columns; i++) {
            for (int j = 0; j <= boardModel.rows; j++) {

                g.setColor(Color.BLACK);

                if (i != boardModel.rows) {
                    g.drawLine(boardModel.originX + boardModel.cellSize * i + boardModel.circleSize, boardModel.originY + boardModel.cellSize * j + boardModel.circleSize / 2, boardModel.originX + boardModel.cellSize * (i + 1) + boardModel.circleSize, boardModel.originY + boardModel.cellSize * j + boardModel.circleSize / 2);
                }

                g.setColor(Color.BLACK);

                if (j != boardModel.columns) {
                    g.drawLine(boardModel.originX + boardModel.cellSize * i + boardModel.circleSize / 2, boardModel.originY + boardModel.cellSize * j + 2 * boardModel.circleSize / 2, boardModel.originX + boardModel.cellSize * i + boardModel.circleSize / 2, boardModel.originY + boardModel.cellSize * (j + 1) + boardModel.circleSize / 2);
                }

                g.setColor(Color.BLACK);

                g.drawOval(boardModel.originX + boardModel.cellSize * i, boardModel.originY + boardModel.cellSize * j, boardModel.circleSize, boardModel.circleSize);

                g.setColor(Color.RED);

                g.fillOval(boardModel.originX + boardModel.smollCircleSize / 2 + boardModel.cellSize * i, boardModel.originY + boardModel.smollCircleSize / 2 + boardModel.cellSize * j, boardModel.circleSize - boardModel.smollCircleSize, boardModel.circleSize - boardModel.smollCircleSize);
            }
        }
    }

}
