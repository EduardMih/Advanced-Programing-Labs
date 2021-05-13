//Hamza Eduard-Mihail, 2A4
package server;

import data.Friendships;
import data.Messages;
import data.User;
import serverutils.ClientThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public static final int PORT = 8100;
    public static boolean running = true;
    public static User users = new User();
    public static Friendships friendships = new Friendships();
    public static Messages messages = new Messages();

    public Server() throws IOException
    {
        ServerSocket serverSocket = null;
        List<ClientThread> clientThreads = new ArrayList<>();

        try
        {
            serverSocket = new ServerSocket(PORT);
            while(running)
            {
                System.out.println("[Server] Waiting for client...");
                Socket clientSocket = serverSocket.accept();

                clientThreads.add(new ClientThread(clientSocket));
                clientThreads.get(clientThreads.size() - 1).start();

                if(!running)
                {
                    for(ClientThread clientThread : clientThreads)
                        clientThread.join();
                }

            }
        }
        catch(IOException | InterruptedException e)
        {
            System.out.println("ERROR" + e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException
    {
        Server server = new Server();
    }
}
