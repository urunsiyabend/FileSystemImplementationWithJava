package com.urunsiyabend.users;

import com.urunsiyabend.exceptions.UserNotFoundException;

import java.util.ArrayList;

public class User {
    private int UID;
    private String name;
    private final static ArrayList<User> users = new ArrayList<>();

    public User(int UID, String name) {
        setUID(UID);
        setName(name);
        users.add(this);
    }

    public static User get(int UID) throws UserNotFoundException {
        for (User user: users)
            if (user.UID == UID)
                return user;
        throw new UserNotFoundException("User does not exists!");
    }

    public static boolean isExists(int UID) {
        for (User user : users) {
            if (user.UID == UID) {
                return true;
            }
        }
        return false;
    }


    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getGroupIDs() {
        ArrayList<Integer> groupIDs = new ArrayList<>();
        for (UserGroup userGroup : UserGroup.userGroups) {
            if (userGroup.getUID() == UID) {
                groupIDs.add(userGroup.getGID());
            }
         }
        // TODO: Throw exception if there is no any group
        return groupIDs;
    }

    @Override
    public String toString() {
        return "User{" +
                "UID=" + UID +
                ", name='" + name + '\'' +
                '}';
    }
}
