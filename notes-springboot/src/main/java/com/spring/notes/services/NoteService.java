package com.spring.notes.services;

import com.spring.notes.records.Note;

import java.util.List;

public interface NoteService {
    List<Note> findAll();
}
