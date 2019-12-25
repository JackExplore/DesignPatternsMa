package io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PoolServer {

    ExecutorService pool = Executors.newFixedThreadPool(50);

    private Selector selector;

    public static void main(String[] args) throws IOException{
        PoolServer server = new PoolServer();
        server.initServer(8000);
        server.listen();
    }

    public void initServer(int port) throws IOException{
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(port));
        this.selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("服务端启动成功！");
    }

    public void listen() throws IOException{
        // 轮训访问 selector
        while(true){
            selector.select();
            Iterator ite = this.selector.selectedKeys().iterator();
            while(true){
                SelectionKey key = (SelectionKey) ite.next();
                ite.remove();
                if(key.isAcceptable()){
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    SocketChannel channel = server.accept();
                    channel.configureBlocking(false);
                    channel.register(this.selector, SelectionKey.OP_ACCEPT);
                }else if(key.isReadable()){
                    key.interestOps(key.interestOps() & (~SelectionKey.OP_READ));
                    pool.execute(new ThreadHandlerChannel(key));
                }
            }
        }
    }

}

class ThreadHandlerChannel extends Thread{

    private SelectionKey key;
    ThreadHandlerChannel(SelectionKey key){
        this.key = key;
    }

    @Override
    public void run(){

    }
}