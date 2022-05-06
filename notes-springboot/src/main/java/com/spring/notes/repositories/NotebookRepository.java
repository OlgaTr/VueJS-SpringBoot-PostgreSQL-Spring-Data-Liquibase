package com.spring.notes.repositories;

import com.spring.notes.entities.Note;
import com.spring.notes.entities.Notebook;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface NotebookRepository extends CrudRepository<Notebook, Long> {

    @Query("select * from notes where notebooks_key=:notebookId")
    List<Note> findNotes(@Param("notebookId") long id);
}
