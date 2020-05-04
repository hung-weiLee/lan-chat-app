package chatapplication;

import java.io.*;
import static java.lang.Thread.sleep;
import java.net.*;
import java.util.*;

public class OnlineStatus implements Runnable {
    DatagramSocket s;

    public OnlineStatus() {
        try {
            s = new DatagramSocket(); // client DatagramSocket
        }
        catch (SocketException ex) {
        }
    }

    @Override
    public void run() {
        System.out.println("T3");
        while(true) {
            try {
                byte[] buf = MulticastClient.name.getBytes(); // name

                // send it
                InetAddress group = InetAddress.getByName("230.0.0.2");
                DatagramPacket packet = new DatagramPacket(buf, buf.length, group, 5000); // send

                s.send(packet); // send packet
                try {
                    sleep((long)(Math.random() * 20000));
                }
                catch(Exception e){
                }
            }
            catch (IOException e) {
                System.out.println("error in online status class");
                s.close();}
        }
    }
}

/**==============================================================================**/

class ReceiveOnlineStatus implements Runnable {
    InetAddress address = null;
    MulticastSocket socket = null;
    public static List<String> al;

    public ReceiveOnlineStatus(){
        try{
            al = new ArrayList<>();

            socket = new MulticastSocket(5000) ; // MulticastSocket, port: 5000
            address = InetAddress.getByName("230.0.0.2"); // board cast ip
            socket.joinGroup(address);
        }
        catch(Exception e) {
            System.err.println("error");
        }
    }

    @Override
    public void run() {
        while(true) {
            System.out.println("T4");
            try {
                byte[] buf = new byte[256];
                DatagramPacket packet = new DatagramPacket(buf, buf.length); // receive

                socket.receive(packet); // MulticastSocket receive packet

                // transfer packet to string
                String name = new String(packet.getData(), 0, packet.getLength());
                System.out.println("name: " + name);

                if(name.equals("exited"))
                    al = new ArrayList<>();

                if (!al.contains(name) && !name.equals("exited")) {
                    al.add(name);

                    if (MulticastClient.jTextArea3.getText().equals(""))
                        MulticastClient.jTextArea3.setText(name);
                    else {
                        MulticastClient.jTextArea3.setText("");

                        for (Object obj:al) {
                            MulticastClient.jTextArea3.setText(MulticastClient.jTextArea3.getText() + obj.toString() + "\n");
                        }
                    }
                }
            }
            catch(Exception e){System.out.println("error in receive online status class");}
        }
    }
}