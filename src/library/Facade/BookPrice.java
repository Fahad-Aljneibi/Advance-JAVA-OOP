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
public class BookPrice implements IBookFacade {

    private String bookprice;

    public BookPrice(String price) {
        this.bookprice = price;
    }

    @Override
    public boolean isEmpty() {
        if (this.bookprice.isEmpty()) {
            return false;
        }

        return true;
    }

}
