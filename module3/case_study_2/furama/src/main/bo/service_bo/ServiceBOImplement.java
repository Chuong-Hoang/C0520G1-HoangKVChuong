package main.bo.service_bo;

import main.dao.service_dao.ServiceDAO;
import main.dao.service_dao.ServiceDAOImplement;
import main.model.service_model.Service;

import java.sql.SQLException;
import java.util.List;

public class ServiceBOImplement implements ServiceBO {
    ServiceDAO serviceDAO = new ServiceDAOImplement();

    @Override
    public void create(Service el) throws SQLException {
        this.serviceDAO.create(el);
    }

    @Override
    public Service findById(String id) {
        return this.serviceDAO.findById(id);
    }

    @Override
    public List<Service> findAll() {
        return this.serviceDAO.findAll();
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return this.serviceDAO.delete(id);
    }

    @Override
    public boolean update(String id, Service el) throws SQLException {
        return this.serviceDAO.update(id, el);
    }

    @Override
    public List<Service> findByName(String str) {
        return this.serviceDAO.findByName(str);
    }

}
