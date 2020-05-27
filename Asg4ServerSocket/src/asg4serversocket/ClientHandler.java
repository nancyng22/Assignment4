/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asg4serversocket;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class ClientHandler extends Thread {

    final DataInputStream dis;
    final DataOutputStream dos;
    final Socket socket;

    public ClientHandler(DataInputStream dis, DataOutputStream dos, Socket socket) {
        this.dis = dis;
        this.dos = dos;
        this.socket = socket;
    }

    @Override
    public void run() {
        String received;
        String toreturn;

        while (true) {
            try {
                received = dis.readUTF();
                System.out.println(received);
            } catch (Exception e) {
                try {
                    this.dis.close();
                    this.dos.close();
                } catch (IOException ex) {
                    Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
//        try {
//           
//
//        } catch (Exception e) {
//        }
    }

}
