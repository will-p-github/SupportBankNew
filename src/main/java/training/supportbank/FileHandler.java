package training.supportbank;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static training.supportbank.Main.LOGGER;

public class FileHandler {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
    private static LocalDate DEFAULT_DATE = LocalDate.parse("15/01/1990", formatter);

    public static void readFile(String filepath) throws IOException {

        String row;

        LOGGER.info("initialising Buffered Reader");
        BufferedReader csvReader = new BufferedReader(new FileReader(filepath));

        csvReader.readLine();
        LOGGER.info("Reading line-by-line");

        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            AccountBook.addTransaction(processDataCreateTransaction(data));
        }

        csvReader.close();
    }

    public static Transaction processDataCreateTransaction(String[] transactionData) {

        LocalDate date = DEFAULT_DATE;

        try {
            date = LocalDate.parse(transactionData[0], formatter);
        } catch(DateTimeParseException e1) {
            System.out.println("invalid date entered, using default");
        }

        String reference = transactionData[3];

        try {
            BigDecimal amount = new BigDecimal(transactionData[4]);

            Account from = AccountBook.checkReturnAccount(transactionData[1].toLowerCase());
            Account to = AccountBook.checkReturnAccount(transactionData[2].toLowerCase());

            return new Transaction(date, from, to, reference, amount);

        } catch(NumberFormatException e2) {
            System.out.println("Transaction amount invalid");
            return null;
        }
    }
}
