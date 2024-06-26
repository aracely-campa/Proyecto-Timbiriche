package frm;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import mvc.player.PlayerComponent;

/**
 * Cumple de con el princpio de responsabilidad unica y el de dependencias ya
 * que maneja la interfaz grafica y la navegacion entre las pantallas, y el de
 * dependencias por que recibe parametros del player model
 *
 * @author arace
 */
public class FrmLobby extends javax.swing.JFrame {

    public PlayerComponent playerComponent;
    private final String avatarPath;
    private final String namePlayer;

    
    /**
     * Constructor para FrmLobby que inicializa la ventana con la información del jugador proporcionada.
     *
     * @param playerComponent Componente que contiene la información del modelo de jugador.
     */
    public FrmLobby(PlayerComponent playerComponent) {
        this.playerComponent = playerComponent;
        this.avatarPath = playerComponent.getPlayerModel().getAvatarPath();
        this.namePlayer = playerComponent.getPlayerModel().getName();

        initComponents();
        lblNamePlayer.setText(namePlayer);
        lblAvatar.setIcon(new ImageIcon(avatarPath));

        setVisible(true);

        // Mensaje de depuración para verificar la ruta del avatar recibida
        System.out.println("Avatar path received in FrmLobby: " + avatarPath);
    }

    /**
     * Muestra un diálogo de confirmación y retorna a la pantalla de bienvenida si el usuario confirma.
     */
    private void showWelcomeFrm() {
        int exit = JOptionPane.showConfirmDialog(this, "You will return to the home screen, are you sure?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (exit == JOptionPane.YES_OPTION) {
            FrmWelcome v = new FrmWelcome();
            v.setVisible(true);
            this.dispose();
        }
    }

    /**
     * Navega hacia la ventana del juego principal, pasando el componente del jugador.
     */
    private void showLobbyFrm() {
        FrmGame v = new FrmGame(playerComponent);
        v.setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        btnStartGame = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();
        lblAvatar = new javax.swing.JLabel();
        lblNamePlayer = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lobby");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lbl/lblLobby.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, -1, -1));

        btnStartGame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/btnStart.png"))); // NOI18N
        btnStartGame.setContentAreaFilled(false);
        btnStartGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartGameActionPerformed(evt);
            }
        });
        getContentPane().add(btnStartGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 420, 180, 110));

        btnReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/btnExit (1).png"))); // NOI18N
        btnReturn.setContentAreaFilled(false);
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });
        getContentPane().add(btnReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, -1, -1));
        getContentPane().add(lblAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 210, 290));

        lblNamePlayer.setFont(new java.awt.Font("Yu Gothic Light", 0, 36)); // NOI18N
        lblNamePlayer.setForeground(new java.awt.Color(255, 255, 255));
        lblNamePlayer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lbl/lblGetPlayerName.png"))); // NOI18N
        getContentPane().add(lblNamePlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 370, 90));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/desingFrm/lobbyT.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 580));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        showWelcomeFrm();

    }//GEN-LAST:event_btnReturnActionPerformed

    private void btnStartGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartGameActionPerformed
        showLobbyFrm();
    }//GEN-LAST:event_btnStartGameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReturn;
    private javax.swing.JButton btnStartGame;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblAvatar;
    private javax.swing.JLabel lblNamePlayer;
    // End of variables declaration//GEN-END:variables

}
