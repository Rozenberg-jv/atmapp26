package by.belhard.bh26.exampleproject.atmapp.repository;

import by.belhard.bh26.exampleproject.atmapp.model.Account;

import java.sql.SQLException;

public interface AccountRepository {

    Account getByName(String username) throws SQLException;

    int getBalance(String username) throws SQLException;

    void updateMoney(String username, int amount) throws SQLException;

}
