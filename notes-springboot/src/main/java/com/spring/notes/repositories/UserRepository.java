package com.spring.notes.repositories;

import com.spring.notes.entities.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query("select * from users where username = :username")
    User findByName(@Param("username") String username);
}
