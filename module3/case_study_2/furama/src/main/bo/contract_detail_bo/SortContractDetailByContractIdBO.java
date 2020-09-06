package main.bo.contract_detail_bo;

import main.model.contract_detail_model.ContractDetail;

import java.util.Comparator;

public class SortContractDetailByContractIdBO implements Comparator<ContractDetail> {

    @Override
    public int compare(ContractDetail o1, ContractDetail o2) {
        return Integer.parseInt(o1.getContractId()) - Integer.parseInt(o2.getContractId());
    }
}
