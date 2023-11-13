
package vista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import modelo.conexion;

public class RegistroUsuario extends javax.swing.JFrame {
  modelo.conexion con=new conexion();
Connection cn=con.conector();
    public RegistroUsuario() {
        initComponents();
this.setLocationRelativeTo(null);








    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombreUsuarioR = new javax.swing.JTextField();
        txtApellidoPUsuarioR = new javax.swing.JTextField();
        txtApellidoMUsuarioR = new javax.swing.JTextField();
        txtCorreoUsuarioR = new javax.swing.JTextField();
        txtContraseñaUsuarioR = new javax.swing.JPasswordField();
        btnRegistrar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 40));

        jPanel3.setBackground(new java.awt.Color(102, 102, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 40, 360));

        jPanel4.setBackground(new java.awt.Color(51, 0, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Dubai", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTRO DE USUARIO");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, -20, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 690, 40));

        jPanel5.setBackground(new java.awt.Color(51, 0, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 40, 320));

        jPanel6.setBackground(new java.awt.Color(0, 102, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 650, 40));

        jPanel7.setBackground(new java.awt.Color(0, 102, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 40, 280));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("APELLIDO P:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 90, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("APELLIDO M:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 90, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("CORREO:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 70, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("CONTRASEÑA:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, 110, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("NOMBRE:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 70, -1));

        txtNombreUsuarioR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreUsuarioRActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombreUsuarioR, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 200, 30));
        jPanel1.add(txtApellidoPUsuarioR, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 200, 30));

        txtApellidoMUsuarioR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoMUsuarioRActionPerformed(evt);
            }
        });
        jPanel1.add(txtApellidoMUsuarioR, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 200, 30));
        jPanel1.add(txtCorreoUsuarioR, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 200, 30));

        txtContraseñaUsuarioR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseñaUsuarioRActionPerformed(evt);
            }
        });
        jPanel1.add(txtContraseñaUsuarioR, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, 180, 30));

        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, 100, 40));

        btnRegresar.setText("REGRESAR");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 350, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreUsuarioRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreUsuarioRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreUsuarioRActionPerformed

    private void txtApellidoMUsuarioRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoMUsuarioRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoMUsuarioRActionPerformed

    private void txtContraseñaUsuarioRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseñaUsuarioRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraseñaUsuarioRActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        String nombre=txtNombreUsuarioR.getText();
  String apellidoP=txtApellidoPUsuarioR.getText();
  String apellidoM=txtApellidoMUsuarioR.getText();
  String correo=txtCorreoUsuarioR.getText();
  String contraseña=String.valueOf(txtContraseñaUsuarioR.getPassword());

if(nombre.isEmpty()|| apellidoP.isEmpty() || apellidoM.isEmpty() || correo.isEmpty() || contraseña.isEmpty()){
JOptionPane.showMessageDialog(null, "ES OBLIGATORIO EL CAMPO");
}else{
try{
String consulta="INSERT INTO usuarios (nombre,apellido_p,apellido_m,correo,contraseña)VALUES('"+nombre+"','"+apellidoP+"','"+apellidoM+"','"+correo+"','"+contraseña+"') ";
PreparedStatement ps= cn.prepareStatement(consulta);
ps.execute();
JOptionPane.showMessageDialog(null, "DATOS GUARDADOS CORRECTAMENTE");
txtNombreUsuarioR.setText("");
txtApellidoPUsuarioR.setText("");
txtApellidoMUsuarioR.setText("");
txtNombreUsuarioR.setText("");
txtCorreoUsuarioR.setText("");
txtContraseñaUsuarioR.setText("");
}catch (Exception e){
JOptionPane.showMessageDialog(null, "NO SE PUDO GUARDAR USUARIO"+e);
}


}

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
            this.setVisible(false);
Login n= new Login();
n.setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTextField txtApellidoMUsuarioR;
    private javax.swing.JTextField txtApellidoPUsuarioR;
    private javax.swing.JPasswordField txtContraseñaUsuarioR;
    private javax.swing.JTextField txtCorreoUsuarioR;
    private javax.swing.JTextField txtNombreUsuarioR;
    // End of variables declaration//GEN-END:variables
}
