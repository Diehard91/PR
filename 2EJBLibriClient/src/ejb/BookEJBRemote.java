/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Remote;


/**
 *
 * @author Michele
 */
@Remote
public interface BookEJBRemote {
   
    List<Book> findBooks();
    void deleteBook(Book book);
    Book updateBook(Book book);
    Book createBook(Book book);
}
