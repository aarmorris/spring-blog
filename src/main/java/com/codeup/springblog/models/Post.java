package com.codeup.springblog.models;

import javax.persistence.*;

@Entity
@Table(name="post")

public class Post {
//  Instances

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false, length = 100)
    private String body;

// Getters and Setters


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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }




    //    Many to one
    @ManyToOne
//    @JoinColumn(name = "user_id")
    private Users user;


    //    Constructor

    public Post() {
    }


    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Post(long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Post(String title, String body, Users user) {
        this.title = title;
        this.body = body;
        this.user = user;
    }

    public Post(long id, String title, String body, Users user) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.user = user;
    }




}