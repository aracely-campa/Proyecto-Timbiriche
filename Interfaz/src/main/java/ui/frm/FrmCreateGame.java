/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui.frm;

import javax.swing.JFrame;

/**
 *
 * @author arace
 */
public class FrmCreateGame extends javax.swing.JFrame {

    /**
     * Creates new form FrmCreateGame
     */
    public FrmCreateGame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnReturn = new javax.swing.JButton();
        btnTwoPlayers = new javax.swing.JButton();
        btnThreePlayers = new javax.swing.JButton();
        btnFourPlayers = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnReturn.setText("<-");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });

        btnTwoPlayers.setText("2");
        btnTwoPlayers.setToolTipText("");
        btnTwoPlayers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTwoPlayersActionPerformed(evt);
            }
        });

        btnThreePlayers.setText("3");
        btnThreePlayers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThreePlayersActionPerformed(evt);
            }
        });

        btnFourPlayers.setText("4");
        btnFourPlayers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFourPlayersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btnReturn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(btnTwoPlayers)
                .addGap(118, 118, 118)
                .addComponent(btnThreePlayers)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addComponent(btnFourPlayers)
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFourPlayers)
                    .addComponent(btnThreePlayers)
                    .addComponent(btnTwoPlayers))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addComponent(btnReturn)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void showForm(Class<? extends JFrame> formClass) {
        JFrame form = null;
        try {
            form = formClass.getDeclaredConstructor().newInstance();
            form.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            System.err.println("Error al crear la ventana: " + e.getMessage());

        }
    }
    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        showForm(FrmWelcome.class);
    }//GEN-LAST:event_btnReturnActionPerformed

    private void btnTwoPlayersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTwoPlayersActionPerformed
        showForm(FrmLobby.class);

    }//GEN-LAST:event_btnTwoPlayersActionPerformed

    private void btnThreePlayersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThreePlayersActionPerformed
        showForm(FrmLobby.class);
    }//GEN-LAST:event_btnThreePlayersActionPerformed

    private void btnFourPlayersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFourPlayersActionPerformed
        showForm(FrmLobby.class);
    }//GEN-LAST:event_btnFourPlayersActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmCreateGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCreateGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCreateGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCreateGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCreateGame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFourPlayers;
    private javax.swing.JButton btnReturn;
    private javax.swing.JButton btnThreePlayers;
    private javax.swing.JButton btnTwoPlayers;
    // End of variables declaration//GEN-END:variables
}
