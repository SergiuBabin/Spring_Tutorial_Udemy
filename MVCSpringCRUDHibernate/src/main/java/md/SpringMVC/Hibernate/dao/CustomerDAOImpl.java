package md.SpringMVC.Hibernate.dao;


import md.SpringMVC.Hibernate.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Babin Sergiu
 */
@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers(String sortBy) {
        Session currentSession = sessionFactory.getCurrentSession();

        if (sortBy == null) sortBy = "lastName";

        Query<Customer> theQuery = currentSession.createQuery("from Customer order by " + sortBy, Customer.class);

        List<Customer> customers = theQuery.getResultList();

        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(int id) {
        Session currentSession = sessionFactory.getCurrentSession();

        Customer customer = currentSession.get(Customer.class, id);

        return customer;
    }

    @Override
    public void deleteCustomer(int id) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query query = currentSession.createQuery("delete from Customer where id=:id");

        query.setParameter("id", id);

        query.executeUpdate();
    }

    @Override
    public List<Customer> searchCustomers(String name) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Customer> query = currentSession.createQuery("from Customer where lower(firstName)=lower(:name)", Customer.class);

        query.setParameter("name", name);

        return query.getResultList();
    }


}
