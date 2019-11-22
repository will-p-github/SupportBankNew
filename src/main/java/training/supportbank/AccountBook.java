package training.supportbank;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;

public class AccountBook {

    private static HashMap<String, Account> accounts = new HashMap<String, Account>();
    private static LinkedList<Transaction> transactions = new LinkedList<Transaction>();

    public static void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public static Account checkReturnAccount(String name) {
        if (accounts.containsKey(name)) {
            return accounts.get(name);
        } else {
            Account newAccount = new Account(name, new BigDecimal(0));
            accounts.put(name, newAccount);
            return newAccount;
        }
    }

    public static void printAccount(String name) {
        if (accounts.containsKey(name)) {
            System.out.println(name + " £" + accounts.get(name).getBalance());
        } else {
            System.out.println("Account does not exist!");
        }
    }

    public static void listAllAccounts() {
        accounts.entrySet().stream().forEach(entry->printAccount(entry.getKey()));
    }
}
