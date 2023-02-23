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
public class BookCategory implements IBookFacade {

    private String bookcategory;

    public BookCategory(String category) {
        this.bookcategory = category;
    }

    @Override
    public boolean isEmpty() {
        
        if(this.bookcategory.isEmpty()){return false;}
        else{return true;}
    }

}
