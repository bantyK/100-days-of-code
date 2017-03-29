import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Banty on 30/03/17.
 */
public class TheatreTest {
    Theatre theatre;

    @Before
    public void setUp() throws Exception {
        theatre = new Theatre();
    }

    @Test
    public void shouldReturnCorrectSeatingArrangementAccordingToShowNumber() throws Exception {
        theatre.setShowNumber(1);
        Boolean[][] seats1 = theatre.createSeatsAccordingToShowNumber(1);
        assertEquals(3,seats1.length);

        assertTrue(seats1[0][1]);
        assertFalse(seats1[1][6]);
        assertFalse(seats1[1][8]);

        Boolean[][] seats2 = theatre.createSeatsAccordingToShowNumber(2);
        assertTrue(seats2[1][5]);
        assertFalse(seats2[1][8]);
        assertFalse(seats2[1][0]);
        assertFalse(seats2[2][8]);


        Boolean[][] seats3 = theatre.createSeatsAccordingToShowNumber(3);
        assertFalse(seats3[0][5]);
        assertFalse(seats3[1][8]);
        assertTrue(seats3[2][8]);
    }

    @Test
    public void shouldReturnNullWhenSeatNumberisInvalid() throws Exception {
        assertNull(theatre.createSeatsAccordingToShowNumber(0));
        assertNull(theatre.createSeatsAccordingToShowNumber(4));
        assertNotNull(theatre.createSeatsAccordingToShowNumber(1));
        assertNotNull(theatre.createSeatsAccordingToShowNumber(2));
        assertNotNull(theatre.createSeatsAccordingToShowNumber(3));

    }
}