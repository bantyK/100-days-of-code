import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Banty on 3/4/2017.
 */
public class ReduceOperationsTest {
    public static final List<Integer> NUMBERS = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    ReduceOperations reduceOperations;

    @Before
    public void setUp() throws Exception {
        reduceOperations = new ReduceOperations();
    }

    @Test
    public void testAddUsingReduce() throws Exception {
        int sum = reduceOperations.addUsingReduce(NUMBERS);
        assertEquals(55,sum);
    }

    @Test
    public void testAddOnlyEvenNumbers() throws Exception {
        int evenNumberSum = reduceOperations.getEvenNumberSum(NUMBERS);
        assertEquals(30,evenNumberSum);
    }

    @Test
    public void testGetMaximumNumber() throws Exception {
        int max = reduceOperations.getMaximum(NUMBERS);
        assertEquals(10,max);

    }
}