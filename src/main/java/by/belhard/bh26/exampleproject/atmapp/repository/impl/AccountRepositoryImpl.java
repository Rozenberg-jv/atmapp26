package by.belhard.bh26.exampleproject.atmapp.repository.impl;

import by.belhard.bh26.exampleproject.atmapp.model.Account;
import by.belhard.bh26.exampleproject.atmapp.repository.AccountRepository;
import by.belhard.bh26.exampleproject.atmapp.repository.ConnectionImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRepositoryImpl implements AccountRepository {

    private static final String GET_BY_NAME_QUERY =
            "select * from accounts where username = ?";
    private static final String GET_BALANCE_BY_NAME_QUERY =
            "select money from accounts where username = ?";
    private static final String UPDATE_BALANCE_BY_NAME_QUERY =
            "update accounts set money = ? where username = ?";

    @Override
    public Account getByName(String name) throws SQLException {

        Connection connection = ConnectionImpl.getConnection();
        PreparedStatement statement = connection.prepareStatement(GET_BY_NAME_QUERY);
        statement.setString(1, name);

        ResultSet resultSet = statement.executeQuery();
        if (!resultSet.next())
            throw new SQLException("No such account");

        int id = resultSet.getInt("id");
        String username = resultSet.getString("username");
        String password = resultSet.getString("password");
        int money = resultSet.getInt("money");

        return Account.builder().id(id).username(username).password(password).money(money).build();
    }

    @Override
    public int getBalance(String name) throws SQLException {

        Connection connection = ConnectionImpl.getConnection();
        PreparedStatement statement = connection.prepareStatement(GET_BALANCE_BY_NAME_QUERY);
        statement.setString(1, name);

        ResultSet resultSet = statement.executeQuery();

        resultSet.next();

        return resultSet.getInt("money");
    }

    @Override
    public void updateMoney(String name, int amount) throws SQLException {

        Connection connection = ConnectionImpl.getConnection();
        PreparedStatement statement = connection.prepareStatement(UPDATE_BALANCE_BY_NAME_QUERY);
        statement.setInt(1, amount);
        statement.setString(2, name);

        statement.executeUpdate();
    }

}
