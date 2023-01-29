package com.urunsiyabend.users;

import com.urunsiyabend.exceptions.GroupNotFoundException;

import java.util.ArrayList;

public class Group {
    private int GID;
    private String name;
    private final static ArrayList<Group> groups = new ArrayList<>();

    public Group(int GID, String name) {
        this.GID = GID;
        this.name = name;
        groups.add(this);
    }


    public static Group get(int GID) throws GroupNotFoundException {
        for (Group group: groups)
            if (group.GID == GID)
                return group;
        throw new GroupNotFoundException("Group does not exists!");
    }

    public static boolean isExists(int GID) {
        for (Group group: groups)
            if (group.GID == GID)
                return true;
        return false;
    }

    public int getGID() {
        return GID;
    }

    public void setGID(int GID) {
        this.GID = GID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getUserIDs() {
        ArrayList<Integer> userIDs = new ArrayList<>();
        for (UserGroup userGroup : UserGroup.userGroups) {
            if (userGroup.getGID() == GID) {
                userIDs.add(userGroup.getUID());
            }
        }
        // TODO: Throw error if there is no any user
        return userIDs;
    }

    @Override
    public String toString() {
        return "Group{" +
                "GID=" + GID +
                ", name='" + name + '\'' +
                '}';
    }
}
