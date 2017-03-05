import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by Banty on 3/5/2017.
 */
public class NumericalStreams {
    private final List<Dish> menu;

    public NumericalStreams(List<Dish> menu) {
        this.menu = menu;
    }

    public int getTotalCalories() {
        return menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
    }

    public Dish getDishWithMaxCalories() {
        return menu.stream()
                .sorted((dish1,dish2) -> Integer.compare(dish2.getCalories(),dish1.getCalories()))
                .findFirst()
                .get();
    }

    public long generateEvenNumbers(){
        return IntStream.rangeClosed(1,100)
                .filter(num -> num % 2 ==0)
                .count();

    }
}
