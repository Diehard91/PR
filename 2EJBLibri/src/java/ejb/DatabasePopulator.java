/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.annotation.*;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Singleton
@Startup

@DataSourceDefinition(
    className ="org.apache.derby.jdbc.EmbeddedDataSource",  
    name ="java:global/jdbc/EJBLibriDS",
    user ="Michele",
    password ="michele",  
    databaseName ="LibriDB",
    properties = {"connectionAttributes=;create=true"}
)

public class DatabasePopulator {
    @Inject
    private BookEJB bookEJB;
 
    private Book h2g2, lord;
    @PostConstruct
    private void populateDB(){
        h2g2 = new Book("Beginning java ee7", 35F, "GreatBook","1-4324-43", 605,true);
        lord = new Book("Signore degli anelli", 50.4F,"Fantasy","1-4342-221", 1216,true);
        bookEJB.createBook(h2g2);
        bookEJB.createBook(lord);
    }
    
    @PreDestroy
    private void clearDB(){
        bookEJB.deleteBook(h2g2);
        bookEJB.deleteBook(lord);
    }
       
}
