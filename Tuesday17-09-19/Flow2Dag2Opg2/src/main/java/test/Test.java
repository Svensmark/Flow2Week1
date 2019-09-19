/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.Address;
import entities.Customer;
import facade.Facade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import utils.EMF_Creator;

/**
 *
 * @author emilt
 */
public class Test {


    public static void main(String[] args) {
        Persistence.generateSchema("pu", null);

        Customer c1 = new Customer("Svens12", "Boy12");
        Address a1 = new Address("Vej 1", "ByByen");
        Address a2 = new Address("Gågaden", "I midten");
        c1.addAddress(a1);
        c1.addAddress(a2);
        
        Facade f = new Facade();
        f.addCustomer(c1);
        System.out.println(f.getCustomer(4));
        //Husk at databasen ikke starter forfra med at tælle IDS
        //selvom man sletter alle objekter. Så ændre id'en til
        //et valid tal i databasen.
        f.deleteCustomer(1);
        

    }
}
