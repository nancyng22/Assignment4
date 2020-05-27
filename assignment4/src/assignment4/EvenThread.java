/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author hp
 */
public class EvenThread extends Thread {
    
    Socket s;
    DataInputStream dis;
    DataOutputStream dos;
    
    public EvenThread() {
        try {
            InetAddress ip = InetAddress.getByName("localhost");
            s = new Socket(ip, 8080);
            dis = new DataInputStream(s.getInputStream());
            dos = new DataOutputStream(s.getOutputStream());
        } catch (Exception e) {
        }
    }
    
    @Override
    public void run() {
        try {
            for (int i = 0; i <= 20; i += 2) {
                String toSend = i + " at " + java.time.LocalTime.now();
                System.out.println(toSend);
                dos.writeUTF(toSend);
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
