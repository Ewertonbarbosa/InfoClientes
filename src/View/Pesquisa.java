
package View;

import Control.Conexao;
import Model.ModeloTabela;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;


public class Pesquisa extends javax.swing.JFrame {
    Conexao con = new Conexao();

    /**
     * Creates new form Pesquisa
     */
    public Pesquisa() {
        initComponents();
        con.conectabanco();
        
        preencherTabela("select a.descricao, b.meioacesso, b.endereco, b.usuario, b.senha, b.maquina from cliente a, conexao b where a.id = b.id_cliente order by descricao, endereco");
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableInfo = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtPesquisa = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btGerenciar = new javax.swing.JButton();
        txtBot = new javax.swing.JLabel();
        txtLogado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tableInfo.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        tableInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableInfo.setCellSelectionEnabled(true);
        jScrollPane1.setViewportView(tableInfo);

        jLabel1.setText("Descri��o:");

        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyPressed(evt);
            }
        });

        jButton1.setText("Procurar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Informe a descri��o");

        btGerenciar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btGerenciar.setText("Gerenciar");
        btGerenciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGerenciarActionPerformed(evt);
            }
        });

        txtBot.setText("Usu�rio logado:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtBot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtLogado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(395, 395, 395)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btGerenciar))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(182, 182, 182)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(btGerenciar))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtBot)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtLogado, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        preencherTabela("select a.descricao, b.meioacesso, b.endereco, b.usuario, b.senha, b.maquina from cliente a, conexao b where a.descricao containing '"+txtPesquisa.getText()+"' and a.id = b.id_cliente order by descricao, endereco");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btGerenciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGerenciarActionPerformed
        verificaLogon();
        //ViewGerenciar obj = new ViewGerenciar();
        //obj.setVisible(true);
        //this.dispose();
    }//GEN-LAST:event_btGerenciarActionPerformed

    private void txtPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
          preencherTabela("select a.descricao, b.meioacesso, b.endereco, b.usuario, b.senha, b.maquina from cliente a, conexao b where a.descricao containing '"+txtPesquisa.getText()+"' and a.id = b.id_cliente order by descricao, endereco"); 
        }
    }//GEN-LAST:event_txtPesquisaKeyPressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        txtPesquisa.requestFocus();    
    }//GEN-LAST:event_formWindowOpened

    public void preencherTabela(String SQL) {
        ArrayList dados = new ArrayList();
                
        String[] colunas = new String[]{"Descri��o", "Acesso", "ID", "Usu�rio", "Senha", "M�quina"}; // nome das colunas
        
        con.executaSQL(SQL);
        
        try {
            con.rs.first();
        do {
            
            dados.add(new Object[]{con.rs.getString("descricao"), con.rs.getString("meioacesso"), con.rs.getString("endereco"), con.rs.getString("usuario"), con.rs.getString("senha"), con.rs.getString("maquina")});
            
            
        } while(con.rs.next());        
        } catch (SQLException ex) {
                //JOptionPane.showMessageDialog(null, "Erro ao preencher o Array\n Erro: " + ex);
            }       
        
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        
        tableInfo.setModel(modelo);
        tableInfo.getColumnModel().getColumn(0).setPreferredWidth(210); // tamanho do campo
        tableInfo.getColumnModel().getColumn(0).setResizable(false); // n�o permite alterar o tamanho do campo com o mouse
        tableInfo.getColumnModel().getColumn(1).setPreferredWidth(160); // tamanho do campo
        tableInfo.getColumnModel().getColumn(1).setResizable(false); // n�o permite alterar o tamanho do campo com o mouse
        tableInfo.getColumnModel().getColumn(2).setPreferredWidth(210); // tamanho do campo
        tableInfo.getColumnModel().getColumn(2).setResizable(false); // n�o permite alterar o tamanho do campo com o mouse
        tableInfo.getColumnModel().getColumn(3).setPreferredWidth(310); // tamanho do campo
        tableInfo.getColumnModel().getColumn(3).setResizable(false); //n�o permite alterar o tamanho do campo com o mouse
        tableInfo.getColumnModel().getColumn(4).setPreferredWidth(150); // tamanho do campo
        tableInfo.getColumnModel().getColumn(4).setResizable(false); //n�o permite alterar o tamanho do campo com o mouse
        tableInfo.getColumnModel().getColumn(5).setPreferredWidth(160); // tamanho do campo
        tableInfo.getColumnModel().getColumn(5).setResizable(false); // n�o permite alterar o tamanho do campo com o mouse
        tableInfo.getTableHeader().setReorderingAllowed(false); // n�o permite reordenar a tabela
        tableInfo.setAutoResizeMode(tableInfo.AUTO_RESIZE_OFF); // n�o permite redimensionar a tabela
        tableInfo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // permite apenas selecionar um item da tabela
        
    }
    
    public void setRecebeTexto(String txt) // metodo que recebe e seta o texto do FORM Login para o campo
    {
        txtLogado.setText(txt);
    }
    
    public void setRecebeTexto2(String txt) {
        txtLogado.setText(txt);
    }
    
    public void verificaLogon (){
        
        try {
            con.executaSQL("select * from usuario where login ='"+txtLogado.getText()+"'");
            con.rs.first();
            if ((con.rs.getString("perfil")).equals("ADM")){
            ViewGerenciar obj = new ViewGerenciar();
            obj.setVisible(true);
            this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Usu�rio n�o permitido para acessar esta tela.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ex);
        }
    }
      
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
            java.util.logging.Logger.getLogger(Pesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pesquisa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btGerenciar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableInfo;
    private javax.swing.JLabel txtBot;
    private javax.swing.JLabel txtLogado;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}
