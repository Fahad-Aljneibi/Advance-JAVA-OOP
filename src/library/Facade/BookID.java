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
public class BookID implements IBookFacade{
    
    private String bookid;
    
    public BookID(String id)
    {
        this.bookid = id;
    }

    @Override
    public boolean isEmpty() {
        
        if(this.bookid.isEmpty())
        {
            return false;
        }
        else
        {
            return true;
        }
            
    }
    
}
