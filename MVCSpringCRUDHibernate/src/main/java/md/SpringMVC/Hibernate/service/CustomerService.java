package md.SpringMVC.Hibernate.service;


import md.SpringMVC.Hibernate.entity.Customer;

import java.util.List;

/**
 * @author Babin Sergiu
 */

public interface CustomerService {

    public List<Customer> getCustomers(String sortBy);

    public void saveCustomer(Customer customer);

    public Customer getCustomer(int id);

    public void deleteCustomer(int id);

    public List<Customer> searchCustomers(String name);
}
