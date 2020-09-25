package vn.codegym.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import vn.codegym.model.NasaPicture;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class NasaPictureRepositoryImpl implements NasaPictureRepository {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<NasaPicture> findAll() {
        TypedQuery<NasaPicture> query = entityManager.createQuery("SELECT obj FROM NasaPicture obj", NasaPicture.class);
        return query.getResultList();
    }

    @Override
    public NasaPicture findById(int id) {
        TypedQuery<NasaPicture> query = entityManager.createQuery("SELECT obj FROM NasaPicture obj where obj.id =:id", NasaPicture.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void save(NasaPicture obj) {
        if(obj.getId() != 0){
            entityManager.merge(obj);
        } else {
            entityManager.persist(obj);
        }
    }

    @Override
    public void update(NasaPicture obj) {
        entityManager.merge(obj);
    }

    @Override
    public void remove(int id) {
        NasaPicture obj = entityManager.find(NasaPicture.class, id);
        if(obj != null){
            entityManager.remove(obj);
        }
    }
}
