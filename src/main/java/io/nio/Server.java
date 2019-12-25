package io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.socket().bind(new InetSocketAddress("127.0.0.1", 8888));
        ssc.configureBlocking(false);

        System.out.println("Server started, listening on : " + ssc.getLocalAddress());
        Selector selector = Selector.open();
        ssc.register(selector, SelectionKey.OP_ACCEPT); // 注册对哪件事感兴趣

        while (true) {
            selector.select();  // 阻塞方法
            System.out.println("selector do ....");
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> it = keys.iterator();
            while (it.hasNext()) {
                SelectionKey key = it.next();
                it.remove();
                handle(key);
            }
        }
    }

    private static void handle(SelectionKey key) {

        if (key.isAcceptable()) { // 说明有客户端想连上来
            try {
                ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                SocketChannel sc = ssc.accept();
                sc.configureBlocking(false);
                /**
                 *
                 */
                sc.register(key.selector(), SelectionKey.OP_ACCEPT);
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                // close IO
            }
        }else if(key.isReadable()){
            SocketChannel sc = null;
            try{
                sc = (SocketChannel)key.channel();
                ByteBuffer buffer = ByteBuffer.allocate(512);
                buffer.clear();

                int len = sc.read(buffer);

                if(len != -1){
                    System.out.println(new String(buffer.array(), 0, len));
                }

                ByteBuffer bufferToWrite = ByteBuffer.wrap("HelloClient".getBytes());
                sc.write(bufferToWrite);
            }catch (IOException e){
                e.printStackTrace();
            }finally {
                if(sc != null){
                    try {
                        sc.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
