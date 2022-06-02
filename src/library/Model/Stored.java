/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.Model;

import java.util.*;

/**
 *
 * @author fahad
 */
public class Stored<B> {
    
    private List<B> sList;

    public Stored()
    {
        sList = new ArrayList<>();
        
    }
    
    public void add(B b)
    {
        sList.add(b);
        
    }
    
    public void delete(B b)
    {
        sList.remove(b);
    }

    
    public B get(int i)
    {
        return sList.get(i);
    }
    
    public int countItems(){
        return sList.size();
    }
   
    
}
