package com.codeup.springblog.models;

public class Post {
// Variable instances down below.
    private String title;
    private String body;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Post(){};

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }
}
