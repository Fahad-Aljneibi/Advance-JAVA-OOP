/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.JDBC;

import java.sql.*;
import library.Exception.InputException;
import library.Factory.UserFactory;
import library.Model.Book;
import library.Model.Employee;
import library.Model.Stored;
import library.Model.Student;
import library.Model.User;

/**
 *
 * @author fahad
 */
public class UserDAO {

    public boolean findEmployee(String empId, String empPass) throws SQLException {
        DBConnection db = DBConnection.getInstace();
        Connection conn = db.getConnection();
        Statement stmt = conn.createStatement();

        Employee emp = new Employee();

        String querySQL = emp.login(empId, empPass);
        ResultSet rs = stmt.executeQuery(querySQL);

        //Book book = null;
        //Employee employee = null;
        //Stored<Book> bookList = new Stored();
        boolean find = false;
        if (rs.next()) {
//            String empid = rs.getString("EMPLOYEEID");
//            String password = rs.getString("PASSWORD");
//            String name = rs.getString("NAME");
//            int phone = rs.getInt("PHONE");
            find = true;
            //put the data from the resultset into an Book Object
            //book = new Book(bookid, category, title, price);
            //employee = new Employee(empid,password,name,phone);
            //bookList.add(book);

        }

        //close result set, statement and the connection to the database
        stmt.close();
        rs.close();
        conn.close();

        return find;
    }

    public boolean findStudent(String stuId, String stuPass) throws SQLException {
        DBConnection db = DBConnection.getInstace();
        Connection conn = db.getConnection();
        Statement stmt = conn.createStatement();

        Student stu = new Student();

        String querySQL = stu.login(stuId, stuPass);
        ResultSet rs = stmt.executeQuery(querySQL);

        boolean find = false;
        if (rs.next()) {
            find = true;

        }

        //close result set, statement and the connection to the database
        stmt.close();
        rs.close();
        conn.close();

        return find;
    }

    public int addNewOrder(String userid, int bookid, double total, String letter) throws SQLException {

        DBConnection db = DBConnection.getInstace();
        Connection conn = db.getConnection();
        Statement stmt = conn.createStatement();

        String insertSQL = null;

        if (letter.equals("E")) {
            Employee emp = new Employee();
            insertSQL = emp.orderBooks(userid, bookid, total);
        }

        if (letter.equals("S")) {
            Student emp = new Student();
            insertSQL = emp.orderBooks(userid, bookid, total);
        }

        int insertStatus = stmt.executeUpdate(insertSQL);

        stmt.close();
        conn.close();

        return insertStatus;

    }

    public Stored<Book> getAllBooks(String letter) throws SQLException {

        DBConnection db = DBConnection.getInstace();
        Connection conn = db.getConnection();
        Statement stmt = conn.createStatement();
        String sql = null;
        Stored<Book> bookList = new Stored();
        try {
            //create Factoy 
            UserFactory uf = new UserFactory();
            User user;

            if (letter.equals("E")) {
                user = uf.createUser("employee");
                sql = user.getAllBooks();
            }

            if (letter.equals("S")) {
                user = uf.createUser("student");
                sql = user.getAllBooks();
            }

            if (sql == null) {
                throw new InputException("NOT ALLOW USE THIS SERVICE");
            }
            ResultSet rs = stmt.executeQuery(sql);
            Book book;

            while (rs.next()) {
                int bookId = rs.getInt("BOOKID");
                String bookCategory = rs.getString("CATEGORY");
                String bookTitle = rs.getString("TITLE");
                double bookPrice = rs.getDouble("PRICE");

                //put the data from the resultset into an Book Object
                book = new Book(bookId, bookCategory, bookTitle, bookPrice);

                //add book to the empList
                bookList.add(book);
            }

            //close all the db resources
            rs.close();
            stmt.close();
            conn.close();

        } catch (InputException ex) {

            ex.getMessage();

        }
        return bookList;
    }

    public Stored<Book> findBookByCategory(String category, String letter) throws SQLException {
        DBConnection db = DBConnection.getInstace();
        Connection conn = db.getConnection();
        Statement stmt = conn.createStatement();

        //create Factoy 
        UserFactory uf = new UserFactory();
        User user;

        String querySQL = null;

        if (letter.equals("E")) {
            user = uf.createUser("employee");
            querySQL = user.getBookByCategory(category);
        }

        if (letter.equals("S")) {
            user = uf.createUser("student");
            querySQL = user.getBookByCategory(category);
        }

        ResultSet rs = stmt.executeQuery(querySQL);

        Book book = null;

        Stored<Book> bookList = new Stored();
        while (rs.next()) {
            int bookId = rs.getInt("BOOKID");
            String bookCategory = rs.getString("CATEGORY");
            String bookTitle = rs.getString("TITLE");
            double bookPrice = rs.getDouble("PRICE");

            //facad
            //put the data from the resultset into an Book Object
            book = new Book(bookId, bookCategory, bookTitle, bookPrice);

            //add book to the empList
            bookList.add(book);
        }

        //close result set, statement and the connection to the database
        stmt.close();
        rs.close();
        conn.close();

        return bookList;
    }

    public int deleteOrder(String letter) throws SQLException {

        //create Factoy 
        UserFactory uf = new UserFactory();
        User user;

        int num = 0;
        if (letter.equals("E")) {
            user = uf.createUser("employee");
            num = Integer.parseInt(user.delete());
        }

        if (letter.equals("S")) {
            user = uf.createUser("student");
            num = Integer.parseInt(user.delete());
        }

        return num;
    }

    public Book findBookById(int bookId, String letter) throws SQLException {
        DBConnection db = DBConnection.getInstace();
        Connection conn = db.getConnection();
        Statement stmt = conn.createStatement();

        String querySQL = null;
        if (letter.equals("E")) {
            Employee emp = new Employee();
            querySQL = emp.add(bookId);
        }

        if (letter.equals("S")) {
            Student stu = new Student();
            querySQL = stu.add(bookId);
        }

        //String querySQL = "SELECT * FROM BOOK WHERE bookId='" + bookId + "';";
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
