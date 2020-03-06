package lambda;

import lambda.java8.Apple;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;

public class Lambda {
    public static void main(String[] args) {
        List<String> a = new ArrayList<>(10);

        for (int i = 0; i < 10; i++) {
            a.add("" + i);
        }

        a.forEach(System.out::println);
    }

    int b = 1;

    public void abc() {
        List<String> a = new ArrayList<>(10);

        a.forEach((c) -> {
            this.b = 0;
        });
    }

    // 测试方法引用
    @Test
    public void test1() {
        List<String> strs = Arrays.asList("a", "B", "a", "G", "d", "D", "g");
        strs.sort((obj1, obj2) -> obj1.compareToIgnoreCase(obj2));
        strs.sort(String::compareToIgnoreCase);
        strs.forEach(System.out::println);
    }

    // 测试构造方法的引用
    @Test
    public void test2(){
        Supplier<C> c = C::new;
        C c1 = c.get();
        c1.get();
    }

    // Comparator.comparing
    @Test
    public void test3(){
        Comparator<Apple> comparing = Comparator.comparing((Apple a) -> a.getWeight());
        Comparator<Apple> reversed = comparing.reversed();
    }
}

class C {
    C() {
        System.out.println("无参构造");
    }

    public void get(){
        System.out.println("get");
    }
}

class B implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}

interface A {
    public static void test() {
        System.out.println("接口中可以有静态方法");
    }
}