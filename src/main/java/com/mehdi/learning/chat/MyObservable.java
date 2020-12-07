package com.mehdi.learning.chat;

public interface MyObservable {
    void subscribe(MyObserver myObserver);
    void sendMessage(MyObserver from, String message);
    boolean isMember(MyObserver myObserver);
}
