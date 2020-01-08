/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Model_DAO;
import Model.Mahasiswa;
import Model.TableModel_Mahasiswa;
import View.MMahasiswa;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class Controller_Mahasiswa {
    MMahasiswa form;
    Model_DAO<Mahasiswa> model;
    List<Mahasiswa> list;
    
    public Controller_Mahasiswa(MMahasiswa form){
        this.form = form;
        model = new DAO.DAO_Mahasiswa();
        list = model.getAll();
    }
    
    public void reset(){
        form.getTxtnim().setText("");
        form.getTxtnama().setText("");
        form.getTxttelp().setText("");
    }
    
    public void isiTable(){
        list = model.getAll();
        TableModel_Mahasiswa tableMahasiswa = new TableModel_Mahasiswa(list);
        form.getTblmhs().setModel(tableMahasiswa);
    }
    
    public void isiField(int row){
        form.getTxtnim().setText(String.valueOf(list.get(row).getNim()));
        form.getTxtnama().setText(list.get(row).getNama());
        form.getCboagama().setSelectedItem(list.get(row).getAgama());
        form.getTxttelp().setText(list.get(row).getTelepon());
        
    }
    
     public void insert() {
        
        Mahasiswa p = new Mahasiswa();
        
        p.setNim(form.getTxtnim().getText());
        p.setNama(form.getTxtnama().getText());
        p.setAgama(form.getCboagama().getSelectedItem().toString());
        p.setTelepon(form.getTxttelp().getText());
        
        model.insert(p);
        
    }
     
     public void update() {
        
        Mahasiswa p = new Mahasiswa();
        
        p.setNim(form.getTxtnim().getText());
        p.setNama(form.getTxtnama().getText());
        p.setAgama(form.getCboagama().getSelectedItem().toString());
        p.setTelepon(form.getTxttelp().getText());
        
        model.update(p);
        
    }
     
     public void delete() {
        
        if (!form.getTxtnim().getText().trim().isEmpty()) {
            
            String kode = (form.getTxtnim().getText());
            model.delete(kode);
            
        } else {
            
            JOptionPane.showMessageDialog(form, "Pilih data yang akan di hapus");
        }
       
    }
     
      public void isiTableCari() {
        
        list = model.getCari(form.getTxtnim().getText().trim());
        TableModel_Mahasiswa tableMahasiswa = new TableModel_Mahasiswa(list);
        form.getTblmhs().setModel(tableMahasiswa);
        
    }
    
}
