/**
 * Created by Banty on 30/03/17.
 */
public class CostCalculator {

    public double calculate(String seatNumber) {
        double totalCostForTicket = 0;

        int row = getRowFromSeatNumber(seatNumber);
        int column = Integer.parseInt(String.valueOf(seatNumber.charAt(1)));

        if (row == 0) {
            //platinum row
            totalCostForTicket += 320;
        } else if (row == 1){
            //gold row
            totalCostForTicket += 280;
        } else {
            //silver row
            totalCostForTicket += 240;
        }

        totalCostForTicket = addAdditionalTaxes(totalCostForTicket);

        return totalCostForTicket;

    }

    private double addAdditionalTaxes(double totalCostForTicket) {
        totalCostForTicket += addServiceTax(totalCostForTicket);
        totalCostForTicket += addSwatchBharatTax(totalCostForTicket);
        totalCostForTicket += addKrishiKalyanTax(totalCostForTicket);

        return totalCostForTicket;
    }

    private double addServiceTax(double totalCostForTicket) {
        return totalCostForTicket * 0.14;
    }

    private double addSwatchBharatTax(double totalCostForTicket) {
        return totalCostForTicket * 0.005;
    }

    private double addKrishiKalyanTax(double totalCostForTicket) {
        return totalCostForTicket * 0.005;
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
