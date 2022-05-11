package com.spring.notes.repositories;

import com.spring.notes.entities.Note;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface NoteRepository extends CrudRepository<Note, Long> {

    @Modifying
    @Query("insert into notes (title, content, date, notebooks_key) values (:title, :content, :date, :notebookId)")
    void addNote(@Param("notebookId") long notebookId, @Param("title") String title,
                 @Param("content") String content, @Param("date")Date date);

    @Modifying
    @Query("delete from notes where note_id = :noteId")
    void deleteNote(@Param("noteId") long noteId);
}
