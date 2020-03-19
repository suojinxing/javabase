package myproxy;


import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;

public class MyProxy {
    public static final String ln = "\r\n";

    public static Object newProxyInstance(MyClassLoader classLoader, Class<?>[] interfaces, MyInvocationHandler handler) {
        try {
            // 动态生成源文件
            String src = generateSrc(interfaces);

            // Java文件输出磁盘
            String filePath = MyProxy.class.getResource("").getPath();
            File file = new File(filePath + "$Proxy0.java");
            FileWriter fw = new FileWriter(file);

            fw.write(src);
            fw.flush();
            fw.close();

            // 把生成的文件编译成.class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable iterable = manager.getJavaFileObjects(file);

            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
            task.call();
            manager.close();

            // 把编译生成的 .class 文件加载到JVM中
            Class proxyClass = classLoader.findClass("$Proxy0");
            Constructor constructor = proxyClass.getConstructor(MyInvocationHandler.class);
            // 不留痕迹直接删除
            file.delete();

            // 返回从字节码重组以后的新的代理对象。
            return constructor.newInstance(handler);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private static String generateSrc(Class<?>[] interfaces) {
        // 返回java源文件内容的字符串。
        return "package default; \r\n   public static void main(String[] args){}";
    }
}
