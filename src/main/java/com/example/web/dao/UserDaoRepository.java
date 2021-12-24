package com.example.web.dao;


import com.example.web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UserDaoRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u where u.name = :name")
    User getUserByName(@Param("name") String name);
}
