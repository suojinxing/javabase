package lambda.java8pdf.chapter5;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceTest {
    @Test
    public void test() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Integer reduce = numbers.stream()
                .filter(i -> i > 3)
                .reduce(0, Integer::sum);
        System.out.println(reduce);

    }

    @Test
    public void test2() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> reduce = numbers.stream()
                .filter(i -> i > 3)
                .reduce(Integer::sum);
        System.out.println(reduce.get());

    }
}
