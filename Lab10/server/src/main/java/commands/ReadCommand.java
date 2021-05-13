package commands;

import server.Server;

import java.io.PrintWriter;

public class ReadCommand {
    private String currentUser;
    private PrintWriter out;

    public ReadCommand(String currentUser, PrintWriter out) {
        this.currentUser = currentUser;
        this.out = out;
    }

    public void run()
    {
        System.out.println("dasda");
        out.println(Server.messages.getUserMessages(currentUser));
    }
}
