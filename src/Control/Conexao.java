/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Conexao {
    public Statement stm = null; // prepara e realiza pesquisas no banco
    public ResultSet rs = null; // armazena o resultado de uma pesquisa passada para o Statement
    public Connection conecta; // responsavel por realizar a conexao com o banco
    
    private String caminho = "jdbc:firebirdsql:localhost:C:\\Users\\Usuario\\Documents\\NetBeansProjects\\InfoClientes\\banco\\INFO.GDB"; // diretorio do banco
    private String driver = "org.firebirdsql.jdbc.FBDriver"; // driver do firebird
    private String usuario = "SYSDBA"; // usuario do banco
    private String senha = "masterkey";  // senha do banco 
    
    public void conectabanco() {
        try {
            System.setProperty("jdbc.Driver", driver); // seta a proprierade do banco
            conecta = DriverManager.getConnection(caminho, usuario, senha); // realiza a conexao com o banco
            //JOptionPane.showMessageDialog(null, "Conectado!"); // mensagem de erro, caso ocorra algum
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha na conexão!\n" + ex);
            
        }
    
}
    
    public void executaSQL(String sql){
        try {
            stm = conecta.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }   
    
       
}
