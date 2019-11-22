package training.supportbank;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transaction {

    private LocalDate date;
    private Account from, to;
    private String reference;
    private BigDecimal amount;

    public Transaction(LocalDate date, Account from, Account to, String reference, BigDecimal amount) {
        this.date = date;
        this.from = from;
        this.to = to;
        this.reference = reference;
        this.amount = amount;

        from.processTransaction(this);
        to.processTransaction(this);
    }

    public Account getFrom() {
        return from;
    }

    public Account getTo() {
        return to;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
