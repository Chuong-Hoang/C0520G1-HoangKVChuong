package main.dao.amount_dao;

import main.model.amount_model.Amount;
import java.util.List;

public interface AmountDAO {
    List<Amount> findAll();
}
