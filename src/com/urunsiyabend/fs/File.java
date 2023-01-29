package com.urunsiyabend.fs;

public class File extends FileComponent{

    public File(String name, int diskSize, int ownerID, int groupOwnerID) {
        super(name, diskSize, ownerID, groupOwnerID);
    }

    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "File: " + super.toString();
    }
}
