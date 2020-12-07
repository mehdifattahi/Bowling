package com.mehdi.learning.chat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

/*
ChatRoom{
    List<Member> members
    List<Message>

    + subscribe
    + unsubscribe
    + notify
}

Member{
    name
    +sendMessage
}

Message{
    sender
    text
}


*/

class ChatRoomTest {
    private MyObservable chatRoom;

    @BeforeEach
    void setUp() {
        chatRoom = new ChatRoom("Room1");
    }

    private Member createUserAndAddToRoom(String name) {
        Member member1 = new User(name);
        chatRoom.subscribe(member1);
        return member1;
    }

    @Test
    void makeMember() {
        Member member1 = new User("User1");
    }

    @Test
    void subscribeToChatRoom() {
        Member member1 = createUserAndAddToRoom("Jafar");
        assertTrue(chatRoom.isMember(member1));
    }

    @Test
    void sendMessage() {
        Member member1 = createUserAndAddToRoom("User1");
        Member member2 = createUserAndAddToRoom("User2");
        Member member3 = createUserAndAddToRoom("User3");

        final String message = "Hey members!";
        chatRoom.sendMessage(member1, message);

        assertEquals("User1" + ", " + message, member2.getLatestMessage());
        assertEquals("User1" + ", " + message, member3.getLatestMessage());
    }

    @Test
    void givenTwoLists_whenAssertingIterables_thenEquals() {
        Iterable<String> al = new ArrayList<>(asList("Java", "Junit", "Test"));
        Iterable<String> ll = new LinkedList<>(asList("Java", "Junit", "Test"));

        assertIterableEquals(al, ll);
    }
}
