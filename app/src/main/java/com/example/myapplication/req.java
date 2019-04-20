package com.example.myapplication;

public class req {
    String from;
    String to;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public req(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public req(){}
}
