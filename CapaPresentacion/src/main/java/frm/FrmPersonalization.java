package frm;

import domain.game.Player;
import enums.ImagesSourcers;
import factory.MVCFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import mvc.player.PlayerModel;

/**
 *
 * @author arace
 */
public class FrmPersonalization extends javax.swing.JFrame {

    private String namePlayer;
    private final String[] avatarPaths;
    private int currentIndex = 0;

    /**
     * Creates new form FrmPersonalization
     *
     * @param playerModel
     */
    public FrmPersonalization(PlayerModel playerModel) {
        initComponents();
        // Obtener las rutas de las imágenes
        avatarPaths = ImagesSourcers.getAvatarImages();
        // Verificar si avatarPaths es null antes de intentar usarlo
        if (avatarPaths != null && avatarPaths.length > 0) {
            displayCurrentAvatar();
        } else {
            // Si avatarPaths está vacío o es null, mostrar un mensaje de error o manejar la situación adecuadamente
            System.err.println("Error: avatarPaths is null or empty");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        btnReturn = new javax.swing.JButton();
        btnJoin = new javax.swing.JButton();
        txtNamePlayer = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rightButton = new javax.swing.JButton();
        avatarButton = new javax.swing.JButton();
        leftButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Personalization");

        btnReturn.setText("<-");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });

        btnJoin.setText("Join");
        btnJoin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJoinActionPerformed(evt);
            }
        });

        txtNamePlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamePlayerActionPerformed(evt);
            }
        });

        jLabel1.setText("name");

        jLabel2.setText("Avatar");

        rightButton.setText("-->");
        rightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightButtonActionPerformed(evt);
            }
        });

        avatarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/avatar/avatarBlue.png"))); // NOI18N

        leftButton.setText("<--");
        leftButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jLabel2))
                            .addComponent(txtNamePlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btnReturn)
                        .addGap(136, 136, 136)
                        .addComponent(btnJoin))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(leftButton)
                        .addGap(18, 18, 18)
                        .addComponent(avatarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rightButton)))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtNamePlayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(rightButton)
                        .addGap(39, 39, 39))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(avatarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(leftButton)))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReturn)
                    .addComponent(btnJoin))
                .addGap(17, 17, 17))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    // Método para mostrar la imagen actual en el avatarButton
    private void displayCurrentAvatar() {
        if (avatarPaths != null && currentIndex >= 0 && currentIndex < avatarPaths.length) {
            ImageIcon icon = new ImageIcon(avatarPaths[currentIndex]);
            avatarButton.setIcon(icon);
        } else {
            // Si avatarPaths es null o currentIndex está fuera de los límites, mostrar un mensaje de error o manejar la situación adecuadamente
            System.err.println("Error: avatarPaths is null or currentIndex is out of bounds");
        }
    }

    // Método para moverse a la imagen anterior
    private void showPreviousAvatar() {
        currentIndex--;
        if (currentIndex < 0) {
            currentIndex = avatarPaths.length - 1;
        }
        displayCurrentAvatar();
    }

    // Método para moverse a la siguiente imagen
    private void showNextAvatar() {
        currentIndex++;
        if (currentIndex >= avatarPaths.length) {
            currentIndex = 0;
        }
        displayCurrentAvatar();
    }


    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int exit = JOptionPane.showConfirmDialog(this, "You will return to the home screen, are you sure?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (exit == JOptionPane.YES_OPTION) {
            FrmWelcome v = new FrmWelcome();
            v.setVisible(true);
            this.dispose();
        }
    }                                         

    private void btnJoinActionPerformed(java.awt.event.ActionEvent evt) {                                        
// Obtener el nombre del jugador
        namePlayer = txtNamePlayer.getText();

        // Verificar si el nombre del jugador no está vacío
        if (namePlayer == null || namePlayer.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo nombre está vacío");
        } else {
            // Crear el siguiente frame y pasarle el nombre del jugador
            FrmLobby v = new FrmLobby(MVCFactory.getInstance().instancePlayerComponent().getPlayerModel(), namePlayer);
            v.setVisible(true);
            this.dispose();
        }


    }                                       

    private void txtNamePlayerActionPerformed(java.awt.event.ActionEvent evt) {                                              
        namePlayer = txtNamePlayer.getText();

    }                                             

    private void leftButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        showPreviousAvatar();
    }                                          

    private void rightButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        showNextAvatar();
    }                                           

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(FrmPersonalization.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FrmPersonalization.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FrmPersonalization.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FrmPersonalization.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FrmPersonalization().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton avatarButton;
    private javax.swing.JButton btnJoin;
    private javax.swing.JButton btnReturn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton leftButton;
    private javax.swing.JButton rightButton;
    private javax.swing.JTextField txtNamePlayer;
    // End of variables declaration                   
}
