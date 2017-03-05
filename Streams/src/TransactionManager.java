import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionManager {
    private final List<Transaction> transactions;

    public TransactionManager(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<Transaction> get2011TransactionsSortedByValue() {
        return transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted((t1, t2) -> Integer.compare(t1.getValue(),t2.getValue()))
                .collect(Collectors.toList());
    }


    public List<String> getUniqueCitiesOfTraders() {
        return transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Trader> getAllTradersFromCambridgeSortedByName() {
        return transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
    }

    public String getAllDistinctTradersNameAsAStringSortedAlphabeticallly() {
        return transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1 + n2)
                .toString();

    }

    public boolean isTraderFromCity(String cityName) {
        return transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals(cityName));
    }

    public void printTransactionsFromTraderOfCity(String cityName) {
        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals(cityName))
                .forEach(System.out::println);

    }

    public String printTransactionsValuesFromTraderOfCity(String cityName) {
        return transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals(cityName))
                .map(transaction -> transaction.getValue())
                .map(String::valueOf)
                .reduce("", (v1, v2) -> v1 + v2);
    }

    public int getSumOfValuesOfTransactionsOfTradersFromACity(String cityName) {
        return transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals(cityName))
                .map(Transaction::getValue)
                .reduce(0, (total, value) -> total + value);
    }

    public int getHighestTransactionValue() {
        return transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max)
                .get();

        //method 2

//        return transactions.stream()
//                .map(Transaction::getValue)
//                .sorted((v1,v2) -> Integer.compare(v2,v1))
//                .findFirst()
//                .get();
    }

    public int getLowestTransactionValue() {
        return transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::min)
                .get();
    }
}
