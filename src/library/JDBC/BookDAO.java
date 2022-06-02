/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.JDBC;

import java.sql.*;
import java.util.*;
import library.Model.Admin;
import library.Model.Book;
import library.Model.Employee;
import library.Model.Stored;
import library.Model.User;

/**
 *
 * @author fahad
 */
public class BookDAO {

    public Stored<Book> getAllBooks() throws SQLException {

        DBConnection db = DBConnection.getInstace();
        Connection conn = db.getConnection();

        Statement stmt = conn.createStatement();

        Admin admin = new Admin();
        String sql = admin.getAllBooks();

        ResultSet rs = stmt.executeQuery(sql);

        //Stored<Book> booklist = new Stored();
        Book book;

        //List<Book> bookList = new ArrayList<>();
        Stored<Book> bookList = new Stored();

        while (rs.next()) {
            int bookId = rs.getInt("BOOKID");
            String bookCategory = rs.getString("CATEGORY");
            String bookTitle = rs.getString("TITLE");
            double bookPrice = rs.getDouble("PRICE");

            //put the data from the resultset into an Book Object
            book = new Book(bookId, bookCategory, bookTitle, bookPrice);

            //add book to the bookList
            bookList.add(book);
        }

        //close all the db resources
        rs.close();
        stmt.close();
        conn.close();

        return bookList;
    }

    public Stored<Book> findBookByCategory(String category) throws SQLException {

        DBConnection db = DBConnection.getInstace();
        Connection conn = db.getConnection();

        Statement stmt = conn.createStatement();

        Admin admin = new Admin();
        String querySQL = admin.getBookByCategory(category);

        ResultSet rs = stmt.executeQuery(querySQL);

        Book book = null;

        Stored<Book> bookList = new Stored();
        while (rs.next()) {
            int bookId = rs.getInt("BOOKID");
            String bookCategory = rs.getString("CATEGORY");
            String bookTitle = rs.getString("TITLE");
            double bookPrice = rs.getDouble("PRICE");

            //put the data from the resultset into an Book Object
            book = new Book(bookId, bookCategory, bookTitle, bookPrice);

            //add book to the bookList
            bookList.add(book);
        }

        //close result set, statement and the connection to the database
        stmt.close();
        rs.close();
        conn.close();

        return bookList;
    }

    public int deleteBook(int bookId) throws SQLException {
        
        DBConnection db = DBConnection.getInstace();
        Connection conn = db.getConnection();

        Admin admin = new Admin();
        String deleteSQL = admin.delete();
        
        PreparedStatement pstmt = conn.prepareStatement(deleteSQL);
        pstmt.setInt(1, bookId);
        
        int deleteStatus = pstmt.executeUpdate();
        pstmt.close();
        conn.close();
        
        return deleteStatus;
    }

    public int addNewBook(int bookId, String category, String title, double price) throws SQLException {

        DBConnection db = DBConnection.getInstace();
        Connection conn = db.getConnection();

        Admin admin = new Admin();
        String insertSQL = admin.addNewBook(bookId, category, title, price);
        
        Statement stmt = conn.createStatement();
        
        int insertStatus = stmt.executeUpdate(insertSQL);
        
        stmt.close();
        conn.close();
        return insertStatus;
    }

    public int updateBook(int bookId, String category, String title, double price) throws SQLException {
        DBConnection db = DBConnection.getInstace();
        Connection conn = db.getConnection();
        
        Admin admin = new Admin();
        String updateSQL = admin.updateBook(bookId, category, title, price);
        
        Statement stmt = conn.createStatement();
        
        int updateStatus = stmt.executeUpdate(updateSQL);
        
        stmt.close();
        conn.close();
        return updateStatus;
    }

    public Book findBookById(int bookId) throws SQLException {
        DBConnection db = DBConnection.getInstace();
        Connection conn = db.getConnection();
        
        Statement stmt = conn.createStatement();
        
        Admin admin = new Admin();
        String querySQL = admin.findBookById(bookId);
        ResultSet rs = stmt.executeQuery(querySQL);

        Book book = null;
        if (rs.next()) {
            int bookid = rs.getInt("BOOKID");
            String category = rs.getString("CATEGORY");
            String title = rs.getString("TITLE");
            double price = rs.getDouble("PRICE");
            //put the data from the resultset into an Book Object
            book = new Book(bookid, category, title, price);
        }
        
        //close result set, statement and the connection to the database
        stmt.close();
        rs.close();
        conn.close();

        return book;
    }

}
