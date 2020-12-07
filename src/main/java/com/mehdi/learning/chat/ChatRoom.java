package com.mehdi.learning.chat;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom implements MyObservable {
    private String name;
    private List<MyObserver> myObservers = new ArrayList<>();

    public ChatRoom(String name) {
        this.name = name;
    }

    public void subscribe(MyObserver myObserver) {
        myObservers.add(myObserver);
    }

    public void sendMessage(MyObserver from, String message) {
        myObservers.forEach(m-> m.notify(from , message));
    }

    @Override
    public boolean isMember(MyObserver myObserver) {
        return myObservers.contains(myObserver);
    }
}
