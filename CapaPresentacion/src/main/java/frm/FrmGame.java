package frm;

import domain.game.Player;
import game.GameClass;
import javax.swing.JOptionPane;
import mvc.board.BoardComponent;
import mvc.board.BoardView;
import mvc.player.PlayerComponent;
import mvc.player.PlayerView;

/**
 *
 * @author arace
 */
public class FrmGame extends javax.swing.JFrame {
    // Componente de juego que contiene la lógica del juego y la interacción con el modelo de juego.

    public GameClass gc = new GameClass(new Player("Bv", 1, 2));

    // Componente que gestiona las operaciones relacionadas con los jugadores en la interfaz.
    public PlayerComponent playerComponent;

    /**
     * Constructor de FrmGame que inicializa la ventana con los componentes
     * necesarios.
     *
     * @param playerComponent Componente responsable de la gestión de jugadores.
     */
    public FrmGame(PlayerComponent playerComponent) {
        initComponents();
        this.playerComponent = playerComponent;
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        paintPoolOnGamePanel();
        pintarTablero();
        gc.suscribirTablero();
    }

    /**
     * Método para pintar información del jugador en la interfaz, actualmente
     * vacío y debe ser implementado.
     */
    public void pintarJugadorTest() {

    }

    /**
     * Método para manejar eventos en el tablero de juego. Actualiza el estado
     * visual del tablero mediante el componente de tablero.
     */
    public void eventsOnBoard() {
        BoardComponent boardComponent = BoardComponent.getInstance();
        boardComponent.refresh();
    }

    /**
     * Pinta la vista del jugador en el panel del juego. Añade la vista del
     * jugador al panel jPanel1 y actualiza la interfaz.
     */
    public void paintPoolOnGamePanel() {
        PlayerView playerView = playerComponent.getPlayerView();
        jPanel1.add(playerView, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 180));
        playerComponent.refresh();
    }

    /**
     * Pinta el tablero en la interfaz. Añade la vista del tablero al panel
     * jPanel1 en una posición específica.
     */
    public void pintarTablero() {
        BoardComponent boardComponent = BoardComponent.getInstance();
        BoardView boardView = boardComponent.getBoardView();
        jPanel1.add(boardView, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 725, 725));
    }

    /**
     * Método para manejar el evento de retorno al menú principal. Muestra un
     * diálogo de confirmación y, si se confirma, cierra la ventana actual y
     * abre la pantalla de bienvenida.
     */
    public void btnReturn() {
        int exit = JOptionPane.showConfirmDialog(this, "You will return to the home screen, are you sure?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (exit == JOptionPane.YES_OPTION) {
            FrmWelcome v = new FrmWelcome();
            v.setVisible(true);
            this.dispose();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnReturn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Game");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(1330, 1100));

        btnReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/btnExit (1).png"))); // NOI18N
        btnReturn.setBorderPainted(false);
        btnReturn.setContentAreaFilled(false);
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnReturn)
                .addContainerGap(1061, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(744, Short.MAX_VALUE)
                .addComponent(btnReturn)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1130, 800));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        btnReturn();
    }//GEN-LAST:event_btnReturnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReturn;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
