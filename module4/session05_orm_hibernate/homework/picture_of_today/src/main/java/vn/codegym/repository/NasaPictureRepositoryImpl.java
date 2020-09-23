package vn.codegym.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import vn.codegym.model.NasaPicture;

import java.util.List;
@Repository
public class NasaPictureRepositoryImpl implements NasaPictureRepository {
    @Override
    public List<NasaPicture> findAll() {
        Session session = null;
        List<NasaPicture> nasaPictureList = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            nasaPictureList = session.createQuery("FROM NasaPicture").getResultList();

        } finally {
            if (session != null) {
                session.close();
            }
        }
        return nasaPictureList;
    }

    @Override
    public void save(NasaPicture p) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.save(p);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public NasaPicture findById(int id) {
        Session session = null;
        NasaPicture p = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();

            p = session.get(NasaPicture.class, id);

        } finally {
            if (session != null) {
                session.close();
            }
        }
        return p;
    }

    @Override
    public void update(NasaPicture p) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.update(p);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void remove(int id) {
    }
}
