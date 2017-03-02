public class Dish {
    private final String name;
    private final boolean isVegetarian;
    private final int calories;
    private final Type type;


    public Dish(String name, boolean isVegetarian, int calories, Type type) {
        this.name = name;
        this.isVegetarian = isVegetarian;
        this.calories = calories;
        this.type = type;
    }


    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }


    @Override
    public String toString() {
        return getName();
    }


    public enum Type {
        MEAT,FISH,OTHER
    }
}
