/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.Model;

/**
 *
 * @author fahad
 */
public interface IStuEmp {
    
    public String orderBooks(String userid, int bookid , double total);
    
    public String login(String id,String password);
    
    public String add(int bookId);
}
