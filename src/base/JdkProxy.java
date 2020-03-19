package base;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class JdkProxy {
    public static void main(String[] args) {
        Aoo aoo = new Aoo() {
            @Override
            public void eat() {
                System.out.println("eat");
            }

            @Override
            public void fly() {
                System.out.println("fly");
            }
        };
        InvocationHandler h = new AooInvocationHandler(aoo);
        Aoo aooProxy = (Aoo) Proxy.newProxyInstance(JdkProxy.class.getClassLoader(), new Class[]{Aoo.class}, h);
        System.out.println("代理对象和原对象是否相等：" + (aooProxy == aoo));
        System.out.println("-------代理对象执行eat方法-------");
        aooProxy.eat();
        aooProxy.fly();
        System.out.println("-------原对象执行eat方法-------");
        aoo.eat();
    }

    interface Aoo {
        void eat();

        void fly();
    }
}

