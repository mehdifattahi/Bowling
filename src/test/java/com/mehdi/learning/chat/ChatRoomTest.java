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

    private MyObserver createUserAndAddToRoom(String name) {
        MyObserver myObserver1 = new User(name);
        chatRoom.subscribe(myObserver1);
        return myObserver1;
    }

    @Test
    void makeMember() {
        MyObserver myObserver1 = new User("User1");
    }

    @Test
    void subscribeToChatRoom() {
        MyObserver myObserver1 = createUserAndAddToRoom("Jafar");
        assertTrue(chatRoom.isMember(myObserver1));
    }

    @Test
    void sendMessage() {
        MyObserver myObserver1 = createUserAndAddToRoom("User1");
        MyObserver myObserver2 = createUserAndAddToRoom("User2");
        MyObserver myObserver3 = createUserAndAddToRoom("User3");

        final String message = "Hey members!";
        chatRoom.sendMessage(myObserver1, message);

        assertEquals("User1" + ", " + message, myObserver2.getLatestMessage());
        assertEquals("User1" + ", " + message, myObserver3.getLatestMessage());
    }

    @Test
    void givenTwoLists_whenAssertingIterables_thenEquals() {
        Iterable<String> al = new ArrayList<>(asList("Java", "Junit", "Test"));
        Iterable<String> ll = new LinkedList<>(asList("Java", "Junit", "Test"));

        assertIterableEquals(al, ll);
    }
}
