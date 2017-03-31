import java.util.ArrayList;

/**
 * Created by Banty on 30/03/17.
 */
public class Theatre {
    private double totalBaseCost = 0;
    private double totalServiceTax = 0;
    private double totalSwatchBharatTax = 0;
    private double totalKrishiKalyanTax = 0;

    private ArrayList<Customer> customers = new ArrayList<>();

    private Show show1, show2, show3;

    public Theatre() {
        this.show1 = new Show(1);
        this.show2 = new Show(2);
        this.show3 = new Show(3);
    }

    public void calculateTotalRevenueWithTaxes() {
        for (Customer customer : customers) {
            totalBaseCost += customer.getBaseTicketCost();
            totalServiceTax += customer.getServiceTax();
            totalSwatchBharatTax += customer.getSwatchBharatTax();
            totalKrishiKalyanTax += customer.getKrishiKalyanTax();
        }
    }

    public void printTotalRevenue() {
        System.out.println("Total Sales");
        System.out.println("Revenue: Rs. " + totalBaseCost);
        System.out.println("Service Tax:Rs. " + totalServiceTax);
        System.out.println("Swachh Bharat Cess: Rs. " + totalSwatchBharatTax);
        System.out.println("Krishi Kalyan Cess: Rs. " + totalKrishiKalyanTax);
    }

    public void initShow() {
        show1 = new Show(1);
        show2 = new Show(2);
        show3 = new Show(3);
    }

    public boolean bookShow(int showNumber, String[] seats) {
        Show show = getShow(showNumber);
        if(show.checkIfSeatsAreAvailable(seats)){
            show.bookTicket(seats);
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
}
