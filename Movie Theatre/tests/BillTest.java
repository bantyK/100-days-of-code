import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Banty on 4/1/2017.
 */
public class BillTest {
    Bill bill;
    Show show1;
    Show show2;
    Show show3;
    @Before
    public void setUp() throws Exception {
        show1 = new Show(1);
        show2 = new Show(2);
        show3 = new Show(3);

    }

    @Test
    public void shouldReturnCorrectBaseTicketCostAccordingToRowNumber() throws Exception {
        bill = new Bill(show1);
        assertEquals(280.0,bill.calculateBaseCost("B1"));
        assertEquals(600.0,bill.calculateBaseCost("A1"));
    }
}