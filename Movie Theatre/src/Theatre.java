/**
 * Created by Banty on 30/03/17.
 */
public class Theatre {
    private int showNumber;

    private boolean availableSeatsForShow1[][] = new boolean[3][9];
    private boolean availableSeatsForShow2[][] = new boolean[3][9];
    private boolean availableSeatsForShow3[][] = new boolean[3][9];

    public void setShowNumber(int showNumber) {
        this.showNumber = showNumber;
    }

    public Boolean[][] createSeatsAccordingToShowNumber(int showNumber){
        return SeatingArrangement.initializeSeats(showNumber);
    }

}
