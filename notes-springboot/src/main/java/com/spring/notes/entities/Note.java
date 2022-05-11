package com.spring.notes.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.Date;

@Table("notes")
public class Note {

    private @Id long noteId;
    private String title;
    private String content;
    private LocalDate date;

    public Note(String title, String content, LocalDate date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public long getNoteId() {
        return noteId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Note{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                '}';
    }
}
