package by.belhard.bh26.exampleproject.atmapp.service;

import by.belhard.bh26.exampleproject.atmapp.model.Account;

public interface TransactionService {

    void makeTransaction(Account sender, String receiverName, int amount);
}
