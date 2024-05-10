
package frm;

import factory.MVCFactory;
import javax.swing.JOptionPane;
import mvc.player.PlayerComponent;

/**
 * Clase FrmJoinGame que extiende de JFrame, diseñada para proporcionar una interfaz gráfica
 * donde los usuarios pueden ingresar un código para unirse a un juego existente.
 */
public class FrmJoinGame extends javax.swing.JFrame {

    private String code;
    private PlayerComponent playerComponent;
   
     /**
     * Constructor para FrmJoinGame. Inicializa los componentes de la ventana.
     */
    public FrmJoinGame() {
        this.playerComponent = new PlayerComponent();
        initComponents();
    }

    /**
     * Muestra la ventana de personalización y cierra la ventana actual.
     */
    private void showPersonalizationFrm() {
        FrmPersonalization v = new FrmPersonalization();
        v.setVisible(true);
        dispose();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCode = new javax.swing.JTextField();
        btnJoin = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Join game");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodeActionPerformed(evt);
            }
        });
        getContentPane().add(txtCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, 220, 50));

        btnJoin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/btnJoin.png"))); // NOI18N
        btnJoin.setContentAreaFilled(false);
        btnJoin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJoinActionPerformed(evt);
            }
        });
        getContentPane().add(btnJoin, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 230, -1, -1));

        btnReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/btnExit (1).png"))); // NOI18N
        btnReturn.setContentAreaFilled(false);
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });
        getContentPane().add(btnReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/desingFrm/frmJoinGame.png"))); // NOI18N
        jLabel1.setText("ingresa codigo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 570));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
 /**
     * Solicita confirmación al usuario antes de cerrar la ventana y retornar a la pantalla principal.
     * 
     * @return el resultado de la confirmación del usuario.
     */
    public int validarSalidaUsuario() {
        return JOptionPane.showConfirmDialog(this, "You will return to the home screen, are you sure?", "Confirmation", JOptionPane.YES_NO_OPTION);
    }

    /**
     * Maneja el evento del botón de retorno verificando primero la decisión del usuario.
     * Si el usuario confirma, cierra la ventana actual y abre la pantalla de bienvenida.
     */
    public void btnReturn() {
        if (validarSalidaUsuario() == JOptionPane.YES_OPTION) {
            abrirPantallaBienvenida();
            cerrarPantalla();
        }
    }

    /**
     * Cierra esta ventana.
     */
    public void cerrarPantalla() {
        this.dispose();
    }

    /**
     * Abre la pantalla de bienvenida.
     */
    public void abrirPantallaBienvenida() {
        FrmWelcome v = new FrmWelcome();
        v.setVisible(true);
    }
    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        abrirPantallaBienvenida();
        cerrarPantalla();
    }//GEN-LAST:event_btnReturnActionPerformed

    private void btnJoinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJoinActionPerformed
        code = txtCode.getText();
        if (code.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo codigo está vacío");
        } else if (code.length() != 4) {
            JOptionPane.showMessageDialog(null, "El código debe tener 4 letras");
          
        } else {
            showPersonalizationFrm(); 
        }

    }//GEN-LAST:event_btnJoinActionPerformed

    private void txtCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodeActionPerformed

    }//GEN-LAST:event_txtCodeActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnJoin;
    private javax.swing.JButton btnReturn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtCode;
    // End of variables declaration//GEN-END:variables
}
