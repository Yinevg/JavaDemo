package com.demo.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Yinevg on 2020/4/14
 */
public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8080);
            System.out.println("SERVER STARTED ON 8080");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(new ServerHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
