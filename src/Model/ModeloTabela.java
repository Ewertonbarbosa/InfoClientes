/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Usuario
 */
public class ModeloTabela extends AbstractTableModel {
   
    private ArrayList linhas = null; //armazena a quatidade de dados 
    private String[] colunas = null; // armazena os nomes das colunas 
    
    public ModeloTabela(ArrayList lin, String[] col) {
        setLinhas(lin);
        setColunas(col);        
    }
        
    public ArrayList getLinhas(){ 
        return linhas;
    }
    
    public void setLinhas(ArrayList dados){
        linhas = dados;
    }
    
    public String[] getColunas() {
        return colunas;
    }
    
    public void setColunas(String[] nomes){
        colunas = nomes;
    }
    
    public int getColumnCount() {
      return colunas.length;  
    }
    
    public int getRowCount() {
        return linhas.size();
    }
    
    public String getColumnName(int numeroCol){
        return colunas[numeroCol];
    }
    
    public Object getValueAt(int numeroLin, int numeroCol){
        Object[] linha = (Object[])getLinhas().get(numeroLin);
        return linha[numeroCol];
    }
}
