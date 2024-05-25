package com.example.softwareproject3_1;

public class BlogPost {
    private String title;
    private String content;
    private String subject;

    public BlogPost() {
        // Required empty constructor for Firebase Realtime Database
    }

    public BlogPost(String title, String content, String subject) {
        this.title = title;
        this.content = content;
        this.subject = subject;
    }

    // Getters and setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
}
