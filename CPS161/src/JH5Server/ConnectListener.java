package JH5Server;

import java.net.Socket;

public interface ConnectListener {
    public void handleConnect(Socket s);

}