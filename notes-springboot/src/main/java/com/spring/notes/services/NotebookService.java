package com.spring.notes.services;

import com.spring.notes.entities.Notebook;

public interface NotebookService {
    Notebook getNotebook(String username);
}
