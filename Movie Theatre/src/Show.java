/**
 * Created by Banty on 30/03/17.
 */
public class Show {

    private int showNumber;
    private SeatingArrangementPrinter printer = new SeatingArrangementPrinter();
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

    public boolean checkIfSeatsAreAvailable(String[] seats) {
        for(String seat : seats){
            int row = getRowFromSeatNumber(seat);
            int column = getColumnFromSeatNumber(seat);

            if(!getAvailableSeatsForShow()[row][column]){
                return false;
            }
        }
        return true;
    }

    public int getColumnFromSeatNumber(String seat) {
        return Integer.parseInt(String.valueOf(seat.charAt(1))) - 1;
    }

    public int getRowFromSeatNumber(String seatNumber) {
        char firstCharacter = seatNumber.charAt(0);
        if (firstCharacter == 'A') {
            return 0;
        } else if (firstCharacter == 'B') {
            return 1;
        } else {
            return 2;
        }
    }

    public void printSeatingArrangement(){
        System.out.println(
                printer.returnSeatingArrangement(availableSeatsForShow));
    }

    public void bookTicket(String[] seats) {
        for(String seat : seats){
            int row = getRowFromSeatNumber(seat);
            int column = getColumnFromSeatNumber(seat);
            getAvailableSeatsForShow()[row][column] = false;
        }
    }
}
