package com.urunsiyabend.users;

import com.urunsiyabend.exceptions.GroupNotFoundException;
import com.urunsiyabend.exceptions.UserNotExistInGroupException;
import com.urunsiyabend.exceptions.UserNotFoundException;

public class UserManager {
    private static UserManager instance;

    private UserManager() {}

    public static UserManager getInstance() {
        if (instance == null) instance = new UserManager();
        return instance;
    }

    public boolean auth(String UID, String password) {
        return true;
    }

    public void addToGroup(int UID, int GID) throws UserNotFoundException, GroupNotFoundException {
        if (!User.isExists(UID)) {
            throw new UserNotFoundException("User not found!");
        } if (!Group.isExists(GID)) {
            throw new GroupNotFoundException("Group not found!");
        }

        UserGroup newUserGroup = new UserGroup(UID, GID);
        for (UserGroup userGroup : UserGroup.userGroups) {
            if (userGroup.getUID() == newUserGroup.getUID() && userGroup.getGID() == newUserGroup.getGID()) {
                // XXX: Throw user is already in this group exception
                return;
            }
        }
        UserGroup.userGroups.add(newUserGroup);
    }

    public void removeFromGroup(int UID, int GID) throws UserNotExistInGroupException, UserNotFoundException, GroupNotFoundException {
        if (!User.isExists(UID)) {
            throw new UserNotFoundException("User not found!");
        } if (!Group.isExists(GID)) {
            throw new GroupNotFoundException("Group not found!");
        }

        for (int i = 0; i < UserGroup.userGroups.size(); i++) {
            UserGroup userGroup = UserGroup.userGroups.get(i);
            if (userGroup.getUID() == UID && userGroup.getGID() == GID) {
                UserGroup.userGroups.remove(i);
                return;
            }
        }

        throw new UserNotExistInGroupException("User not exist in group!");
    }


}
