/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asg4serversocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author hp
 */
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is connecting ... ");

        while (true) {
            Socket socket = null;
            try {
                socket = serverSocket.accept();
                System.out.println("Assigning a new thread ... ");

                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                Thread t = new ClientHandler(dis, dos, socket);
                t.start();
            } catch (Exception e) {
                socket.close();
                e.printStackTrace();
            }
        }
    }
}
