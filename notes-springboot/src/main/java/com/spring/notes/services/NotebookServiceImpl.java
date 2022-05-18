package com.spring.notes.services;

import com.spring.notes.entities.Notebook;
import com.spring.notes.repositories.NoteRepository;
import com.spring.notes.repositories.NotebookRepository;
import org.springframework.stereotype.Service;

@Service
public class NotebookServiceImpl implements NotebookService{
    private final NotebookRepository notebookRepository;

    public NotebookServiceImpl(NotebookRepository notebookRepository) {
        this.notebookRepository = notebookRepository;
    }

    @Override
    public Notebook getNotebook(String username) {
        return notebookRepository.findNotebookByUsername(username);
    }
}
