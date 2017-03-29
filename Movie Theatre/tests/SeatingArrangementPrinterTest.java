import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Banty on 30/03/17.
 */
public class SeatingArrangementPrinterTest {

    private SeatingArrangementPrinter printer;
    private Theatre theatre;

    @Before
    public void setUp() throws Exception {
        printer = new SeatingArrangementPrinter();
        theatre = new Theatre();
    }

    @Test
    public void shouldPrintCorrectSeatingArrangement() throws Exception {
        Boolean[][] seats = theatre.createSeatsAccordingToShowNumber(1);
        System.out.println(printer.printSeatingArrangement(seats));

        seats = theatre.createSeatsAccordingToShowNumber(2);
        System.out.println(printer.printSeatingArrangement(seats));

        seats = theatre.createSeatsAccordingToShowNumber(3);
        System.out.println(printer.printSeatingArrangement(seats));
    }
}