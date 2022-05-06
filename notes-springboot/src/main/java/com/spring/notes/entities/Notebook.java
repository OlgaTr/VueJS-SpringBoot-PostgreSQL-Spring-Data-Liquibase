package com.spring.notes.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Table("notebooks")
public class Notebook {

    @Column("notebook_id")
    private @Id long id;
    private String theme;
//    @MappedCollection(idColumn = "notebooks_key")
//    private List<Note> notes;

//    public void addNote(Note note) {
//        notes.add(note);
//    }


    public Notebook(long id, String theme) {
        this.id = id;
        this.theme = theme;
//        this.notes = notes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

}
