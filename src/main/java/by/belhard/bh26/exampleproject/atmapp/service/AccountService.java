package by.belhard.bh26.exampleproject.atmapp.service;

import by.belhard.bh26.exampleproject.atmapp.model.Account;

import java.sql.SQLException;

public interface AccountService {

    Account login(String user, String pass);

    int getBalance(Account account) throws SQLException;

    void putMoney(Account account, int amount) throws SQLException;

    void getMoney(Account account, int amount) throws SQLException;
}
