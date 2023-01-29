package com.urunsiyabend.fs;

import com.urunsiyabend.exceptions.FileAlreadyExistsException;
import com.urunsiyabend.exceptions.GroupNotFoundException;
import com.urunsiyabend.exceptions.UserNotFoundException;
import com.urunsiyabend.users.Group;
import com.urunsiyabend.users.User;
import com.urunsiyabend.users.UserManager;

public class Main {

    public static void main(String[] args) {
        User siyabend = new User(2, "Siyabend");
        Group siyabendGroup = new Group(2, "SiyabendGroup");

        try {
            UserManager.getInstance().addToGroup(siyabend.getUID(), siyabendGroup.getGID());
        }
        catch (UserNotFoundException | GroupNotFoundException e) {
            e.printStackTrace();
        }

        Directory home = new Directory("/",  1024, siyabend.getUID(), siyabend.getGroupIDs().get(0));
        Directory bin = new Directory("bin", 200, siyabend.getUID(), siyabend.getGroupIDs().get(0));
        File ls = new File("ls", 300, siyabend.getUID(), siyabend.getGroupIDs().get(0));
        Directory gcc = new Directory("gcc", 400, siyabend.getUID(), siyabend.getGroupIDs().get(0));
        File comp = new File(".comp", 300, siyabend.getUID(), siyabend.getGroupIDs().get(0));

        try {
            home.insert(bin);
            bin.insert(gcc);
            gcc.insert(comp);
            bin.insert(ls);
        }
        catch (FileAlreadyExistsException ex) {
            ex.printStackTrace();
        }

        home.display();

    }
}
