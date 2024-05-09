package frm;

import factory.MVCFactory;

public class FrmWelcome extends javax.swing.JFrame {

    private static FrmWelcome frmWelcomeInstance;

    public FrmWelcome() {
        initComponents();
        MVCFactory.getInstance();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnJoinGame = new javax.swing.JButton();
        btnCreateGame = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Timbiriche game");
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusCycleRoot(false);
        setForeground(new java.awt.Color(255, 255, 255));
        setName("Inicio"); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnJoinGame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/btnJoinGame.png"))); // NOI18N
        btnJoinGame.setContentAreaFilled(false);
        btnJoinGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJoinGameActionPerformed(evt);
            }
        });
        getContentPane().add(btnJoinGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, -1, -1));

        btnCreateGame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/btnCreateGame.png"))); // NOI18N
        btnCreateGame.setContentAreaFilled(false);
        btnCreateGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateGameActionPerformed(evt);
            }
        });
        getContentPane().add(btnCreateGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, -1, -1));

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/btnExit (1).png"))); // NOI18N
        btnExit.setText("exit");
        btnExit.setContentAreaFilled(false);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 120, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/desingFrm/frmWelcome.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 580));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static FrmWelcome getInstance() {
        if (frmWelcomeInstance == null) {
            frmWelcomeInstance = new FrmWelcome();
        }
        return frmWelcomeInstance;
    }

    private void btnJoinGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJoinGameActionPerformed
        FrmJoinGame v = new FrmJoinGame();
        v.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnJoinGameActionPerformed

    private void btnCreateGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateGameActionPerformed
        FrmCreateGame v = new FrmCreateGame(MVCFactory.instanceGameComponent());
        v.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCreateGameActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    
    
  
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmWelcome().setVisible(true);
            }
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateGame;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnJoinGame;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

}
