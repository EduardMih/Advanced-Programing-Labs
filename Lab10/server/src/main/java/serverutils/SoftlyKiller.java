//Hamza Eduard-Mihail, 2A4
package serverutils;

import server.Server;

import java.io.IOException;
import java.net.Socket;

//used to close the socket and interrupt the accept call
public class SoftlyKiller implements Runnable{
    @Override
    public void run()
    {

        String serverAddress = "127.0.0.1";
        int PORT = 8100;

        try (Socket socket = new Socket(serverAddress, PORT))
        {
            System.out.println(Server.users);
            System.out.println(Server.friendships);
            //System.out.println(socket);
            socket.close();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

    }
}
