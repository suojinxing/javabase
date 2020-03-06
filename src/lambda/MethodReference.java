package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class MethodReference {
    public static void main(String[] args) {
        Consumer<Integer> con = System.out::println;
        con.accept(100);

        BiFunction<Integer, Integer, Integer> biFunc = (x, y) -> Integer.compare(x, y);
        BiFunction<Integer, Integer, Integer> biFunc2 = Integer::compare;
        System.out.println(biFunc2.apply(100, 200));

        BiFunction<Integer, Integer, Boolean> fun1 = (str1, str2) -> str1.equals(str2);
        BiFunction<String, String, Boolean> fun3 = String::equals;
        BiFunction<Person, Integer, Boolean> fun2 = Person::test;
        fun2.apply(new Person(),2);

        List<Integer> emps = new ArrayList<>();
        emps.stream().sorted();
//        emps.forEach();
    }
}