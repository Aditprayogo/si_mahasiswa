/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;

/**
 *
 * @author LENOVO
 */
public interface Model_DAO <A> {
    
    public void insert(A object);
    public void update(A object);
    public void delete(String id);
    public List<A> getAll();
    public List<A> getCari(String key);
     
    
}
