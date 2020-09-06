package main.bo.contract_detail_bo;

import main.bo.contract_detail_bo.ContractDetailBO;
import main.dao.contract_detail_dao.ContractDetailDAO;
import main.dao.contract_detail_dao.ContractDetailDAOImplement;
import main.model.contract_detail_model.ContractDetail;

import java.sql.SQLException;
import java.util.List;

public class ContractDetailBOImplement implements ContractDetailBO {
    ContractDetailDAO contractDetailDAO = new ContractDetailDAOImplement();

    @Override
    public void create(ContractDetail el) throws SQLException {
        this.contractDetailDAO.create(el);
    }

    @Override
    public ContractDetail findById(String id) {
        return this.contractDetailDAO.findById(id);
    }

    @Override
    public List<ContractDetail> findAll() {
        return this.contractDetailDAO.findAll();
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return this.contractDetailDAO.delete(id);
    }

    @Override
    public boolean update(String id, ContractDetail el) throws SQLException {
        return this.contractDetailDAO.update(id, el);
    }

    @Override
    public List<ContractDetail> findByContractId(String str) {
        return this.contractDetailDAO.findByContractId(str);
    }

}
