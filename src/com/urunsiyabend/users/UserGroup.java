package com.urunsiyabend.users;

import java.util.ArrayList;

public class UserGroup {
    private int UID;
    private int GID;

    public static ArrayList<UserGroup> userGroups = new ArrayList<>();

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public int getGID() {
        return GID;
    }

    public void setGID(int GID) {
        this.GID = GID;
    }

    public UserGroup(int UID, int GID) {
        this.UID = UID;
        this.GID = GID;
    }
}
