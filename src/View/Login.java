/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.Conexao;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {
    Conexao con = new Conexao();
    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        con.conectabanco();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtSenhaAcesso = new javax.swing.JPasswordField();
        txtUsuarioAcesso = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("InfoCli");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Informe o código de acesso:");

        txtSenhaAcesso.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSenhaAcesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaAcessoActionPerformed(evt);
            }
        });
        txtSenhaAcesso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSenhaAcessoKeyPressed(evt);
            }
        });

        txtUsuarioAcesso.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtUsuarioAcesso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsuarioAcessoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSenhaAcesso, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                            .addComponent(txtUsuarioAcesso))))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(txtUsuarioAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(txtSenhaAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSenhaAcessoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSenhaAcessoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
           efetuaLogin();
             }
        
    }//GEN-LAST:event_txtSenhaAcessoKeyPressed

    private void txtSenhaAcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaAcessoActionPerformed
        
    }//GEN-LAST:event_txtSenhaAcessoActionPerformed

    private void txtUsuarioAcessoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioAcessoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            txtSenhaAcesso.requestFocus();
             }
    }//GEN-LAST:event_txtUsuarioAcessoKeyPressed

    public void efetuaLogin (){
        try {
            con.executaSQL("select * from usuario where login ='"+txtUsuarioAcesso.getText()+"' and senha ='"+txtSenhaAcesso.getText()+"'");
            con.rs.first(); // o usuario encontrado é salvo dentro do RESULTSET "rs"
            if (txtUsuarioAcesso.getText().equals(con.rs.getString("login")) && (txtSenhaAcesso.getText().equals(con.rs.getString("senha"))))
            { // aqui são comparados os valores dos campos com o bando de dados, se estiver correto executa a função abaixo
                Pesquisa obj = new Pesquisa(); // instancia do Form Pesquisa
                                
                obj.setRecebeTexto(txtUsuarioAcesso.getText()); 
                obj.setRecebeTexto2(txtSenhaAcesso.getText());
                
                obj.setVisible(true);
                this.dispose(); // fecha somente este FORM 
            } else {
                JOptionPane.showMessageDialog(null, "Usuário e/ou senha incorretos!");
            }           
                          
        } catch (SQLException ex) {
            // caso nao seja encontrado o usuario ele exibirá a mensagem abaixo
            //JOptionPane.showMessageDialog(null, "Usuário e/ou senha incorretos!"+ex);
            //txtCodAcesso.setText("");
        }
    }
    
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField txtSenhaAcesso;
    private javax.swing.JTextField txtUsuarioAcesso;
    // End of variables declaration//GEN-END:variables
}
