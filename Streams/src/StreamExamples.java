import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Banty on 01/03/17.
 */
public class StreamExamples {

    public List<Dish> get3HighCalorieDishes(List<Dish> menu) {
        List<Dish> highCalorieDishes =
                menu.stream()
                        .filter((Dish d) -> d.getCalories() > 530)
                        .limit(3)
                        .collect(Collectors.toList());


        return highCalorieDishes;
    }

    public List<String> printLambdaOprations(List<Dish> menu) {
        return menu.stream()
                .filter(d -> {
                    System.out.println("filtering : " + d.getName());
                    return d.getCalories() > 400;
                })
                .map(d -> {
                    System.out.println("mapping : " + d.getName());
                    return d.getName();
                })
                .limit(3)
                .collect(Collectors.toList());

    }

    public List<Dish> getVegetarianDishes(List<Dish> menu) {
        List<Dish> vegetarianDishes =
                menu.stream()
                        .filter((Dish d) -> d.isVegetarian())
                        .collect(Collectors.toList());

        return vegetarianDishes;
    }

    public List<Integer> getUniqueEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num % 2 == 0)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Dish> getMoreThan500CalorieSkipFirstTwo(List<Dish> menu) {
        return menu.stream()
                .filter(dish -> dish.getCalories() > 500)
                .skip(2)
                .collect(Collectors.toList());
    }

    public List<Dish> filterFirstTwoMeatDishes(List<Dish> menu) {
        return menu.stream()
                .filter(dish -> dish.getType().equals(Dish.Type.MEAT))
                .limit(2)
                .collect(Collectors.toList());
    }

    public List<String> getOtherTypeDishNames(List<Dish> menu) {
        return menu.stream()
                .filter(dish -> dish.getType().equals(Dish.Type.OTHER))
                .map(dish -> dish.getName())
                .collect(Collectors.toList());
    }

    public List<Integer> getCharLengths(List<Dish> menu) {
        return menu.stream()
                .map(dish -> dish.getName().length())
                .collect(Collectors.toList());
    }

    public List<String> getOver300CalorieOtherNames(List<Dish> menu) {
        return menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .filter(dish -> dish.getType().equals(Dish.Type.OTHER))
                .map(Dish::getName)
                .collect(Collectors.toList());
    }

    public List<String> getMoreThan700CalorieMEATDishes(List<Dish> menu) {
        return menu.stream()
                .filter(dish -> dish.getType().equals(Dish.Type.MEAT))
                .filter(dish -> dish.getCalories() > 700)
                .map(dish -> dish.getName())
                .collect(Collectors.toList());


    }

    public String getStringLengths(List<String> stringArray) {
        return stringArray.stream()
                .map(s -> s.length())
                .map(String::valueOf)
                .collect(Collectors.joining(""));
    }

    public String getEvenLengthMeatNamesWithMoreThan500Calories(List<Dish> menu) {
        return menu.stream()
                .filter(dish -> dish.getType().equals(Dish.Type.MEAT))
                .filter(dish -> dish.getName().length() % 2 == 0)
                .map(dish -> dish.getName().length())
                .map(String::valueOf)
                .collect(Collectors.joining(""));
    }
}
