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
 *
 * 差不多类似于 netty， 但是 netty 封装得更好。
 *
 * 问：有了 aio ， 为什么还要有 nio ？
 * 答：在 netty 里面用的还是 nio！
 *      因为在 linux 底层，aio 和 nio都是用epoll实现的，所以netty是封装了 nio，封装的api更像是 aio！
 *      Windows 上的 aio 是单独实现的（确实是事件模型），效率比Linux要高，但是世界上的大多数Server都是Linux，netty表示只关心在Linux实现，不关心在Windows实现，
 *      因此，netty 是封装了 nio ，没管 aio！
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
