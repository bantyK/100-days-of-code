/**
 * Created by Banty on 30/03/17.
 */
public class Show {

    private int showNumber;

    private Boolean availableSeatsForShow[][];

    public Show(int showNumber) {
        this.showNumber = showNumber;
        availableSeatsForShow = createSeatsAccordingToShowNumber();
    }

    public Boolean[][] getAvailableSeatsForShow() {
        return availableSeatsForShow;
    }

    public Boolean[][] createSeatsAccordingToShowNumber() {
        return SeatingArrangement.initializeSeats(showNumber);
    }

    public void getTicketCost(){

    }
}
