package com.mehdi.learning.chat;

public interface MyObserver {
    void notify(MyObserver from, String message);
    String getLatestMessage();
    String gteName();
}
