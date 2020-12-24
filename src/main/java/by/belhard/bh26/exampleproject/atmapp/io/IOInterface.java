package by.belhard.bh26.exampleproject.atmapp.io;

import java.io.IOException;

public interface IOInterface {

    String MENU_LEGEND =
            "\t1. balance\n" +
                    "\t2. put money\n" +
                    "\t3. get money\n" +
                    "\t4. make transaction\n" +
                    "\te. exit\n";

    String readStringValue() throws IOException;

    int readIntValue() throws IOException, NumberFormatException;
}
