package javanio;

import org.junit.Test;

import java.nio.Buffer;
import java.nio.ByteBuffer;

/**
 * 缓冲区：说白了就是数组，用于存储数据。
 * <p>
 * 根据类型不同，提供利润不同的缓冲区（Boolean类型除外）
 * CharBuffer
 * ByteBuffer    ===>最常用
 * IntegerBuffer
 * DoubleBuffer
 * ShortBuffer
 * FloatBuffer
 * LongBuffer
 * <p>
 * 管理方式几乎一致
 */
public class T1Buffer {
    /*
     * mark
     */
    @Test public void test2(){
        String str = "abcde";
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // 1. 存入数据
        buffer.put(str.getBytes());

        // 2. 切换读
        buffer.flip();

        // 3. 读数据
        byte[] msg0 = new byte[2];
        buffer.get(msg0);
        System.out.println(new String(msg0));
        System.out.println(buffer.position());

        // 4. mark标记一下
        buffer.mark();

        byte[] msg = new byte[2];
        buffer.get(msg);
        System.out.println(new String(msg));

        // 5. 回退到标记的位置
        buffer.reset();
        System.out.println(buffer.position());

        byte[] msg1 = new byte[2];
        buffer.get(msg1);
        System.out.println(new String(msg1));

//        buffer.reset();
        // 查询缓冲区中海油多少可以处理的数据。
        if (buffer.hasRemaining()) {

            System.out.println(buffer.remaining());
        }

    }


    /*
     * 缓冲区的两个核心方法：put() & get()
     */
    @Test
    public void test1() {
        String str = "abcde";
        // 1. 分配指定大小的缓冲区。
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        System.out.println("---init...----");
        System.out.println(buffer.capacity());
        System.out.println(buffer.limit());
        System.out.println(buffer.position());
        // 2. 写数据
        buffer.put(str.getBytes());
        System.out.println("---put()----");
        System.out.println(buffer.capacity());
        System.out.println(buffer.limit());
        System.out.println(buffer.position());

        // 3. 切换读模式
        buffer.flip();
        System.out.println("---flip()----");
        System.out.println(buffer.capacity());
        System.out.println(buffer.limit());
        System.out.println(buffer.position());

        // 4. 读取数据
        byte[] bytes = new byte[buffer.limit()];
        buffer.get(bytes);
        System.out.println(new String(bytes, 0, bytes.length));

        System.out.println("---get()----");
        System.out.println(buffer.capacity());
        System.out.println(buffer.limit());
        System.out.println(buffer.position());

        // 5. 倒带，将指针回到position=0可以重新读。
        buffer.rewind();
        System.out.println("--rewuind()-----");
        System.out.println(buffer.capacity());
        System.out.println(buffer.limit());
        System.out.println(buffer.position());

        // 6. 清空缓冲区，但是数据并没有消失，而是处于被遗忘状态
        buffer.clear();
        System.out.println("---clear()----");
        System.out.println(buffer.capacity());
        System.out.println(buffer.limit());
        System.out.println(buffer.position());

    }
}
