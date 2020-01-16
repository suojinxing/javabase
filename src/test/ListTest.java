package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    // 测试remove报错
    @Test
    public void testArrayList$Add() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(i);
        }

        for (int i = 0; i < list.size(); i++) {
            list.remove(i);
        }
        System.out.println(list);
    }

    // 参数不能设置默认值
    // public void test2(String a = "") {
    public void test2(String a) {

    }
}

class A {
    public int a;
}
