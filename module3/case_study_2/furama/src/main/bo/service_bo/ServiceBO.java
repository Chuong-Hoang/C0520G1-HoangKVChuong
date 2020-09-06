package main.bo.service_bo;

import main.model.service_model.Service;

import java.sql.SQLException;
import java.util.List;

public interface ServiceBO {
    // sql manipulation
    public void create(Service el) throws SQLException;

    //public Customer findById(int id);
    public Service findById(String id);

    public List<Service> findAll();

    //public boolean delete(int id) throws SQLException;
    public boolean delete(String id) throws SQLException;

    //public boolean update(Service el) throws SQLException;
    public boolean update(String id, Service el) throws SQLException;

    List<Service> findByName(String str);
}
