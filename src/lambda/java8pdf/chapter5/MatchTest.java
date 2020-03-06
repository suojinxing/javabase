package lambda.java8pdf.chapter5;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MatchTest {
    @Test
    public void matchEle() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.stream()
                .filter(i -> i > 3)
                .findAny()
                .ifPresent(System.out::println);
    }
}
