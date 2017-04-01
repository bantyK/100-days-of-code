import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Banty on 30/03/17.
 */
public class Theatre {
    private double totalBaseCost = 0;
    private double totalServiceTax = 0;
    private double totalSwatchBharatTax = 0;
    private double totalKrishiKalyanTax = 0;

    private ArrayList<Bill> Bills = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    private Show show1, show2, show3;

    public Theatre() {
        initShow();
    }

    public void calculateAndPrintTotalRevenue() {
        for (Bill bill : Bills) {
            totalBaseCost += bill.getBaseTicketCost();
            totalServiceTax += bill.getServiceTax();
            totalSwatchBharatTax += bill.getSwatchBharatTax();
            totalKrishiKalyanTax += bill.getKrishiKalyanTax();
        }
        System.out.println("Total Sales");
        System.out.println(String.format("Revenue: Rs. " + totalBaseCost));
        System.out.println(String.format("Service Tax: Rs. %.2f", totalServiceTax));
        System.out.println(String.format("Swachh Bharat Tax: Rs. %.2f ", totalSwatchBharatTax));
        System.out.println(String.format("Krishi Kalyan Cess: Rs. %.2f", totalKrishiKalyanTax));
    }

    public void printBill(Bill bill) {

        System.out.println("Sub Total: Rs. " + bill.getBaseTicketCost());
        System.out.println(String.format("Service Tax: Rs. %.2f", bill.getServiceTax()));
        System.out.println(String.format("Swachh Bharat Cess: Rs. %.2f", bill.getSwatchBharatTax()));
        System.out.println(String.format("Krishi Kalyan Cess: Rs. %.2f", bill.getKrishiKalyanTax()));
        System.out.println(String.format("Total : Rs. %.2f", getTotalBill(bill)));
    }

    public void initShow() {
        show1 = new Show(1);
        show2 = new Show(2);
        show3 = new Show(3);
    }

    public boolean bookShow(int showNumber, String[] seats) {
        Show show = getShow(showNumber);
        if (show.checkIfSeatsAreAvailable(seats)) {
            for (String seat : seats) {
                show.bookTicket(seat);
            }
            createAndAddBill(showNumber, seats);
            return true;
        } else {
            show.printSeatingArrangement();
            return false;
        }

    }

    private Show getShow(int showNumber) {
        if (showNumber == 1) {
            return show1;
        } else if (showNumber == 2) {
            return show2;
        } else {
            return show3;
        }
    }

    public Show getShow1() {
        return show1;
    }

    public Show getShow2() {
        return show2;
    }

    public Show getShow3() {
        return show3;
    }

    public void createAndAddBill(int showNumber, String[] seats) {
        Bill bill = new Bill(getShow(showNumber));
        bill.calculateBill(seats);
        printBill(bill);
        Bills.add(bill);
    }

    public void bookTicket() {
        System.out.println("Enter Show No: ");
        int showNumber = scanner.nextInt();
        System.out.println("Enter seats: ");
        String ticketNumbers = scanner.next();
        if(bookShow(showNumber, ticketNumbers.split(","))){
            System.out.println("Successfully Booked - Show " + showNumber);
        }
    }

    public double getTotalBill(Bill bill) {
        return bill.getBaseTicketCost() + bill.getServiceTax() + bill.getSwatchBharatTax() + bill.getKrishiKalyanTax();
    }
}
