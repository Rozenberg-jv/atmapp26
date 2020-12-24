package by.belhard.bh26.exampleproject.atmapp.service.impl;

import by.belhard.bh26.exampleproject.atmapp.model.Account;
import by.belhard.bh26.exampleproject.atmapp.repository.AccountRepository;
import by.belhard.bh26.exampleproject.atmapp.repository.impl.AccountRepositoryImpl;
import by.belhard.bh26.exampleproject.atmapp.service.AccountService;

import java.sql.SQLException;

public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl() {

        accountRepository = new AccountRepositoryImpl();
    }

    @Override
    public Account login(String user, String pass) {

        Account account = null;

        try {
            account = accountRepository.getByName(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (account != null && account.getPassword().equals(pass)) {
            return account;
        }

        return account;
    }

    @Override
    public int getBalance(Account account) throws SQLException {

        return accountRepository.getBalance(account.getUsername());
    }

    @Override
    public void putMoney(Account account, int amount) throws SQLException {
        // check if amount > 0

        int newValue = account.getMoney() + amount;
        account.setMoney(newValue);

        accountRepository.updateMoney(account.getUsername(), newValue);
    }

    @Override
    public void getMoney(Account account, int amount) throws SQLException {
        // check if account has enough money

        int newValue = account.getMoney() - amount;
        account.setMoney(newValue);

        accountRepository.updateMoney(account.getUsername(), newValue);
    }
}
