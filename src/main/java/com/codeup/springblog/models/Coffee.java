package com.codeup.springblog.models;
// This is a POJO aka Plain Old Java Object
public class Coffee {
    private String roast;
    private String origin;

    public Coffee() {
    }

    public Coffee(String roast, String origin) {
        this.roast = roast;
        this.origin = origin;
    }

    public String getRoast() {
        return roast;
    }

    public void setRoast(String roast) {
        this.roast = roast;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
