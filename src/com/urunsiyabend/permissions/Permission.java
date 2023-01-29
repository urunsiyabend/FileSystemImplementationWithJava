package com.urunsiyabend.permissions;

public class Permission {
    public boolean read;

    public boolean hasReadPermission() {
        return read;
    }

    public void setReadPermission(boolean read) {
        this.read = read;
    }

    public boolean hasWritePermission() {
        return write;
    }

    public void setWritePermission(boolean write) {
        this.write = write;
    }

    public boolean hasExecPermission() {
        return exec;
    }

    public void setExecPermission(boolean exec) {
        this.exec = exec;
    }

    public Permission(boolean read, boolean write, boolean exec) {
        setReadPermission(read);
        setWritePermission(write);
        setExecPermission(exec);
    }


    public boolean write;
    public boolean exec;
}
