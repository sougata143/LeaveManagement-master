package com.sougata.leavemanagement.repository;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sougata.leavemanagement.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findById(Long i);

    List<User> findByUserName(String userName);

    // custom query example and return a stream
    @Query("select u from User u where u.userName = :userName")
    Stream<User> findByUserNameReturnStream(@Param("userName") String userName);

}
