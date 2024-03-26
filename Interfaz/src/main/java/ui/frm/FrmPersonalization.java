/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui.frm;

import config.JComboBoxRender;

import java.util.Hashtable;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author arace
 */
public class FrmPersonalization extends javax.swing.JFrame {

    /**
     * Creates new form FrmPersonalization
     */
    Hashtable<Object, ImageIcon> mElementos;
    int width = 40;
    int height = 40;

    private String red_avatar = "/sources/red.png";
    private String blue_avatar = "/sources/blue.png";
    private String green_avatar = "/sources/green.png";
    private String yellow_avatar = "/sources/yellow.png";

    public FrmPersonalization() {
        initComponents();
        mElementos = new Hashtable<>();
        initCombo();
    }

    private void initCombo() {
        comboAvatar.addItem("Red");
        comboAvatar.addItem("Blue");
        comboAvatar.addItem("Green");
        comboAvatar.addItem("Yellow");

        mElementos.put("Red", getIcon(red_avatar));
        mElementos.put("Blue", getIcon(blue_avatar));
        mElementos.put("Green", getIcon(green_avatar));
        mElementos.put("Yellow", getIcon(yellow_avatar));

    }

    public ImageIcon getIcon(String path) {
        return new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNamePlayer = new javax.swing.JTextField();
        btnReturn = new javax.swing.JButton();
        comboAvatar = new javax.swing.JComboBox<>();
        btnJoin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnReturn.setText("<-");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });

        comboAvatar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAvatarActionPerformed(evt);
            }
        });

        btnJoin.setText("Join");
        btnJoin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJoinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnReturn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNamePlayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnJoin))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 115, Short.MAX_VALUE)
                .addComponent(comboAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(txtNamePlayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(comboAvatar, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnJoin)
                .addGap(13, 13, 13)
                .addComponent(btnReturn)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        int exit = JOptionPane.showConfirmDialog(this, "You will return to the home screen, are you sure?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (exit == JOptionPane.YES_OPTION) {
            FrmWelcome v = new FrmWelcome();
            v.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnReturnActionPerformed

    private void btnJoinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJoinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnJoinActionPerformed

    private void comboAvatarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAvatarActionPerformed
        JComboBoxRender mRender = new JComboBoxRender(mElementos);
        comboAvatar.setRenderer(mRender);
    }//GEN-LAST:event_comboAvatarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPersonalization.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPersonalization.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPersonalization.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPersonalization.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPersonalization().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnJoin;
    private javax.swing.JButton btnReturn;
    private javax.swing.JComboBox<String> comboAvatar;
    private javax.swing.JTextField txtNamePlayer;
    // End of variables declaration//GEN-END:variables

}
