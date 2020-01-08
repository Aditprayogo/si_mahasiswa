/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Koneksi.Database;
import Model.Mahasiswa;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class DAO_Mahasiswa implements Model_DAO<Mahasiswa>{
    
    public DAO_Mahasiswa(){
        connection = Database.KoneksiDB();
    }
    
    Connection connection;
    String INSERT = "INSERT INTO mahasiswa(nim, nama, agama, telepon) values(?,?,?,?)";
    String UPDATE = "UPDATE mahasiswa SET nama=?, agama=?, telepon=? WHERE nim=?";
    String DELETE = "DELETE FROM mahasiswa WHERE nim=?";
    String SELECT = "SELECT * FROM mahasiswa";
    String CARI = "SELECT * FROM mahasiswa WHERE nama LIKE ? OR agama LIKE ? OR telepon LIKE ? OR nim LIKE ?";
    
    
            

    @Override
    public void insert(Mahasiswa object) {
         PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(INSERT);
            statement.setString(1, object.getNim());
            statement.setString(2, object.getNama());
            statement.setString(3, object.getAgama());
            statement.setString(4, object.getTelepon());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Di tambah");
                    
        } catch (Exception e) {
            
            e.printStackTrace();
            
        } finally {
            
            try {
                statement.close();
                
            } catch (SQLException ex) {
                
                Logger.getLogger(DAO_Mahasiswa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void update(Mahasiswa object) {
       PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(UPDATE);
            statement.setString(1, object.getNama());
            statement.setString(2, object.getAgama());
            statement.setString(3, object.getTelepon());
            statement.setString(4, object.getNim());
  
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Di ubah");
                    
        } catch (Exception e) {
            
            e.printStackTrace();
            
        } finally {
            
            try {
                statement.close();
                
            } catch (SQLException ex) {
                
                Logger.getLogger(DAO_Mahasiswa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void delete(String nim) {
        PreparedStatement statement = null;
        
        try {
            
            statement = connection.prepareStatement(DELETE);
            statement.setString(1, nim);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Di hapus");
                    
        } catch (Exception e) {
            
            e.printStackTrace();
            
        } finally {
            
            try {
                statement.close();
                
            } catch (SQLException ex) {
                
                Logger.getLogger(DAO_Mahasiswa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<Mahasiswa> getAll() {
         List<Mahasiswa> list = null;
        PreparedStatement statement = null;
        
        try {
            
            list = new ArrayList<Mahasiswa>();
            statement = connection.prepareStatement(SELECT);
            ResultSet rs = statement.executeQuery();
            
            while (rs.next()) {                
                Mahasiswa p = new Mahasiswa();
                p.setNim(rs.getString("nim"));
                p.setNama(rs.getString("nama"));
                p.setAgama(rs.getString("agama"));
                p.setTelepon(rs.getString("telepon"));
                list.add(p);
            }
            
                    
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        
        return list;
    }

    
    public List<Mahasiswa> getCari(String key) {
        List<Mahasiswa> list = null;
        PreparedStatement statement = null;
        
        try {
            
            list = new ArrayList<>();
            statement.setString(1, "%"+key+"%");
            statement.setString(2, "%"+key+"%");
            statement.setString(3, "%"+key+"%");
            
            ResultSet rs = statement.executeQuery();
            
            while (rs.next()) {                
                
                Mahasiswa p = new Mahasiswa();
                p.setNim(rs.getString("nim"));
                p.setNama(rs.getString("nama"));
                p.setAgama(rs.getString("agama"));
                p.setTelepon(rs.getString("telepon"));
                list.add(p);
                
            }

            
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        
        return list;
    }
    
}
