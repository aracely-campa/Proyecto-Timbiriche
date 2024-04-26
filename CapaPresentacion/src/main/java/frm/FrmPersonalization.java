package frm;

import enums.ImagesSourcers;
import factory.MVCFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import mvc.player.PlayerComponent;
import mvc.player.PlayerModel;

/**
 *
 * @author arace
 */
public class FrmPersonalization extends javax.swing.JFrame {

    private PlayerModel playerModel;
    private String selectedAvatarPath;

    public FrmPersonalization(PlayerModel playerModel) {
        initComponents();
        this.playerModel = playerModel;
        displayCurrentAvatar();
    }

    private void displayCurrentAvatar() {
     

        String[] avatarPaths = ImagesSourcers.getAvatarImages();
        if (avatarPaths != null && avatarPaths.length > 0) {
            int index = playerModel.getAvatarPath() != null ? getSelectedAvatarIndex(new String[]{playerModel.getAvatarPath()}) : 0;
            ImageIcon icon = new ImageIcon(avatarPaths[index]);
            avatarButton.setIcon(icon);
            selectedAvatarPath = avatarPaths[index];
        } else {
            System.err.println("Error: avatarPaths is null or empty");
        }
    }

    private void showPreviousAvatar() {
        String[] avatarPaths = ImagesSourcers.getAvatarImages();
        if (avatarPaths != null && avatarPaths.length > 0) {
            int currentIndex = getSelectedAvatarIndex(avatarPaths);
            currentIndex--;
            if (currentIndex < 0) {
                currentIndex = avatarPaths.length - 1;
            }
            selectedAvatarPath = avatarPaths[currentIndex];
            ImageIcon icon = new ImageIcon(selectedAvatarPath);
            avatarButton.setIcon(icon);
        } else {
            System.err.println("Error: avatarPaths is null or empty");
        }
    }

    private void showNextAvatar() {
        String[] avatarPaths = ImagesSourcers.getAvatarImages();
        if (avatarPaths != null && avatarPaths.length > 0) {
            int currentIndex = getSelectedAvatarIndex(avatarPaths);
            currentIndex++;
            if (currentIndex >= avatarPaths.length) {
                currentIndex = 0;
            }
            selectedAvatarPath = avatarPaths[currentIndex];
            ImageIcon icon = new ImageIcon(selectedAvatarPath);
            avatarButton.setIcon(icon);
        } else {
            System.err.println("Error: avatarPaths is null or empty");
        }
    }

    private int getSelectedAvatarIndex(String[] avatarPaths) {
        for (int i = 0; i < avatarPaths.length; i++) {
            if (avatarPaths[0].equals(selectedAvatarPath)) {
                return i;
            }else{
                if (avatarPaths[i].equals(selectedAvatarPath)) {
                return i;
            }
        }
      
    }
          return -1;
    }

    public void btnReturn() {
        int exit = JOptionPane.showConfirmDialog(this, "You will return to the home screen, are you sure?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (exit == JOptionPane.YES_OPTION) {
            FrmWelcome v = new FrmWelcome();
            v.setVisible(true);
            this.dispose();
        }

    }

    public void btnJoin() {
        String namePlayer = txtNamePlayer.getText();
        if (namePlayer == null || namePlayer.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "The text field is empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        PlayerComponent.getInstance().updatePlayerInfo(namePlayer, selectedAvatarPath);
         ImageIcon icon = new ImageIcon(selectedAvatarPath);
        FrmLobby v = new FrmLobby(PlayerComponent.getInstance().getPlayerModel(), namePlayer, selectedAvatarPath, icon);
        v.setVisible(true);
        this.dispose();
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
