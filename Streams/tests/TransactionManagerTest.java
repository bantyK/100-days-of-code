import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Banty on 3/4/2017.
 */
public class TransactionManagerTest {
    private TransactionManager transactionManager;
    private List<Transaction> transactions = new ArrayList<>();

    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");

    Transaction t1 = new Transaction(brian, 2011, 300);
    Transaction t2 = new Transaction(raoul, 2012, 1000);
    Transaction t3 = new Transaction(raoul, 2011, 400);
    Transaction t4 = new Transaction(mario, 2012, 710);
    Transaction t5 = new Transaction(mario, 2012, 700);
    Transaction t6 = new Transaction(alan, 2012, 950);


    @Before
    public void setUp() throws Exception {

        transactions.add(t1);
        transactions.add(t2);
        transactions.add(t3);
        transactions.add(t4);
        transactions.add(t5);
        transactions.add(t6);
        transactionManager = new TransactionManager(transactions);
    }

    @Test
    public void testGetTransactionsin2011SortedByValue() throws Exception {
        List<Transaction> result = transactionManager.get2011TransactionsSortedByValue();

        assertEquals(2, result.size());
        assertEquals(300, result.get(0).getValue());
        assertEquals(400, result.get(1).getValue());
    }

    @Test
    public void testGetUniqueCitiesOfTraders() throws Exception {
        List<String> resultList = transactionManager.getUniqueCitiesOfTraders();
        assertEquals(2, resultList.size());
        assertEquals("Cambridge", resultList.get(0));
        assertEquals("Milan", resultList.get(1));
    }

    @Test
    public void testGetAllTradersFromCambridgeSortedByName() throws Exception {
        List<Trader> resultList = transactionManager.getAllTradersFromCambridgeSortedByName();

        assertEquals(3, resultList.size());
        assertEquals("Alan", resultList.get(0).getName());
        assertEquals("Brian", resultList.get(1).getName());
        assertEquals("Raoul", resultList.get(2).getName());
    }

    @Test
    public void testGetAllDistinctTradersNameAsAStringSortedAlphabeticallly() throws Exception {
        String tradersName = transactionManager.getAllDistinctTradersNameAsAStringSortedAlphabeticallly();
        assertEquals("AlanBrianMarioRaoul", tradersName);

    }

    @Test
    public void testCheckTradersFromCity() throws Exception {
        boolean isTraderFromMilan = transactionManager.isTraderFromCity("Milan");
        assertTrue(isTraderFromMilan);
        boolean isTraderFromPune = transactionManager.isTraderFromCity("Pune");
        assertFalse(isTraderFromPune);
    }

    @Test
    public void testPrintTransactionFromTradersFromACity() throws Exception {
        //this is not a test..we will just print the transactions from a trader based on city name
        transactionManager.printTransactionsFromTraderOfCity("Cambridge");

    }

    @Test
    public void testPrintTransactionValuesFromTradersFromACity() throws Exception {
        String transactionValuesConcatenated =
                transactionManager.printTransactionsValuesFromTraderOfCity("Cambridge");

        assertEquals("3001000400950", transactionValuesConcatenated);
    }

    @Test
    public void testGetSumOfValuesOfTransactionsOfTradersFromACity() throws Exception {
        int totalValueFromCambridge =
                transactionManager.getSumOfValuesOfTransactionsOfTradersFromACity("Cambridge");
        assertEquals(300 + 1000 + 400 + 950, totalValueFromCambridge);

    }

    @Test
    public void testGetHighestTransactionValue() throws Exception {
        int highestTransactinValue = transactionManager.getHighestTransactionValue();

        assertEquals(1000, highestTransactinValue);

    }

    @Test
    public void testGetLowestTransactionValue() throws Exception {
        int highestTransactinValue = transactionManager.getLowestTransactionValue();

        assertEquals(300, highestTransactinValue);

    }
}