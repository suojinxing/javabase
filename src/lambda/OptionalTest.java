package lambda;

import org.junit.Test;

import java.util.Optional;

public class OptionalTest {
    @Test
    public void test(){
        Optional op = Optional.of(new Person());
        System.out.println(op.get());
    }

    @Test
    public void test02(){
        Optional op = Optional.empty();

        System.out.println(op.get());
    }

    @Test
    public void test03(){

    }
}
