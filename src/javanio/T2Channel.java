package javanio;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class T2Channel {
    @Test
    public void test1Channel() throws IOException {
        // 利用通道完成文件的复制
        FileInputStream fis = new FileInputStream("/Users/apple/shinowProject/javabase/src/javanio/1.jpg");
        FileOutputStream fos = new FileOutputStream("/Users/apple/shinowProject/javabase/src/javanio/2.jpg");

        // 获取通道
        FileChannel inChannel = fis.getChannel();
        FileChannel outChannel = fos.getChannel();

        // 声明缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while(inChannel.read(buffer) != -1){
            buffer.flip(); // 缓冲区切换成读模式
            outChannel.write(buffer);
            buffer.clear(); // 清空缓冲区。
        }
    }
}
