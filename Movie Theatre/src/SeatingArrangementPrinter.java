/**
 * Created by Banty on 30/03/17.
 */
public class SeatingArrangementPrinter {
    String[] prefixBeforeSeatNumber = {"A", "B", "C"};

       public String printSeatingArrangement(Boolean[][] seats) {
        String seatingArrangement = "";
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 9; column++) {
                if (seats[row][column])
                    seatingArrangement += prefixBeforeSeatNumber[row] + (column + 1) + " ";
                else
                    seatingArrangement += "   ";
            }
            seatingArrangement += "\n";
        }
        return seatingArrangement;
    }
}
