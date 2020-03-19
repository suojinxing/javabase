package base;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AooInvocationHandler implements InvocationHandler {
    private Object target;

    public AooInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行代理方法");
        Object invoke = method.invoke(target, args);
        return invoke;
    }
}
