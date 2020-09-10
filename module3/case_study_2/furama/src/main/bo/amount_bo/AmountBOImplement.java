package main.bo.amount_bo;

import main.dao.amount_dao.AmountDAOImplement;
import main.model.amount_model.Amount;

import java.util.List;

public class AmountBOImplement implements AmountBO {
    AmountDAOImplement amountDAO = new AmountDAOImplement();
    @Override
    public List<Amount> findAll() {
        return this.amountDAO.findAll();
    }
}
