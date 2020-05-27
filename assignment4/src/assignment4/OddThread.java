/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class OddThread extends Thread {

    Socket s;

    DataInputStream dis;
    DataOutputStream dos;

    public OddThread() {
        try {
            InetAddress ip = InetAddress.getByName("localhost");
            s = new Socket(ip, 8080);
            dis = new DataInputStream(s.getInputStream());
            dos = new DataOutputStream(s.getOutputStream());
        } catch (UnknownHostException ex) {
            Logger.getLogger(OddThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(OddThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 19; i += 2) {
                String toSend = i + " at " + java.time.LocalTime.now();
                System.out.println(toSend);
                dos.writeUTF(toSend);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
