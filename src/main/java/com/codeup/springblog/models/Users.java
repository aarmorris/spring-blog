package com.codeup.springblog.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    //    Unique = true does not let duplicates
    @Column(nullable = false, length = 80, unique = true)
    private String email;

    @Column(nullable = false, length = 50)
    private String username;

    @Column(nullable = false, length = 255)
    private String  password;

    //    This is for the relationship exercise
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    public List<Post> posts;

//    Getters and setters


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    //    Constructors


    public Users() {
    }


    public Users(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public Users(long id, String email, String username, String password) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
    }


    public Users(long id, String email, String username, String password, List<Post> posts) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.posts = posts;
    }



}