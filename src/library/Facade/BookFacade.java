/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.Facade;

/**
 *
 * @author fahad
 */
public class BookFacade implements IBookFacade{
    
    private BookID bookid;
    private BookCategory bookcategory;
    private BookTitle booktitle;
    private BookPrice bookprice;
    
    public BookFacade(String id, String category, String title , String price)
    {
        bookid = new BookID(id);
        bookcategory = new BookCategory(category);
        booktitle = new BookTitle(title);
        bookprice = new BookPrice(price);
    }

    @Override
    public boolean isEmpty() {
        
        return bookid.isEmpty() & bookcategory.isEmpty() & booktitle.isEmpty() & bookprice.isEmpty();
    }
    
    
    
}
