package io.bio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * BIO - Blocking IO
 *
 * 少量的连接，还合适
 * 大量的连接，就不是很合适了
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket();
        ss.bind(new InetSocketAddress("127.0.0.1", 8888));
        while(true){
            Socket s = ss.accept(); // 阻塞方法  阻塞点 A
            new Thread(() ->
                    handle(s)
            ).start();
        }
    }

    static void handle(Socket s){
        try{
            byte[] bytes = new byte[1024];
            int len = s.getInputStream().read(bytes);       // 阻塞点 B
            System.out.println(new String(bytes, 0, len));

            s.getOutputStream().write(bytes, 0, len);   // 阻塞点 C
            s.getOutputStream().flush();

        }catch(IOException e){
            e.printStackTrace();
        }

    }
}