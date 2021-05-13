package commands;

import serverutils.ClientThread;

import java.io.PrintWriter;
import java.util.*;

public class CommandExecutor {
    private String currentUser;
    private ClientThread clientThread;
    private String request;
    private String command;
    private List<String> params = new ArrayList<>();
    private List<String> knownCommands = new ArrayList<>(Arrays.asList("register", "login", "friend", "send", "read"));
    private PrintWriter out;

    public CommandExecutor(String currentUser, ClientThread clientThread, PrintWriter out) {
        this.currentUser = currentUser;
        this.clientThread = clientThread;
        this.out = out;
    }

    private void parseRequest()
    {
        String[] spl = request.split(" ");

        command = spl[0];

        params.addAll(Arrays.asList(spl).subList(1, spl.length));
    }

    private boolean validateCommand()
    {
        if(!knownCommands.contains(command))

            return false;

        return true;

    }

    public void execute(String request)
    {
        this.request = request;

        parseRequest();

        if(validateCommand())
        {
            if("register".equals(command))
                new RegisterCommand(params.get(0)).run();

            if("login".equals(command))
                new LoginCommand(params.get(0), clientThread).run();

            if("friend".equals(command))
                new FriendCommand(currentUser, new HashSet<>(params)).run();

            if("send".equals(command))
                new SendCommand(currentUser, params.get(0)).run();

            if("read".equals(command))
                new ReadCommand(currentUser, out).run();

        }
    }
}
