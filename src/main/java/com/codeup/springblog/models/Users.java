package com.codeup.springblog.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")

public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 30)
    private long username;

    @Column(nullable = false, length = 200)
    private long email;

    @Column(nullable = false, length = 16)
    private long password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Post> posts;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUsername() {
        return username;
    }

    public void setUsername(long username) {
        this.username = username;
    }

    public long getEmail() {
        return email;
    }

    public void setEmail(long email) {
        this.email = email;
    }

    public long getPassword() {
        return password;
    }

    public void setPassword(long password) {
        this.password = password;
    }

    public Users(){};

    public Users(long id, long username, long email, long password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Users(long username, long email, long password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
