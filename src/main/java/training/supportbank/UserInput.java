package training.supportbank;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInput {

    private static Pattern userCommandPattern = Pattern.compile("List \\[?([^\\]]*)\\]?$");
    private static Scanner scanner = new Scanner(System.in);


    public static void waitForInput() {

        while (true) {

            System.out.print("$");
            String userCommand = scanner.nextLine();

            UserInput.parseInput(userCommand);

        }
    }

    public static void parseInput(String userCommand) {

        if (userCommand.equals("")) {
            System.out.print("");
        } else {

            Matcher matcher = userCommandPattern.matcher(userCommand);

            if (matcher.find()) {

                String accountRequest = matcher.group(1);

                if (accountRequest.equals("All")) {
                    AccountBook.listAllAccounts();
                } else {
                    AccountBook.printAccount(accountRequest.toLowerCase());
                }

            } else {
                System.out.println("Invalid command");
            }
        }
    }
}
