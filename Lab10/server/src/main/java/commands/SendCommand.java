package commands;

import data.Message;
import server.Server;

public class SendCommand {
    private String currentUser;
    private String message;

    public SendCommand(String currentUser, String message) {
        this.currentUser = currentUser;
        this.message = message;
    }

    public void run()
    {
        Server.messages.addMessage(Server.friendships.getFriendship(currentUser),
                new Message(currentUser, message));
    }


}
