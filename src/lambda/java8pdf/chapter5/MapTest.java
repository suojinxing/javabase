package lambda.java8pdf.chapter5;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapTest {
    List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH));

    // 测试map中的方法引用
    @Test
    public void test1() {
        menu.stream()
                .map(Dish::getName)
//                .map(dish -> dish.getName())
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    // 测试map,查看每道菜的长度
    @Test
    public void test2() {
        menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }

    // 错误的方法分割数组。想要筛选出不同的字母
    @Test
    public void test3() {
        List<String> words = Arrays.asList("hello", "world");
        words.stream()
                .map(word -> word.split(""))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    // 依旧是错误的方法，因为得到的结果是Stream<String>
    @Test
    public void test3_1() {
        List<String> words = Arrays.asList("hello", "world");
        words.stream()
                .map(word -> word.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }

    // 使用flatMap
    @Test
    public void test3_2() {
        List<String> words = Arrays.asList("hello", "world");
        words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    //给定一个数字列表，如何返回一个由每个数的平方构成的列表呢？
    // 例如，给定[1, 2, 3, 4,5]，应该返回[1, 4, 9, 16, 25]
    @Test
    public void test4() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.stream()
                .map(i -> i * i)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        Integer[] numbers2 = (Integer[]) numbers.toArray();
        Arrays.stream(numbers2)
                .map(i -> i * i)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    // 给定两个数字列表，如何返回所有的数对呢？例如，给定列表[1, 2, 3]和列表[3, 4]，
    // 应该返回[(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]。为简单起见，你可以用有两个元素的数组来代表数对。
    @Test
    public void test5() {
        List<Integer> arr1 = Arrays.asList(1, 2, 3);
        List<Integer> arr2 = Arrays.asList(3, 4);
        List<int[]> collect = arr1.stream()
                .flatMap(i -> arr2.stream()
                        .map(j -> new int[]{i, j})
                )
                .collect(Collectors.toList());
        collect.forEach(intArr -> Arrays.stream(intArr).forEach(System.out::println));
    }
}
