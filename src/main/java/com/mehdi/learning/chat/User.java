package com.mehdi.learning.chat;

import java.util.ArrayList;
import java.util.List;

public class User implements MyObserver {
    private String name;
    private List<String> messages = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    @Override
    public void notify(MyObserver from, String message) {
        messages.add( from.gteName() + ", " + message);
    }

    @Override
    public String getLatestMessage() {
        return messages.get(messages.size() - 1);
    }

    @Override
    public String gteName() {
        return name;
    }
}
