import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Banty on 30/03/17.
 */
public class ShowTest {
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
    public void shouldReturnCorrectSeatingArrangementAccordingToShowNumber() throws Exception {
        Boolean[][] seats1 = show1.getAvailableSeatsForShow();
        assertEquals(3, seats1.length);

        assertTrue(seats1[0][1]);
        assertFalse(seats1[1][6]);
        assertFalse(seats1[1][8]);

        Boolean[][] seats2 = show2.getAvailableSeatsForShow();
        assertTrue(seats2[1][5]);
        assertFalse(seats2[1][8]);
        assertFalse(seats2[1][0]);
        assertFalse(seats2[2][8]);


        Boolean[][] seats3 = show3.getAvailableSeatsForShow();
        assertFalse(seats3[0][5]);
        assertFalse(seats3[1][8]);
        assertTrue(seats3[2][8]);
    }

    @Test
    public void shouldReturnNullWhenSeatNumberisInvalid() throws Exception {
        Show show4 = new Show(4);
        assertNull(show4.getAvailableSeatsForShow());
        assertNotNull(show1.getAvailableSeatsForShow());
        assertNotNull(show2.getAvailableSeatsForShow());
        assertNotNull(show3.getAvailableSeatsForShow());

    }

    @Test
    public void testCheckIfSeatsAreAvailable() throws Exception {
        assertFalse(show1.checkIfSeatsAreAvailable(new String[]{"B7"}));
        assertTrue(show1.checkIfSeatsAreAvailable(new String[]{"B6","C2"}));
        assertFalse(show1.checkIfSeatsAreAvailable(new String[]{"B6","B7"}));
        assertFalse(show3.checkIfSeatsAreAvailable(new String[]{"A6","C9"}));
    }

    @Test
    public void shouldReturnCorrectRowNumber() throws Exception {
        int row1 = show1.getRowFromSeatNumber("A1");
        int row2 = show2.getRowFromSeatNumber("B1");
        int row3 = show3.getRowFromSeatNumber("C1");

        assertEquals(0,row1);
        assertEquals(1,row2);
        assertEquals(2,row3);
    }

    @Test
    public void shouldReturnCorrectColumnNumber() throws Exception {
        int column = show1.getColumnFromSeatNumber("B1");

        assertEquals(0,column);

    }
}