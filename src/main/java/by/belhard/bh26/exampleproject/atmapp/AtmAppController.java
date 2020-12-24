package by.belhard.bh26.exampleproject.atmapp;

import by.belhard.bh26.exampleproject.atmapp.io.impl.ConsoleIO;
import by.belhard.bh26.exampleproject.atmapp.io.IOInterface;
import by.belhard.bh26.exampleproject.atmapp.model.Account;
import by.belhard.bh26.exampleproject.atmapp.service.AccountService;
import by.belhard.bh26.exampleproject.atmapp.service.TransactionService;
import by.belhard.bh26.exampleproject.atmapp.service.impl.AccountServiceImpl;
import by.belhard.bh26.exampleproject.atmapp.service.impl.TransactionServiceImpl;

import java.io.IOException;
import java.sql.SQLException;

public class AtmAppController {

    private final AccountService accountService;
    private final TransactionService transactionService;
    private final IOInterface ioInterface;

    public AtmAppController() {
        this.accountService = new AccountServiceImpl();
        this.transactionService = new TransactionServiceImpl();
        this.ioInterface = new ConsoleIO();
    }

    public void start() {

        // infinite loop
        while (true) {
            /// login loop
            System.out.println("Enter username and password");
            Account account = null;
            while (account == null) {
                try {
                    String username = ioInterface.readStringValue();
                    String password = ioInterface.readStringValue();
                    account = accountService.login(username, password);
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            }

            /// main work loop
            boolean cont = true;
            while (cont) {
                cont = mainProcess(account);
            }
        }
    }

    private boolean mainProcess(Account account) {

        System.out.println(IOInterface.MENU_LEGEND);

        String input = "";
        try {
            input = ioInterface.readStringValue();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        try {
            switch (input) {
                case "1":
                    int balance = accountService.getBalance(account);
                    System.out.println(balance);
                    break;
                case "2":
                    try {
                        int amount = ioInterface.readIntValue();
                        accountService.putMoney(account, amount);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case "3":
                    try {
                        int amount = ioInterface.readIntValue();
                        accountService.getMoney(account, amount);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case "4":
                    try {
                        String receiverName = ioInterface.readStringValue();
                        int amount = ioInterface.readIntValue();
                        transactionService.makeTransaction(account, receiverName, amount);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case "e":
                    return false;
                default:
                    System.err.println("Wrong input");
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }
}
