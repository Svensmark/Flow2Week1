/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import utils.EMF_Creator;

/**
 *
 * @author emilt
 */
public class Facade implements FacadeInterface {

    private static Facade instance;
    private static EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory(
            "pu",
            "jdbc:mysql://localhost:3307/startcode",
            "dev",
            "ax2",
            EMF_Creator.Strategy.CREATE);
    
    public Facade() {
        
    }

    public static Facade getMemberFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new Facade();
        }
        return instance;
    }
    
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    
    @Override
    public Customer getCustomer(int id) {
        return getEntityManager().find(Customer.class, id);
    }

    @Override
    public List<Customer> getCustomers() {
        EntityManager em = getEntityManager();
        try {
            return em.createNamedQuery("Customer.findAll")
                    .getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public Customer addCustomer(Customer cust) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(cust);
        em.getTransaction().commit();
        return cust;
    }

    @Override
    public Customer deleteCustomer(int id) {
        EntityManager em = getEntityManager();
        Customer c1 = em.merge(em.find(Customer.class, id));
        em.remove(c1);
        return c1;
    }

    @Override
    public Customer editCustomer(Customer cust) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
