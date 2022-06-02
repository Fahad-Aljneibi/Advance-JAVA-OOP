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
public class Book {
    
    private int bookid;
    private String category;
    private String title;
    private double price;

    public Book(int bookid, String category, String title, double price) {
        this.bookid = bookid;
        this.category = category;
        this.title = title;
        this.price = price;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" + "bookid=" + bookid + ", category=" + category + ", title=" + title + ", price=" + price + '}';
    }
    
    
    
}
