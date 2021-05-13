package commands;

import serverutils.ClientThread;

public class LoginCommand{
    private String username;
    private ClientThread clientThread;

    public LoginCommand(String username, ClientThread clientThread) {
        this.username = username;
        this.clientThread = clientThread;
    }

    public void run()
    {
        clientThread.setUsername(username);
    }
}
