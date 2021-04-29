//Hamza Eduard-Mihail, 2A4
package serverutils;

import server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread{
    private Socket socket = null;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run()
    {
        try(BufferedReader in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true))
        {

            String request;
            while((request = in.readLine()) != null)
            {
                if (request.equals("stop"))
                {
                    out.println("server.Server stopped");
                    //System.exit(0);
                    Server.running = false;
                    new SoftlyKiller().run();
                    break;
                }

                else

                    out.println("server.Server received request " + request);
            }

        }
        catch(IOException e)
        {
            System.out.println("Communication error" + e.getMessage());
        }
    }
}
