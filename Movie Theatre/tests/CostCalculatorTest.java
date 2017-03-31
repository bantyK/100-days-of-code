import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Banty on 30/03/17.
 */
public class CostCalculatorTest {
    private CostCalculator costCalculator;

    @Before
    public void setUp() throws Exception {
        costCalculator = new CostCalculator();
    }

    @Test
    public void shouldReturnCorrectRowNumber() throws Exception {
        int row1 = costCalculator.getRowFromSeatNumber("A1");
        int row2 = costCalculator.getRowFromSeatNumber("B1");
        int row3 = costCalculator.getRowFromSeatNumber("C1");

        assertEquals(0,row1);
        assertEquals(1,row2);
        assertEquals(2,row3);
    }
}