package data;

import java.util.HashSet;
import java.util.Set;

public class User {
    private Set<String> users = new HashSet<>();

    public Set<String> getUsers()
    {

        return users;

    }

    public void addUser(String name)
    {
        this.users.add(name);
    }

    @Override
    public String toString()
    {

        return "users{" +
                "users=" + users +
                '}';

    }
}
