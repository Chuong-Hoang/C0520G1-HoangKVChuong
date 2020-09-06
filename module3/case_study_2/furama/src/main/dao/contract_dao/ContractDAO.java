package main.dao.contract_dao;

import main.model.contract_model.Contract;
import java.sql.SQLException;
import java.util.List;

public interface ContractDAO {

    public void create(Contract el) throws SQLException;

    //public Customer findById(int id);
    public Contract findById(String id);

    public List<Contract> findAll();

    public boolean delete(String id) throws SQLException;
    //public boolean delete(int id) throws SQLException;

    //public boolean update(Contract el) throws SQLException;
    public boolean update(String id, Contract el) throws SQLException;

    List<Contract> findByDate(String str);

}
