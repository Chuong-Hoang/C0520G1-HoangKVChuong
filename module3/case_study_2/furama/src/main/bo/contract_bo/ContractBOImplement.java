package main.bo.contract_bo;

import main.bo.contract_bo.ContractBO;
import main.dao.contract_dao.ContractDAO;
import main.dao.contract_dao.ContractDAOImplement;
import main.model.contract_model.Contract;

import java.sql.SQLException;
import java.util.List;

public class ContractBOImplement implements ContractBO {
    ContractDAO contractDAO = new ContractDAOImplement();

    @Override
    public void create(Contract el) throws SQLException {
        this.contractDAO.create(el);
    }

    @Override
    public Contract findById(String id) {
        return this.contractDAO.findById(id);
    }

    @Override
    public List<Contract> findAll() {
        return this.contractDAO.findAll();
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return this.contractDAO.delete(id);
    }

    @Override
    public boolean update(String id, Contract el) throws SQLException {
        return this.contractDAO.update(id, el);
    }

    @Override
    public List<Contract> findByDate(String str) {
        return this.contractDAO.findByDate(str);
    }

}
