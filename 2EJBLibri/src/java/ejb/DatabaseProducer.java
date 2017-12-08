package ejb;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class DatabaseProducer {
  @Produces
  @PersistenceContext(unitName="2EJBLibriPU")  
  private EntityManager em;
}
