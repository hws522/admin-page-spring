package com.study.test.repository;

import java.util.Optional;

import com.study.test.model.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // select * from user where account = ? << test03, test04
    Optional<User> findByAccount(String account);

    Optional<User> findByEmail(String email);

    // select * from user where account = ? and email = ?
    Optional<User> findByAccountAndEmail(String account, String email);
}
