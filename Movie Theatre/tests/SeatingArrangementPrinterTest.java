import org.junit.Before;
import org.junit.Test;

/**
 * Created by Banty on 30/03/17.
 */
public class SeatingArrangementPrinterTest {

    private SeatingArrangementPrinter printer;
    private Show show;

    @Before
    public void setUp() throws Exception {
        printer = new SeatingArrangementPrinter();
        show = new Show(1);
    }

    @Test
    public void shouldPrintCorrectSeatingArrangement() throws Exception {
        Boolean[][] seats = show.getAvailableSeatsForShow();
        System.out.println(printer.returnSeatingArrangement(seats));

        seats = show.getAvailableSeatsForShow();;
        System.out.println(printer.returnSeatingArrangement(seats));

        seats = show.getAvailableSeatsForShow();
        System.out.println(printer.returnSeatingArrangement(seats));
    }
}