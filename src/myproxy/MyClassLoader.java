package myproxy;

public class MyClassLoader extends ClassLoader {
    @Override
    public Class findClass(String name) {
        defineClass(null, null, null);

        return null;
    }
}
