package commands;

import server.Server;

public class RegisterCommand{
    private String name;

    public RegisterCommand(String name) {
        this.name = name;
    }

    public void run()
    {
        Server.users.addUser(name);
    }
}
