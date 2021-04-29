//Hamza Eduard-Mihail, 2A4
package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Objects;
import java.util.Scanner;

public class Client {
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args)
    {
        String serverAddress = "127.0.0.1";
        String command = "";
        int PORT = 8100;

        try(Socket socket = new Socket(serverAddress, PORT);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())))
        {
            while(true)
            {
                command = getUserCommand();
                if("exit".equals(command))
                    break;

                out.println(command);
                System.out.println("[Client] received: " + in.readLine());
            }

        }
        catch(IOException e)
        {
            System.out.println("No server listening " + e.getMessage());
        }
    }

    public static String getUserCommand()
    {

        return input.nextLine();

    }

}
