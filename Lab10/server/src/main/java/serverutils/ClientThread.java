//Hamza Eduard-Mihail, 2A4
package serverutils;

import commands.CommandExecutor;
import commands.RegisterCommand;
import server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread{
    private Socket socket = null;
    public String username;

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
            socket.setSoTimeout(120*1000); //timeout after 2 minutes
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

                    {
                    System.out.println("Server[ " + username + "] received request " + request);

                    CommandExecutor commandExecutor = new CommandExecutor(username, this, out);
                    commandExecutor.execute(request);

                }
            }

        }
        catch(IOException e)
        {
            System.out.println("Communication error" + e.getMessage());
        }
    }

    public String getUsername()
    {

        return username;

    }

    public void setUsername(String username) {
        this.username = username;
    }
}
