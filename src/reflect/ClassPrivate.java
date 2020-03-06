package reflect;

import org.junit.Test;

import java.io.File;
import java.lang.reflect.Constructor;
import java.util.Objects;


public class ClassPrivate {
    @Test
    public void testFile(){
        File file = new File("path");
        file.lastModified(); // 最后一次修改时间
    }

    @Test
    public void test() {
        try {
            Class<?> clazz = Class.forName("java.util.Objects");
            Constructor<?> constructor = clazz.getDeclaredConstructor();// 获取构造方法
            constructor.setAccessible(true); // 修改private权限。true表示可以访问私有方法
            Objects objects = (Objects) constructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1(){
        try {
            Class<?> clazz = Class.forName("reflect.A");
            System.out.println("======分割线：以上是A类的加载内容");
            ClassLoader.getSystemClassLoader().loadClass("reflect.A");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class A {
    static int a = init();

    static {
        System.out.println("执行静态代码块");
    }

    public static int init() {
        System.out.println("为静态变量赋值");
        return 1;
    }
}
