import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Banty on 3/5/2017.
 */
public class NumericalStreamsTest {
    NumericalStreams numericalStreams;
    List<Dish> menu = menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH)
    );

    @Before
    public void setUp() throws Exception {
        numericalStreams = new NumericalStreams(menu);

    }

    @Test
    public void testGetTotalCalories() throws Exception {
        int totalCalories = numericalStreams.getTotalCalories();
        assertEquals(800+700+400+530+350+120+550+300+450,
                totalCalories);

    }

    @Test
    public void testGetDishWithMaxCalories() throws Exception {
        Dish dish = numericalStreams.getDishWithMaxCalories();

        assertEquals("pork",dish.getName());

    }

    @Test
    public void testGenerateEvenNumbers() throws Exception {
        long evenNumberCount = numericalStreams.generateEvenNumbers();
        assertEquals(50,evenNumberCount);

    }
}