package org.example.javadevhomework14.model;

import lombok.*;


public class Note {
    private Long Id;
    private String title;
    private String content;

    @Override
    public String toString() {
        return "Note{" +
                "Id=" + Id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Note(Long id, String title, String content) {
        Id = id;
        this.title = title;
        this.content = content;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
