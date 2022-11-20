package com.codeup.springblog.models;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Table(name="Posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
// Variable instances down below.
    @Column(nullable = false, length = 50)
    private String title;
    @Column(nullable = false)
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

    public Post(String title, String body){
        this.title = title;
        this.body = body;

    }
}
