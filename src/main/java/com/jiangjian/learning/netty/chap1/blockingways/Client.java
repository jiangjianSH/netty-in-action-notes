package com.jiangjian.learning.netty.chap1.blockingways;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket client = new Socket();
            client.connect(new InetSocketAddress("localhost", 8000));
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String content;
            while(true) {
                content = reader.readLine();
                if(content == null) break;
                System.out.println(content);
            }

            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
