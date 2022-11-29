package com.codeup.springblog.models;

import com.codeup.springblog.repositories.PostRepository;

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
    @Column(nullable = false, length = 100)
    private String title;
    @Column(nullable = false, length = 2000)
    private String body;
    @ManyToOne
    @JoinColumn (name = "user_id")
    private Users user;

    public String getTitle() {
        return this.title;
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
