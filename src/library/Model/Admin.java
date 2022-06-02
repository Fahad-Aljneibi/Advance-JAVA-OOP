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
public class Admin extends User implements IAdmin {

    public Admin() {
    }

    public Admin(String id, String password, String name, int phone) {
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
    public String delete() {
        String deleteSQL = "DELETE FROM BOOK WHERE BOOKID=?;";
        return deleteSQL;
    }

    @Override
    public String addNewBook(int bookId, String category, String title, double price) {
        String insertSQL = "INSERT INTO book VALUES('" + bookId + "','" + category + "','" + title + "'," + price + ");";

        return insertSQL;
    }

    @Override
    public String updateBook(int bookId, String category, String title, double price) {
        String updateSQL = "UPDATE BOOK SET category ='" + category + "',title = '" + title + "',price=" + price + " WHERE bookId='" + bookId + "';";
        return updateSQL;
    }

    @Override
    public String findBookById(int bookId) {
        String querySQL = "SELECT * FROM BOOK WHERE bookId='" +bookId + "';";
        
        return querySQL;
    }

}
