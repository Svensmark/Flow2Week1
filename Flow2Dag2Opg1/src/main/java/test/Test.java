/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.Customer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import utils.EMF_Creator;

/**
 *
 * @author emilt
 */
public class Test {
    
    private static EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory(
                "pu",
                "jdbc:mysql://localhost:3307/startcode",
                "dev",
                "ax2",
                EMF_Creator.Strategy.DROP_AND_CREATE);
    
    public static void main(String[] args) {
        
        EntityManager em = emf.createEntityManager();
        
        Customer c1 = new Customer("Pewdie","Pie");
        
        c1.addHobby("Tjene mange penge");
        c1.addHobby("Genopleve døde spil");
        
        c1.addPhone("223344", "This was the first no added");
        c1.addPhone("123456", "This was the second no added");
        
        em.getTransaction().begin();
        em.persist(c1);
        em.getTransaction().commit();
        em.close();
        
    }
    
    
}
