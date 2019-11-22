package training.supportbank;

import java.math.BigDecimal;
import java.util.LinkedList;

public class Account {

    private String name;
    private BigDecimal balance;
    private LinkedList<Transaction> transactions = new LinkedList<Transaction>();

    public Account(String name, BigDecimal initialBalance) {
        this.balance = initialBalance;
        this.name = name;
    }

    public void processTransaction(Transaction transaction) {
        this.transactions.add(transaction);
        if (transaction.getFrom().equals(this)) {
            this.balance = this.balance.subtract(transaction.getAmount());
        } else if (transaction.getTo().equals(this)) {
            this.balance = this.balance.add(transaction.getAmount());
        }
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
