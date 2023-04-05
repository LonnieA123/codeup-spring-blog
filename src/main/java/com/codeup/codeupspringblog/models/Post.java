package com.codeup.codeupspringblog.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    @Column(nullable = false, length = 200)
    protected String title;
    @Column(nullable = false, length = 500)
    protected String body;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;



    public Post(String title, String body, User user){
        this.title = title;
        this.body = body;
        this.user = user;
    }

    public Post() {
    }
    public Post(String title, String body){
        this.title = title;
        this.body = body;
    }

    public Post(long id, String title, String body){
        this.id = id;
        this.title = title;
        this.body = body;
    }


    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }


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


}
