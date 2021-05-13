package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Friendships {
    private Map<String, List<String>> friendships = new HashMap<>();

    public List<String> getFriendship(String name)
    {

        return friendships.get(name);

    }

    public void addFriendship(String name1, String name2)
    {
        if(!this.friendships.containsKey(name1))
            this.friendships.put(name1, new ArrayList<>());

        this.friendships.get(name1).add(name2);

        if(!this.friendships.containsKey(name2))
            this.friendships.put(name2, new ArrayList<>());

        this.friendships.get(name2).add(name1);
    }

    @Override
    public String toString()
    {

        return "Friendships{" +
                "friendships=" + friendships +
                '}';

    }
}
