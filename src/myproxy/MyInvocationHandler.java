package myproxy;

import java.lang.reflect.Method;

/**
 * 手写JDK动态代理
 * 这是一个回调处理器
 */
public interface MyInvocationHandler {
    Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
