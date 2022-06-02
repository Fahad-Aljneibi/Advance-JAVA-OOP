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
public abstract class User {
    
    private String id;
    private String password;
    private String name;
    private int phone;

    public User(String id, String password, String name, int phone) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.phone = phone;
    }

    public User() {
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", password=" + password + ", name=" + name + ", phone=" + phone + '}';
    }
    
    //get all books
    public abstract String getAllBooks();
    
    //get book by category
    public abstract String getBookByCategory(String category);
    
    

    
    //delete book
    public abstract String delete();
    
    
}
