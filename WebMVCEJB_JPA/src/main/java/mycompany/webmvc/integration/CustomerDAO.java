/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycompany.webmvc.integration;

import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.PersistenceUtil;
import javax.persistence.TypedQuery;
import mycompany.webmvc.model.Customer;
import mycompany.webmvc.model.MyOrder;

@Stateless
public class CustomerDAO {

    @PersistenceContext
    EntityManager em;

    public List<Customer> getAll() {
        TypedQuery<Customer> tq
                = em.createNamedQuery("allCustomers", Customer.class);
        return tq.getResultList();
    }

    public Customer get(Long custId) {
        return em.find(Customer.class, custId);
    }

    public void add(Customer item) {
        em.persist(item);
    }

    public void delete(Long custId) {
        em.remove(get(custId));
    }

    public void update(Customer updatedCustomer) {
        em.merge(updatedCustomer);
    }

    public void addOrder(Long custId, String description) {
        Customer c = get(custId);

        MyOrder o = new MyOrder(description, c);
        em.persist(o);
        //  c.getOrders().add(o);        
    }
    private static final Logger LOG = Logger.getLogger(CustomerDAO.class.getName());

}
