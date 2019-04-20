package com.example.myapplication;

public class Profile {

    int height;
    String main;
    String name;
    String region;
    String sub;
    int weight;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Profile(int height, String main, String name, String region, String sub, int weight) {
        this.height = height;
        this.main = main;
        this.name = name;
        this.region = region;
        this.sub = sub;
        this.weight = weight;
    }

    public Profile() {
    }

}
