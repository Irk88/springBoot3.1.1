package com.example.web.dao;

import com.example.web.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDaoRepository extends JpaRepository<Role, Long> {
    @Query("SELECT r FROM Role r where r.role=:role")
    Role getRoleByRoleName(@Param("role") String role);
}
