package lambda.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class AppleUtils {
    public static void prettyPrintApple(List<Apple> inventory, Consumer<Apple> consumer){
        inventory.forEach(consumer);
    }

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        Apple apple = new Apple();
        apple.setColor("green");
        apple.setWeight(88);
        Apple apple2 = new Apple();
        apple2.setColor("yellow");
        apple2.setWeight(88);
        inventory.add(apple);
        inventory.add(apple2);
        prettyPrintApple(inventory,theApple-> System.out.println("苹果的重量是：" + theApple.getWeight()));
    }
}
