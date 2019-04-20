package com.example.myapplication;

public class RawList {
    String stop;
    String id;
    String level;
    boolean man;
    String name;
    String place;
    String start;

    public RawList(String end, String id, String level, boolean man, String name, String place, String start){
        this.stop = end;
        this.id = id;
        this.level = level;
        this.man = man;
        this.name = name;
        this.place = place;
        this.start = start;
    }

    public RawList(){}
}
