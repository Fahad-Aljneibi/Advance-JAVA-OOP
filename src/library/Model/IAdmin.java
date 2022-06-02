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
public interface IAdmin {
    
    public String updateBook(int bookId, String category, String title, double price);
   
    public String addNewBook(int bookId, String category, String title, double price);
    public String findBookById(int bookId);
    
}
