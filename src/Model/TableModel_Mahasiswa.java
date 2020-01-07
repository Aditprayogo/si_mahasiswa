/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author LENOVO
 */
public class TableModel_Mahasiswa extends AbstractTableModel {
    
    List<Mahasiswa> list;
    
    public TableModel_Mahasiswa(List<Mahasiswa> list){
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       switch (columnIndex){
           case 0:
               return list.get(rowIndex).getNim();
           case 1:
               return list.get(rowIndex).getNama();
           case 2:
               return list.get(rowIndex).getAgama();
           case 3:
               return list.get(rowIndex).getTelepon();
           default:
               return null;
       }
    }
    
    @Override
    public String getColumnName(int column) {
       switch (column){
           case 0:
               return "NIM";
           case 1:
               return "NAMA";
           case 2:
               return "AGAMA";
           case 3:
               return "TELEPON";
           default:
               return null;
       }
    }
    
    
    
}
