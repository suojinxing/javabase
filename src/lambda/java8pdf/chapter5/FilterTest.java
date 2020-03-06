package lambda.java8pdf.chapter5;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class FilterTest {
    private List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 3, 4);

    // 测试filter
    @Test
    public void test1() {
        numbers.stream().filter(a -> a < 4)
                .distinct()
                .sorted((a, b) -> a < b ? 1 : -1)
                .forEach(System.out::println);
    }

    // 测试skip
    @Test
    public void test2() {
        numbers.stream().skip(3).forEach(System.out::println);
    }
}
