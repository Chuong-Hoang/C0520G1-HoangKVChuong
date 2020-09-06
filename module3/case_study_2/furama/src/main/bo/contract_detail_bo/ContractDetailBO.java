package main.bo.contract_detail_bo;

import main.model.contract_detail_model.ContractDetail;

import java.sql.SQLException;
import java.util.List;

public interface ContractDetailBO {
    // sql manipulation
    public void create(ContractDetail el) throws SQLException;

    //public Customer findById(int id);
    public ContractDetail findById(String id);

    public List<ContractDetail> findAll();

    //public boolean delete(int id) throws SQLException;
    public boolean delete(String id) throws SQLException;

    //public boolean update(ContractDetail el) throws SQLException;
    public boolean update(String id, ContractDetail el) throws SQLException;

    List<ContractDetail> findByContractId(String str);
}
