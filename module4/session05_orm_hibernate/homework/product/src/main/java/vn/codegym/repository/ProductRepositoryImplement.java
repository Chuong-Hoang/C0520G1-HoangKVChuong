package vn.codegym.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import vn.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryImplement implements ProductRepository {
    @Override
    public List<Product> findAll() {
        Session session = null;
        List<Product> eList = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            eList = session.createQuery("FROM Product").getResultList();
        } finally {
            if(session != null){
                session.close();
            }
        }
        return eList;
    }

    @Override
    public Product findById(String id) {
        Session session = null;
        Product el = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            el = session.get(Product.class, id);
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return el;
    }

    @Override
    public void save(Product el) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.save(el);

            transaction.commit();
        } catch (Exception e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        } finally {
            if(session != null) {
                session.close();
            }
        }
    }

    @Override
    public void update(String id, Product el) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.update(el);

            transaction.commit();
        } catch (Exception e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        } finally {
            if(session != null){
                session.close();
            }
        }
    }

    @Override
    public void remove(String id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
//            session.delete(findById(id));
            session.remove(findById(id));

            transaction.commit();
        } catch (Exception e){
            e.printStackTrace();
            if(transaction != null) {
                transaction.rollback();
            }
        } finally {
            if(session != null){
                session.close();
            }
        }
    }
}
