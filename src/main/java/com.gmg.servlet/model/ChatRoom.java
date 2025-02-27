package model;


public class ChatRoom {
    private int id;
    private String name;
    private int userCount;

    public ChatRoom(int id, String name, int userCount) {
        this.id = id;
        this.name = name;
        this.userCount = userCount;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getUserCount() {
        return userCount;
    }
}

