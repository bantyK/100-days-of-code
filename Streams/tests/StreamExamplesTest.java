import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class StreamExamplesTest {
    List<Dish> menu;
    StreamExamples se;

    @Before
    public void setUp() throws Exception {
        se = new StreamExamples();
        menu = Arrays.asList(
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

    }

    @Test
    public void testget3HighCalorieDishes() throws Exception {
        List<Dish> result = se.get3HighCalorieDishes(menu);

        assertEquals(result.get(0).getName(), "pork");
        assertEquals(result.get(1).getName(), "beef");
        assertEquals(result.get(2).getName(), "pizza");

    }

    @Test
    public void testPrintLambdaFunctions() throws Exception {
        System.out.println(se.printLambdaOprations(menu));

    }

    @Test
    public void testVegetarianFilter() throws Exception {
        List<Dish> vegetarianDishes = se.getVegetarianDishes(menu);
        int count = 0;
        for (Dish dish : vegetarianDishes) {
            if (!dish.isVegetarian())
                count += 1;
        }
        assertEquals(0, count);
    }

    @Test
    public void testFilteringUnique() throws Exception {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 2, 6, 8, 9, 2, 4);
        List<Integer> uniqueEvenNumbers = se.getUniqueEvenNumbers(numbers);
        assertEquals(4, uniqueEvenNumbers.size());
    }

    @Test
    public void testSkipFirstTwoMethod() throws Exception {
        List<Dish> resultList = se.getMoreThan500CalorieSkipFirstTwo(menu);

        assertEquals(resultList.get(0).getName(), "french fries");
        assertEquals(resultList.get(1).getName(), "pizza");
    }

    @Test
    public void testFilterFirstTwoMeatDishes() throws Exception {
        List<Dish> resultList = se.filterFirstTwoMeatDishes(menu);

        assertEquals(resultList.get(0).getName(), "pork");
        assertEquals(resultList.get(1).getName(), "beef");
    }

    @Test
    public void testgetOtherTypeMealNames() throws Exception {
        List<String> otherTypeNames = se.getOtherTypeDishNames(menu);
        assertEquals(4, otherTypeNames.size());
    }

    @Test
    public void testGetStringLengthMethod() throws Exception {
        List<Integer> lengths = se.getCharLengths(menu);
        String s = lengths.stream()
                .map(num -> String.valueOf(num))
                .collect(Collectors.joining(""));
        assertEquals("44712412566", s);
    }

    @Test
    public void testOtherNames() throws Exception {
        List<String> result = se.getOver300CalorieOtherNames(menu);
        String s = result.stream()
                .collect(Collectors.joining(","));
        assertEquals("french fries,rice,pizza", s);
    }

    @Test
    public void testgetLessThan800CalorieMEATDishes() throws Exception {
        List<String> result = se.getMoreThan700CalorieMEATDishes(menu);

        assertEquals(1, result.size());
        assertEquals(result.get(0), "pork");
    }

    @Test
    public void testGetStringLength() throws Exception {
        List<String> stringArray = Arrays.asList("Hello", "World");
        String s = se.getStringLengths(stringArray);
        assertEquals("55", s);
    }

    @Test
    public void testGetEvenLengthMeatNamesWithMoreThan500Calories() throws Exception {
        String s = se.getEvenLengthMeatNamesWithMoreThan500Calories(menu);

        assertEquals("44", s);
    }
}