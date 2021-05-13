package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Messages {
    private Map<String, List<Message>> messages = new HashMap<>();

    public List<Message> getUserMessages(String name)
    {

        return messages.get(name);

    }

    public void addMessage(List<String> friends, Message message)
    {
        if(friends != null)
        for(String friend : friends)
        {
            if (!messages.containsKey(friend))
                messages.put(friend, new ArrayList<>());
            messages.get(friend).add(message);
        }
    }

}
