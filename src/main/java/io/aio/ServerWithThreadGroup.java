package io.aio;

import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * aio - 多线程模型
 */
public class ServerWithThreadGroup {

    public static void main(String[] args) throws Exception{

        ExecutorService executorService = Executors.newCachedThreadPool();
        AsynchronousChannelGroup threadGroup = AsynchronousChannelGroup.withCachedThreadPool(executorService, 1);

        final AsynchronousServerSocketChannel serverChannel = AsynchronousServerSocketChannel.open(threadGroup)
                .bind(new InetSocketAddress(8888));
        serverChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
            @Override
            public void completed(AsynchronousSocketChannel result, Object attachment) {

            }

            @Override
            public void failed(Throwable exc, Object attachment) {

            }
        });

    }
}
