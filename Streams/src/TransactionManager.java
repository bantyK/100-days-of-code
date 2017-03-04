import java.util.List;
import java.util.stream.Collectors;

public class TransactionManager {
    private final List<Transaction> transactions;
    private final List<Trader> traders;
    public TransactionManager(List<Transaction> transactions,List<Trader> traders) {
        this.transactions = transactions;
        this.traders = traders;
    }

    public List<Transaction> get2011TransactionsSortedByValue() {
        return transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted((t1,t2) -> Integer.compare(t1.getValue(),t2.getValue()))
                .collect(Collectors.toList());
    }


}
