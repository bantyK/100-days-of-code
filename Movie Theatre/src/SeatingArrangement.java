import org.jetbrains.annotations.Nullable;

/**
 * Created by Banty on 30/03/17.
 */
public class SeatingArrangement {

    public static Boolean[][] initializeSeats(int showNumber) {
        Boolean[][] seats = new Boolean[3][9];

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 9; column++) {
                seats[row][column] = true;
            }
        }

        if (showNumber == 1) {
            seats[1][6] = seats[1][7] = seats[1][8] = false;
            seats[2][0] = seats[2][7] = seats[2][8] = false;
        } else if (showNumber == 2) {
            seats[0][7] = seats[0][8] = false;
            seats[1][0] = seats[1][6] = seats[1][7] = seats[1][8] = false;
            seats[2][7] = seats[2][8] = false;
        } else if (showNumber == 3) {
            seats[0][5] = seats[0][6] = seats[0][7] = seats[0][8] = false;
            seats[1][8] = false;
        } else {
            return null;
        }

        return seats;
    }
}
