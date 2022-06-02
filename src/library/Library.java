/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;
import library.Model.Book;
import library.Model.Stored;
import library.JDBC.BookDAO;
import java.util.*;
import java.sql.*;
/**
 *
 * @author fahad
 */
public class Library {
static BookDAO bookDAO = new BookDAO();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        String w = "fahad";
        
        System.out.println(w.charAt(1));
        //doShowAllEmployees();
        //doAddNewOrder();
    }
    
    public static void doShowAllEmployees() throws SQLException {
        //get all employees using the DAO
        Stored<Book> bookList = bookDAO.getAllBooks();

//        //iterate over the empList and print 
//        for (Book book : bookList) {
//            System.out.println(book);
//        }

        //double total=0;
        for(int i = 0; i < bookList.countItems();i++)
        {
            //total = total + fridge1.get(i).getPrice();
            System.out.println(bookList.get(i));
        }
    }


    public static void doAddNewOrder() throws SQLException {

       
//        int addStatus = bookDAO.addNewOrder(1, 3, 90);
//        if (addStatus == 1) {
//            System.out.println(" Added successfully");
//        }
//        else {
//            System.out.println("Error adding new employee ");
//        }
    }
}
