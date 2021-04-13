package com.masiv.callcenter.model;

public class Agent implements Comparable {

    private String name;
    private int id;
    private int priority;
    private int lock;

    public Agent(String name, int id) {
        this.name = name;
        this.id = id;
        this.priority = 0;
        this.lock = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        if (priority > 5){
            System.out.println("Out of range");
        }else {
            this.priority = priority;
        }
    }

    public int getLock() {
        return lock;
    }

    public void setLock(int lock) {
        this.lock = lock;
    }

    @Override
    public int compareTo(Object agent) {
        int comparePriority=((Agent)agent).getPriority();
        /* For Ascending order*/
        return this.priority-comparePriority;
    }

}
