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
public class BookTitle implements IBookFacade {

    private String booktitle;

    public BookTitle(String title) {
        this.booktitle = title;
    }

    @Override
    public boolean isEmpty() {
        if (this.booktitle.isEmpty()) {
            return false;
        }

        return true;
    }

}
