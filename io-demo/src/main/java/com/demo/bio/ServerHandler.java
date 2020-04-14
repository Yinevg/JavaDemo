package com.demo.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Yinevg on 2020/4/14
 */
public class ServerHandler implements Runnable {

    private Socket clientSocket;

    public ServerHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        BufferedReader reader = null;
        PrintWriter writer = null;

        try {
            reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            writer = new PrintWriter(clientSocket.getOutputStream());
            while (true) {
                String request = reader.readLine();
                if ("HELLO SERVER".equals(request)) {
                    writer.println("HELLO CLIENT, TIME: " + System.currentTimeMillis());
                } else {
                    writer.println("BAD REQUEST");
                }
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
