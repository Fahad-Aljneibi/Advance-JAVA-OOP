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
public class Employee extends User implements IStuEmp {

    public Employee() {
    }

    public Employee(String id, String password, String name, int phone) {
        super(id, password, name, phone);
    }

    @Override
    public String getAllBooks() {
        
        String sql = "select * from book";
        return sql;
    }

    @Override
    public String getBookByCategory(String category) {
        String querySQL = "SELECT * FROM book WHERE category='" + category + "';";
        
        return querySQL;
    }

    @Override
    public String add(int bookId) {
       String querySQL = "SELECT * FROM BOOK WHERE bookId='" + bookId + "';";
       
       return querySQL;
    }

    @Override
    public String delete() {
    
        return "1";
    }

    @Override
    public String orderBooks(String userid,int bookid, double total) {
        String insertSQL = "INSERT into orderbook (userid,bookid,totalbooks) VALUES('" +userid + "','"+bookid + "','" + total + "');";  

        return insertSQL;
    }

    @Override
    public String login(String id, String password) {
        String querySQL = "SELECT * FROM EMPLOYEE WHERE EMPLOYEEID='" + id + "' AND PASSWORD = '"+password+"';";

        return querySQL;
    }


}
