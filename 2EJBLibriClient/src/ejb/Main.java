/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


/**
 *
 * @author Michele
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NamingException {
        Context ctx;
        ctx = new InitialContext();
        BookEJBRemote bookEJB = (BookEJBRemote)ctx.lookup("java:global/2EJBLibri/BookEJB!ejb.BookEJBRemote");

        Book book1 = new Book("Statistics", 12.5F, "Book on Statistics and Maths",  "1-24561-799-0", 200, false);
        book1 = bookEJB.createBook(book1);
        System.out.println("###Book 1 created:"+ book1);  
        
        Book book2 = new Book("Computer Networks",  12.5F, "Networks",  "1-24561-799-0", 400, false);
        book2 = bookEJB.createBook(book2);
        System.out.println("###Book 2 created:"+ book2);  
        
        System.out.println("Lista  di tutti i libri");
        
        List<Book> books = bookEJB.findBooks();  
        for (Book aBook : books) {
            System.out.println("---"+ aBook);
        }
        
        System.out.println("Aggiorniamo Book2 (Networks)");
        book2.setTitle("Computer Networks II");
        book2 = bookEJB.updateBook(book2);
        System.out.println("###Book2 updated:"+ book2);  
        
        System.out.println("Cancelliamo Book2 (Networks)");
        
        bookEJB.deleteBook(book2);  
        System.out.println("###Book 2 deleted");    
        
        System.out.println("Lista di tutti i libri dopo la cancellazione di Book2");
        List<Book> booksafter = bookEJB.findBooks();  
        for (Book aBook : booksafter) {
            System.out.println("---"+ aBook);
        }
    }
}

