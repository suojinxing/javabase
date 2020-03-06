package lambda.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class Apple {
    List<Apple> inventory = new ArrayList<>();
    private String color = "green";
    private Integer weight;

    @Test
    public void testLambda1() {
        // 筛选出苹果是绿色，并且重量大于80g的
        Apple apple = new Apple();
        apple.setColor("green");
        apple.setWeight(88);
        Apple apple2 = new Apple();
        apple2.setColor("yellow");
        apple2.setWeight(88);
        apple.getInventory().add(apple);
        apple.getInventory().add(apple2);
        List<Apple> inventory = apple.getInventory();


        List<Apple> greenHeavyApples = filterApples(inventory, (Apple a) -> Objects.equals("green", a.getColor()) && a.getWeight() > 80);
        greenHeavyApples.forEach(System.out::println);
    }

    /**
     * 从仓库中筛选出指定条件的苹果
     *
     * @param inventory
     * @param predicate
     * @return
     */
    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<>();
        inventory.forEach(apple -> {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        });
        return result;
    }

    public List<Apple> getInventory() {
        return inventory;
    }

    public void setInventory(List<Apple> inventory) {
        this.inventory = inventory;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}

