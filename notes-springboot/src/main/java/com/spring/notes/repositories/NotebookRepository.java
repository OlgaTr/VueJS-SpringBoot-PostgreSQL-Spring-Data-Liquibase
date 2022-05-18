package com.spring.notes.repositories;

import com.spring.notes.entities.Notebook;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NotebookRepository extends CrudRepository<Notebook, Long> {

    @Modifying
    @Query("insert into notebooks (username) values (:username)")
    void createNotebook(@Param("username") String username);

    @Query("select * from notebooks where username = :username")
    Notebook findNotebookByUsername(@Param("username") String username);
}
