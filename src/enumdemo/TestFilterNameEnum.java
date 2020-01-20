package enumdemo;

import org.junit.Test;

import java.util.Arrays;

import static enumdemo.FilterName.BARCODE;

public class TestFilterNameEnum {
    @Test
    public void test() {
        Arrays.stream(FilterName.values()).forEach(f -> {
            System.out.println(f + ":" + f.ordinal());
            System.out.println(f.getDeclaringClass());
            System.out.println(f.name());
//            System.out.println(f.valueOf(""));
            System.out.println("------");
        });
        System.out.println(BARCODE);
    }

    @Test
    public void test01(){

    }
}
