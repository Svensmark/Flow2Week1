/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Customer;
import java.util.List;

/**
 *
 * @author emilt
 */
public interface FacadeInterface {

    public Customer getCustomer(int id);

    public List<Customer> getCustomers();

    public Customer addCustomer(Customer cust);

    public Customer deleteCustomer(int id);

    public Customer editCustomer(Customer cust);

}
