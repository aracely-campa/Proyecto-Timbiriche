package frm;

import factory.MVCFactory;
import javax.swing.JOptionPane;
import mvc.game.GameComponent;
import mvc.player.PlayerComponent;

/**
 *
 * @author arace
 */
public class FrmCreateGame extends javax.swing.JFrame {

    private final GameComponent gameComponent;
    private PlayerComponent playerComponent;

    /**
     * Constructor de FrmCreateGame. Inicializa los componentes de la ventana y
     * establece las dependencias necesarias.
     *
     * @param gameComponent El componente de juego utilizado para gestionar la
     * lógica y el estado del juego.
     */
    public FrmCreateGame(GameComponent gameComponent) {
        initComponents();
        this.playerComponent = new PlayerComponent();
        this.gameComponent = gameComponent;
    }

    /**
     * Crea un juego utilizando los parámetros especificados por la interfaz de
     * usuario. Captura y maneja excepciones relacionadas con la creación del
     * juego.
     */
    public void createGame() {
        try {
            this.gameComponent.getGameModel().setTamanoDePartida(getPlayerGameSize());
            this.gameComponent.getGameModel().createGame();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /**
     * Obtiene el tamaño del juego basado en la selección del usuario en la
     * interfaz gráfica.
     *
     * @return el número de jugadores seleccionados.
     */
    public int getPlayerGameSize() {
        if (btnTwoPlayers.isSelected()) {
            return 2;
        } else if (btnThreePlayers.isSelected()) {
            return 3;
        } else {
            return 4;
        }
    }

    /**
     * Muestra la ventana de personalización y cierra la ventana actual.
     */
    private void showPersonalizationFrm() {
        FrmPersonalization v = new FrmPersonalization();
        v.setVisible(true);
        dispose();
    }

    /**
     * Confirma con el usuario antes de cerrar la ventana actual y retornar a la
     * pantalla principal.
     *
     * @return el resultado de la confirmación del usuario.
     */
    public int validarSalidaUsuario() {
        return JOptionPane.showConfirmDialog(this, "You will return to the home screen, are you sure?", "Confirmation", JOptionPane.YES_NO_OPTION);
    }

    /**
     * Maneja el evento de retorno a la pantalla de bienvenida. Si el usuario
     * confirma, cierra la ventana actual y abre la pantalla de bienvenida.
     */
    public void btnReturn() {
        if (validarSalidaUsuario() == JOptionPane.YES_OPTION) {
            abrirPantallaBienvenida();
            cerrarPantalla();
        }
    }

    /**
     * Cierra la ventana actual.
     */
    public void cerrarPantalla() {
        this.dispose();
    }

    /**
     * Abre la ventana de bienvenida.
     */
    public void abrirPantallaBienvenida() {
        FrmWelcome v = new FrmWelcome();
        v.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTwoPlayers = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();
        btnThreePlayers = new javax.swing.JButton();
        btnFourPlayers = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CreateGame");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTwoPlayers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/btntwoplayers.png"))); // NOI18N
        btnTwoPlayers.setToolTipText("");
        btnTwoPlayers.setContentAreaFilled(false);
        btnTwoPlayers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTwoPlayersActionPerformed(evt);
            }
        });
        getContentPane().add(btnTwoPlayers, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, -1, -1));

        btnReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/btnExit (1).png"))); // NOI18N
        btnReturn.setContentAreaFilled(false);
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });
        getContentPane().add(btnReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 490, -1, -1));

        btnThreePlayers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/btnthreeplayers.png"))); // NOI18N
        btnThreePlayers.setContentAreaFilled(false);
        btnThreePlayers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThreePlayersActionPerformed(evt);
            }
        });
        getContentPane().add(btnThreePlayers, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, -1, -1));

        btnFourPlayers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/btnfourplayers.png"))); // NOI18N
        btnFourPlayers.setContentAreaFilled(false);
        btnFourPlayers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFourPlayersActionPerformed(evt);
            }
        });
        getContentPane().add(btnFourPlayers, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 190, 180, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lbl/lblcreategame.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/desingFrm/frmCreateGame.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 580));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTwoPlayersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTwoPlayersActionPerformed
        showPersonalizationFrm();
    }//GEN-LAST:event_btnTwoPlayersActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        btnReturn();
    }//GEN-LAST:event_btnReturnActionPerformed

    private void btnThreePlayersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThreePlayersActionPerformed
        showPersonalizationFrm();
    }//GEN-LAST:event_btnThreePlayersActionPerformed

    private void btnFourPlayersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFourPlayersActionPerformed
        showPersonalizationFrm();
    }//GEN-LAST:event_btnFourPlayersActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFourPlayers;
    private javax.swing.JButton btnReturn;
    private javax.swing.JButton btnThreePlayers;
    private javax.swing.JButton btnTwoPlayers;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
