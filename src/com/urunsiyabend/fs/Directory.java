package com.urunsiyabend.fs;

import com.urunsiyabend.exceptions.FileAlreadyExistsException;
import com.urunsiyabend.exceptions.FileComponentNotFoundException;

import java.util.ArrayList;

public class Directory extends FileComponent {
    private final ArrayList<FileComponent> fcs;

    public Directory(String name, int diskSize, int ownerID, int groupOwnerID) {
        super(name, diskSize, ownerID, groupOwnerID);
        fcs = new ArrayList<>();
    }

    @Override
    public void insert(FileComponent f) throws FileAlreadyExistsException {
        for (FileComponent fc : fcs) {
            if (fc.getName().equals(f.getName())) {
                throw new FileAlreadyExistsException("A file already exists with same name");
            }
        }
        f.setPath(this.getPath() + "/" + f.getName());
        fcs.add(f);
    }

    @Override
    public void remove(FileComponent f) throws FileComponentNotFoundException, UnsupportedOperationException {
        if (!fcs.contains(f)) {
            throw new FileComponentNotFoundException("File does not exists!");
        }

        fcs.remove(f);
    }

    @Override
    public FileComponent child(int i) {
        return fcs.get(i);
    }

    @Override
    public int find(FileComponent f) {
        return fcs.indexOf(f);
    }

    public void display() {
        System.out.println(this);
        _displayChildren();
    }

    protected void _displayChildren() {
        for (FileComponent fc : fcs) {
            System.out.print("-");
            System.out.println(fc);
            if (fc instanceof Directory) {
                fc._displayChildren();
            }
        }
    }

    @Override
    public String toString() {
        return "Directory: " + super.toString();
    }
}
