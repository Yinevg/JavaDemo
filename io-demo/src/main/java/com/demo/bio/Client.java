package com.demo.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Yinevg on 2020/4/14
 */
public class Client {
    public static void main(String[] args) {
        BufferedReader reader = null;
        PrintWriter writer = null;
        Socket clientSocket = null;
        try {
            clientSocket = new Socket("127.0.0.1", 8080);
            writer = new PrintWriter(clientSocket.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            while (true) {//每隔5秒发送一次请求
                writer.println("HELLO SERVER");
                writer.flush();
                System.out.println(reader.readLine());
                Thread.sleep(1000);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
                if (clientSocket != null) {
                    clientSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
