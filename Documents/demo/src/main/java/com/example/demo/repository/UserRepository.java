package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository
    extends JpaRepository<User, Long> {

    @Query("SELECT new User (u.id, u.fullName, u.email, d.name)"
        + " FROM User u"
        + " JOIN Department d ON d.id = u.departmentId"
        + " WHERE (:departmentId IS NULL OR u.departmentId = :departmentId)")
    List<User> fetchUserByDepartmentId(@Param("departmentId") Long departmentId);
}
