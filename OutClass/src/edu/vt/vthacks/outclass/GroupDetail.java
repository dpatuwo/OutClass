package edu.vt.vthacks.outclass;

import java.io.Serializable;

public class GroupDetail implements Serializable
{
    private final String name;
    private final String theClass;


    public GroupDetail(String name, String theClass) {
        this.name = name;
        this.theClass = theClass;
    }

    public String getName() {
        return name;
    }

    public String getTheClass() {
        return theClass;
    }

    public String toString() {
        return null; //TODO
    }
}
