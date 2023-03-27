package com.codeup.codeupspringblog.models;

public class Post {
    protected String title;
    protected String body;

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

    public Post(String title, String body){
        this.title = title;
        this.body = body;
    }
}
