import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Banty on 3/31/2017.
 */
public class TheatreTest {
    Theatre theatre;
    @Before
    public void setUp() throws Exception {
        theatre = new Theatre();
    }

    @Test
    public void shouldPrintSeatingArrangementIfTicketNotAvailable() throws Exception {
        assertFalse(theatre.bookShow(1,new String[]{"B7"}));
    }

    @Test
    public void bookingTicketShouldUpdateArray() throws Exception {
        String[] seats = {"A1"};
        assertTrue(theatre.getShow1().checkIfSeatsAreAvailable(seats));
        theatre.bookShow(1, seats);
        assertFalse(theatre.getShow1().checkIfSeatsAreAvailable(seats));

        String[] seats2 = {"A2","C3"};
        assertTrue(theatre.getShow2().checkIfSeatsAreAvailable(seats));
        theatre.bookShow(2, seats);
        assertFalse(theatre.getShow2().checkIfSeatsAreAvailable(seats));
    }

    @Test
    public void bookedTicketShouldNotBeBookedAgain() throws Exception {
        String[] seats2 = {"A2","C3"};
        assertTrue(theatre.bookShow(2, seats2));
        //trying to book the same ticket again
        assertFalse(theatre.bookShow(2, seats2));


    }
}