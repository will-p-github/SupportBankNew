package training.supportbank;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Main {

    public static final Logger LOGGER = LogManager.getLogger();

    public static void main(String args[]) throws IOException {

        LOGGER.info("Program Starting Up.");
        FileHandler.readFile("DodgyTransactions2015.csv");
        LOGGER.info("File Loaded Successfully, Waiting for User Input.");
        UserInput.waitForInput();

    }

}
