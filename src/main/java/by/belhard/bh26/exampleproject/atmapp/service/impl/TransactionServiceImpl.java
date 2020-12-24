package by.belhard.bh26.exampleproject.atmapp.service.impl;

import by.belhard.bh26.exampleproject.atmapp.exceptions.FeatureNotImplementedYet;
import by.belhard.bh26.exampleproject.atmapp.model.Account;
import by.belhard.bh26.exampleproject.atmapp.service.TransactionService;

public class TransactionServiceImpl implements TransactionService {

    @Override
    public void makeTransaction(Account sender, String receiverName, int amount) {

        throw new FeatureNotImplementedYet();
    }
}
