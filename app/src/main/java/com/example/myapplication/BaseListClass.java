package com.example.myapplication;

import java.util.Date;

/**
 * Created by jyj on 2017-05-21.
 */

public class BaseListClass {
    public String title;
    public String start;
    public String stop;
    public String id;
    public String place;


    public BaseListClass(String title,  String id, String place, String start, String stop) {
        this.title = title;
        this.start = start;
        this.stop = stop;
        this.id = id;
        this.place = place;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getId() {
        return id;
    }

    public String getPlace() {
        return place;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getStop() {
        return stop;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setId(String id) {
        this.id = id;
    }

}
