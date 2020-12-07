package com.mehdi.learning.chat;

public interface Member {
    void notify(Member from, String message);
    String getLatestMessage();
    String gteName();
}
