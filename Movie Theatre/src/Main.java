import java.util.Scanner;

/**
 * Created by Banty on 3/31/2017.
 */
public class Main {

    public static void main(String[] args) {
        Theatre theatre = new Theatre();
        Scanner scanner = new Scanner(System.in);
        String choice = "Y";
        while(choice.equalsIgnoreCase("Y")) {
            System.out.println("Do you want to book a movie ticket?(Y/N)");
            choice = scanner.next();
            if (choice.equalsIgnoreCase("Y")) {
               theatre.bookTicket();
            }
        }
        theatre.calculateAndPrintTotalRevenue();
    }
}
