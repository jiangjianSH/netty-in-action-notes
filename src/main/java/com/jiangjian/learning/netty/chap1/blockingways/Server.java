package com.jiangjian.learning.netty.chap1.blockingways;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Waiting client on port 8000: ");
            while (true) {
                Socket client = serverSocket.accept();
                System.out.println("接受到请求:客户端地址信息: " + client.getRemoteSocketAddress());
                PrintWriter out = new PrintWriter(client.getOutputStream());
                out.write("Welcome to server\n");
                out.write("this is a nice day\n");
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
