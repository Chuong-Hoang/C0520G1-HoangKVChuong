package vn.codegym.repository;

import org.springframework.stereotype.Repository;
import vn.codegym.model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class CustomerRepositoryImpl implements CustomerRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> query = em.createQuery("select c from Customer c", Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer findById(int id) {
        TypedQuery<Customer> query = em.createQuery("select c from Customer c where  c.id=:id", Customer.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e){
            return null;
        }
    }

    @Override
    public void save(Customer model) {
        if(model.getId() != 0){
            em.merge(model);
        } else {
            em.persist(model);
        }
    }

    @Override
    public void update(int id, Customer el) {
        if(id == el.getId()) {
            em.merge(el);
        }
    }

    @Override
    public void remove(int id) {
        Customer customer = findById(id);
        if(customer != null){
            em.remove(customer);
        }
    }
}
