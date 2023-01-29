package com.urunsiyabend.fs;

import com.urunsiyabend.exceptions.FileAlreadyExistsException;
import com.urunsiyabend.exceptions.FileComponentNotFoundException;
import com.urunsiyabend.exceptions.GroupNotFoundException;
import com.urunsiyabend.exceptions.UserNotFoundException;
import com.urunsiyabend.users.Group;
import com.urunsiyabend.users.User;

import java.util.Date;

public abstract class FileComponent {
    private static final int GB_SIZE = 1024 * 1024 * 1024;
    private static final int MB_SIZE = 1024 * 1024;
    private static final int KB_SIZE = 1024;
    private static int C = 1;

    private String name;
    private String path;
    private int diskSize;
    private Date creationDate;
    private Date updateDate;
    private int inode;
    private int ownerID;
    private int ownerGroupID;

    public int getInode() {
        return inode;
    }

    private void setInode(int inode) {
        this.inode = inode;
    }



    public FileComponent(String name, int diskSize, int ownerID, int ownerGroupID) {
        setName(name);
        setDiskSize(diskSize);
        setCreationDate(new Date());
        setPath("");
        update();
        setInode(C);
        setOwnerID(ownerID);
        setOwnerGroupID(ownerGroupID);
        C++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        update();
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        update();
        this.path = path;
    }

    public int getDiskSize() {
        return diskSize;
    }

    public void setDiskSize(int diskSize) {
        update();
        this.diskSize = diskSize;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    private void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    private void setUpdateDate(Date updateDate) {
//        TODO: Update compare bug
//        if (updateDate.compareTo(creationDate) > 0) {
//            throw new IllegalArgumentException("Update date cannot be older than creation date");
//        }
        this.updateDate = updateDate;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    public int getOwnerGroupID() {
        return ownerGroupID;
    }

    public void setOwnerGroupID(int ownerGroupID) {
        this.ownerGroupID = ownerGroupID;
    }

    private void update() {
        setUpdateDate(new Date());
    }

    public void insert(FileComponent f) throws UnsupportedOperationException, FileAlreadyExistsException {
        throw new UnsupportedOperationException();
    }

    public void pointTo(FileComponent f) throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }

    public void remove(FileComponent f) throws UnsupportedOperationException, FileComponentNotFoundException{
        throw new UnsupportedOperationException();
    }

    public FileComponent child(int i) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    public int find(FileComponent f) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    public String getDiskSizeH() {
        return _convertDiskSizeToHumanReadable(diskSize);
    }

    private static String _convertDiskSizeToHumanReadable(int diskSize) {
        String suffix;
        float _diskSize;
        if(diskSize > GB_SIZE) {
            _diskSize = (float)diskSize / GB_SIZE;
            suffix = "GB";
        }
        else if(diskSize > MB_SIZE) {
            _diskSize = (float)diskSize / MB_SIZE;
            suffix = "MB";
        }
        else if(diskSize > KB_SIZE) {
            _diskSize = (float)diskSize / KB_SIZE;
            suffix = "KB";
        }
        else {
            _diskSize = (float)diskSize;
            suffix = "B";
        }
        return String.format("%.2f%s", _diskSize, suffix);
    }

    public void display() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    public void displayR() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    protected void _displayChildren() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
//        TODO: What if user not exist?
//        User owner;
//        try {
//            owner = User.get(ownerID);
//        }
//        catch (UserNotFoundException ex) {
//            ex.printStackTrace();
//            System.exit(0);
//        }
//
//        Group ownerGroup;
//        try {
//            ownerGroup = Group.get(ownerGroupID);
//        }
//        catch (GroupNotFoundException ex) {
//            ex.printStackTrace();
//            System.exit(0);
//        }

        return "FileComponent{" +
                "name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", diskSize=" + diskSize +
                ", creationDate=" + creationDate +
                ", updateDate=" + updateDate +
                ", inode=" + inode +
                ", owner=" + ownerID +
                ", group= " + ownerGroupID +
                '}';
    }
}
