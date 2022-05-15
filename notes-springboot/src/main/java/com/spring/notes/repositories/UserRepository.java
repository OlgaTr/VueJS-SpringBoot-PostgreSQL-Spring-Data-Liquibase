package com.spring.notes.repositories;

import com.spring.notes.entities.User;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

    @Query("select * from users where username = :username")
    User findByName(@Param("username") String username);

    @Modifying
    @Query("insert into users (username, password) values (:username, :password)")
    void addUser(@Param("username") String username, @Param("password") String password);

    @Modifying
    @Query("insert into cuser (username, password) values (:username, :password)")
    void setCurrentUser(@Param("username") String username, @Param("password") String password);

    @Modifying
    @Query("delete from cuser")
    void clean();

    @Query("select * from cuser")
    User getCurrentUser();
}
