/**
 * Created by Banty on 30/03/17.
 */
public class Customer {

    private Show show;
    private CostCalculator costCalculator;
    public Customer(Show show, CostCalculator costCalculator) {
        this.show = show;
        this.costCalculator = costCalculator;
    }

    public double getBaseTicketCost(){
        return 0;
    }

    public double getServiceTax(){
        return 0;
    }

    public double getSwatchBharatTax(){
        return 0;
    }

    public double getKrishiKalyanTax(){
        return 0;
    }
}
