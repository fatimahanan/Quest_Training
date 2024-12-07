package com.quest.interviewQ.InterviewDay20.PlaylistManager;

import java.util.HashMap;
import java.util.Map;

public class UserManager
{
    private Map<String, User> users = new HashMap<>();

    // Creating a user
    public User createUser(String username)
    {
        if (!users.containsKey(username))
        {
            User newUser = new User(username);
            users.put(username, newUser);
            return newUser;
        }
        else
        {
            System.out.println("User already exists.");
            return null;
        }
    }

    // Selecting a user
    public User selectUser(String username)
    {
        User user = users.get(username);
        if (user == null)
        {
            System.out.println("User not found.");
        }
        return user;
    }

    public boolean isUserExists(String username) {
        return users.containsKey(username);
    }

    public User getUser(String username) {
        return users.get(username);
    }

    public void displayAllUsers()
    {
        for(String name : users.keySet())
        {
            System.out.println(name);
        }
    }

}
