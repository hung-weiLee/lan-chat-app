package chatapplication;

import java.net.DatagramPacket;
import java.net.InetAddress;

public class DatagramPacketFactory {
    public static DatagramPacket create_send(byte[] buf, InetAddress group, int port) {
        return new DatagramPacket(buf, buf.length, group, port);
    }
    public static DatagramPacket create_receive(byte[] buf) {
        return new DatagramPacket(buf, buf.length);
    }
}
