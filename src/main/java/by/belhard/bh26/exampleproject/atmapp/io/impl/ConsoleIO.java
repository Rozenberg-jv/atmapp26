package by.belhard.bh26.exampleproject.atmapp.io.impl;

import by.belhard.bh26.exampleproject.atmapp.io.IOInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleIO implements IOInterface {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public String readStringValue() throws IOException {

        return reader.readLine();
    }

    @Override
    public int readIntValue() throws IOException, NumberFormatException {

        return Integer.parseInt(reader.readLine());
    }
}
