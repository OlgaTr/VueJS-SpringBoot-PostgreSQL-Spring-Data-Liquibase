package com.spring.notes.services;

import com.spring.notes.entities.Note;

import java.util.List;

public interface NoteService {
    List<Note> findAll();
}
