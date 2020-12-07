package com.mehdi.learning.chat;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom implements MyObservable {
    private String name;
    private List<Member> members = new ArrayList<>();

    public ChatRoom(String name) {
        this.name = name;
    }

    public void subscribe(Member member) {
        members.add(member);
    }

    public void sendMessage(Member from, String message) {
        members.forEach(m-> m.notify(from , message));
    }

    @Override
    public boolean isMember(Member member) {
        return members.contains(member);
    }
}
