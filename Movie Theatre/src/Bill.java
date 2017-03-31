/**
 * Created by Banty on 30/03/17.
 */
public class Bill {

    private Show show; //for which the bill is to be calculated

    private double swatchBharatTax = 0;
    private double krishiKalyanTax = 0;
    private double baseTicketCost = 0;
    private double serviceTax = 0;


    public Bill(Show show) {
        this.show = show;
    }


    public void calculateBill(String seat) {
        calculateBaseCost(seat);
        calculateServiceTax();
        calculateSwatchBharatTax();
        calculateKrishiKalyanTax();

    }

    private void calculateKrishiKalyanTax() {
        swatchBharatTax = 0.005 * baseTicketCost;
    }

    private void calculateSwatchBharatTax() {
        swatchBharatTax = 0.005 * baseTicketCost;
    }

    private void calculateServiceTax() {
        serviceTax = baseTicketCost * 0.14;
    }

    private double calculateBaseCost(String seat) {
        int row = getRowFromSeatNumber(seat);
        baseTicketCost = getBasePriceForRow(row);
        return baseTicketCost;
    }

    private double getBasePriceForRow(int row) {
        if (row == 0) {
            //platinum row
            return 320;
        } else if (row == 1) {
            //gold row
            return 280;
        } else {
            //silver row
            return 240;
        }
    }

    public double getBaseTicketCost() {
        return baseTicketCost;
    }

    public double getServiceTax() {
        return serviceTax;
    }

    public double getSwatchBharatTax() {
        return swatchBharatTax;
    }

    public double getKrishiKalyanTax() {
        return krishiKalyanTax;
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
}
