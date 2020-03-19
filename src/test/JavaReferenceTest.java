package test;

import org.junit.Test;

public class JavaReferenceTest {
    @Test
    public void test01() {
        A a = new A();
        a.setA(2);
        System.out.println(a.getA());

        A a2 = a;
        a2.setA(3);
        System.out.println(a.getA());
    }


    class A{
        private int a = 0;

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }
    }
}

