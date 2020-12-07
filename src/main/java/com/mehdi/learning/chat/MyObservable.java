package com.mehdi.learning.chat;

public interface MyObservable {
    void subscribe(Member member);
    void sendMessage(Member from, String message);
    boolean isMember(Member member);
}
