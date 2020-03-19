package mythread;

public class ThreadSynchroized {
    private static int i = 0;

    public static synchronized void  add(){
        i++;
        System.out.println(Thread.currentThread().getName() + "在执行" + i);
    }

    public static void main(String[] args) {
        new Thread(() -> {
            while (i < 50) {
                add();
            }
        }).start();
        new Thread(() -> {
            while (i < 50) {
                add();
            }
        }).start();
        new Thread(() -> {
            while (i < 50) {
                add();
            }
        }).start();
    }
}
