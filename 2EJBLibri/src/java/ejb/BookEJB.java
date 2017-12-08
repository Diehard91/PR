/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@LocalBean

public class BookEJB implements BookEJBRemote {
    @Inject
    private EntityManager em;
    
    public List<Book> findBooks() {
        TypedQuery<Book> query = em.createNamedQuery("findAllBooks", Book.class);
        return query.getResultList();
    }
    public Book findBookH2G2() {
        TypedQuery<Book> query = em.createNamedQuery("findBookH2G2", Book.class);
        return query.getSingleResult();
    
    }
    
    public Book findBooByID(String id) {
        TypedQuery<Book> query = em.createNamedQuery("findBookById", Book.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    
    }
   
    public Book findBook(String title, Long id) {
        Query query = em.createQuery("SELECT b FROM Book b WHERE b.title=?1 and b.id=?2");
        query.setParameter(1, title);
        query.setParameter(2, id);
        return (Book) query.getSingleResult();
    }
    
    public Book updateBook(Book book) {
        return em.merge(book);
    }
    
    
    public Book createBook(Book book) {
        em.persist(book);
        return book;
    }

    public void deleteBook(Book book) {
        em.remove(em.merge(book));
    }

    public List<Book> findByTitle(String title) {
        Query query = em.createQuery("SELECT b FROM Book b WHERE b.title=?1");
        query.setParameter(1, title);
        return query.getResultList();
    }

    public List<Book> findByCategory(String category) {
       Query query = em.createQuery("SELECT b FROM Book b WHERE b.description=?1");
       query.setParameter(1, category);
       return query.getResultList();
    }

    public List<Book> findByISBN(String isbn) {
        Query query = em.createQuery("SELECT b FROM Book b WHERE b.isbn=?1");
        query.setParameter(1, isbn);
        return query.getResultList();
    }

}
