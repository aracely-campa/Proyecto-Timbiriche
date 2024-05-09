package frm;

import domain.game.Player;
import enums.ImagesSourcers;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import mvc.player.PlayerComponent;
import mvc.player.PlayerModel;
import resources.AvatarSelector;

/**
 * Este frame cumple con el princpio de responsabilidad unica Y cumple con el
 * principio de dependencias
 *
 * @author arace
 */
public class FrmPersonalization extends javax.swing.JFrame {

    private PlayerComponent playerComponent;
    private AvatarSelector avatarSelector;

    public FrmPersonalization() {
        initComponents();
        this.playerComponent =new PlayerComponent();
        this.avatarSelector = new AvatarSelector();
        displayCurrentAvatar();
    }


 
private void displayCurrentAvatar() {        
    avatarButton.setIcon(new ImageIcon(avatarSelector.getSelectedAvatarPath()));
}

private void showPreviousAvatar() {
    avatarButton.setIcon(new ImageIcon(avatarSelector.getPreviousAvatarPath()));
}

private void showNextAvatar() {
   avatarButton.setIcon(new ImageIcon(avatarSelector.getNextAvatarPath()));
}



    private boolean validatePlayerName(String namePlayer) {
        if (namePlayer == null || namePlayer.trim().isEmpty()) {
            mostrarMensajeErrorNombre();
            return false;
        }
        return true;
    }

    public void mostrarMensajeErrorNombre() {
        JOptionPane.showMessageDialog(this, "The player name is empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
    }

    public int validarSalidaUsuario() {
        return JOptionPane.showConfirmDialog(this, "You will return to the home screen, are you sure?", "Confirmation", JOptionPane.YES_NO_OPTION);
    }

    public void btnReturn() {
        if (validarSalidaUsuario() == JOptionPane.YES_OPTION) {
            abrirPantallaBienvenida();
            cerrarPantalla();
        }
    }

    public void cerrarPantalla() {
        this.dispose();
    }

    public void abrirPantallaBienvenida() {
        FrmWelcome v = new FrmWelcome();
        v.setVisible(true);
    }

    public void asignarInformacionAUsuario(String namePlayer) {
        String selectedAvatarPath = avatarSelector.getSelectedAvatarPath();
      playerComponent.setPlayerInfo(new Player(namePlayer, 0, 1), selectedAvatarPath);

    }

    public void btnJoin() {

        if (!validatePlayerName(txtNamePlayer.getText().trim())) {
            return;
        }

        asignarInformacionAUsuario(txtNamePlayer.getText().trim());
        abrirPantallaLobbyConDatos(playerComponent);

    }

    public void abrirPantallaLobbyConDatos(PlayerComponent playerComponent) {
        FrmLobby v = new FrmLobby(playerComponent);
        v.setVisible(true);
        cerrarPantalla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNamePlayer = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        rightButton = new javax.swing.JButton();
        leftButton = new javax.swing.JButton();
        avatarButton = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();
        btnJoin = new javax.swing.JButton();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Personalization");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNamePlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamePlayerActionPerformed(evt);
            }
        });
        getContentPane().add(txtNamePlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 170, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lbl/lblPlayerName.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lbl/lblSelectYourPlayer.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 240, 80));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lbl/lblTitle.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, -1, -1));

        rightButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/btnJoin.png"))); // NOI18N
        rightButton.setBorderPainted(false);
        rightButton.setContentAreaFilled(false);
        rightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightButtonActionPerformed(evt);
            }
        });
        getContentPane().add(rightButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 340, -1, -1));

        leftButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/btnlast.png"))); // NOI18N
        leftButton.setContentAreaFilled(false);
        leftButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftButtonActionPerformed(evt);
            }
        });
        getContentPane().add(leftButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, -1, -1));

        avatarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/avatar/avatarBlue.png"))); // NOI18N
        avatarButton.setContentAreaFilled(false);
        avatarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avatarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(avatarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, -1, -1));

        btnReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/btnExit (1).png"))); // NOI18N
        btnReturn.setContentAreaFilled(false);
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });
        getContentPane().add(btnReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, -1, -1));

        btnJoin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/btnStart.png"))); // NOI18N
        btnJoin.setBorderPainted(false);
        btnJoin.setContentAreaFilled(false);
        btnJoin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJoinActionPerformed(evt);
            }
        });
        getContentPane().add(btnJoin, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 480, -1, -1));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/desingFrm/frmPersonalization.png"))); // NOI18N
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 570));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNamePlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamePlayerActionPerformed
        String namePlayer = txtNamePlayer.getText();
        namePlayer = txtNamePlayer.getText();
    }//GEN-LAST:event_txtNamePlayerActionPerformed

    private void avatarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avatarButtonActionPerformed

    }//GEN-LAST:event_avatarButtonActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        btnReturn();
    }//GEN-LAST:event_btnReturnActionPerformed

    private void btnJoinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJoinActionPerformed
        btnJoin();
    }//GEN-LAST:event_btnJoinActionPerformed

    private void rightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightButtonActionPerformed
        showNextAvatar();
    }//GEN-LAST:event_rightButtonActionPerformed

    private void leftButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftButtonActionPerformed
        showPreviousAvatar();
    }//GEN-LAST:event_leftButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton avatarButton;
    private javax.swing.JButton btnJoin;
    private javax.swing.JButton btnReturn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JButton leftButton;
    private javax.swing.JButton rightButton;
    private javax.swing.JTextField txtNamePlayer;
    // End of variables declaration//GEN-END:variables
}
