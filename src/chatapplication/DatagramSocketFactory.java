package chatapplication;

import java.net.DatagramSocket;
import java.net.SocketException;

public class DatagramSocketFactory {
    public static DatagramSocket create() throws SocketException {
        return new DatagramSocket();
    }
}
