package chatapplication;

import java.io.IOException;
import java.net.MulticastSocket;

public class MulticastSocketFactory {
    public static MulticastSocket create(int port) throws IOException {
        return new MulticastSocket(port);
    }
}
