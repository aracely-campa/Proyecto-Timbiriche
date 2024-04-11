/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frm;

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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTwoPlayers = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();
        btnThreePlayers = new javax.swing.JButton();
        btnFourPlayers = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTwoPlayers.setText("2");
        btnTwoPlayers.setToolTipText("");
        btnTwoPlayers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTwoPlayersActionPerformed(evt);
            }
        });
        getContentPane().add(btnTwoPlayers, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, -1));

        btnReturn.setText("<-");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });
        getContentPane().add(btnReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 271, -1, -1));

        btnThreePlayers.setText("3");
        btnThreePlayers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThreePlayersActionPerformed(evt);
            }
        });
        getContentPane().add(btnThreePlayers, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, -1, -1));

        btnFourPlayers.setText("4");
        btnFourPlayers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFourPlayersActionPerformed(evt);
            }
        });
        getContentPane().add(btnFourPlayers, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTwoPlayersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTwoPlayersActionPerformed
        showForm(FrmPersonalization.class);
    }//GEN-LAST:event_btnTwoPlayersActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        showForm(FrmWelcome.class);
    }//GEN-LAST:event_btnReturnActionPerformed

    private void btnThreePlayersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThreePlayersActionPerformed
        showForm(FrmPersonalization.class);
    }//GEN-LAST:event_btnThreePlayersActionPerformed

    private void btnFourPlayersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFourPlayersActionPerformed
        showForm(FrmPersonalization.class);
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
