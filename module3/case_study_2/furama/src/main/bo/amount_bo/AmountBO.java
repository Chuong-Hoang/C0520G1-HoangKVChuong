package main.bo.amount_bo;

import main.model.amount_model.Amount;

import java.util.List;

public interface AmountBO {
    List<Amount> findAll();
}
