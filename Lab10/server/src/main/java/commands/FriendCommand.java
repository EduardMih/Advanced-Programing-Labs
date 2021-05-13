package commands;

import server.Server;

import java.util.HashSet;
import java.util.Set;

public class FriendCommand{
    private String currentUser;
    private Set<String> friends = new HashSet<>();

    public FriendCommand(String currentUser, Set<String> friends) {
        this.currentUser = currentUser;
        this.friends = friends;
    }

    public void run()
    {
        for(String name : friends)
            Server.friendships.addFriendship(currentUser, name);
    }

}
