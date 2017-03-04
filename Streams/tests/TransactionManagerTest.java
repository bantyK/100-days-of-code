import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Banty on 3/4/2017.
 */
public class TransactionManagerTest {
    private TransactionManager transactionManager;
    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");
    List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    @Before
    public void setUp() throws Exception {
        transactionManager = new TransactionManager(transactions);
    }

    @Test
    public void testGetTransactionsin2011SortedByValue() throws Exception {
        List<Transaction> result = transactionManager.get2011TransactionsSortedByValue();

        assertEquals(2,result.size());
        assertEquals(300,result.get(0).getValue());
        assertEquals(400,result.get(1).getValue());
    }
}