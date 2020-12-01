package com.study.test.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import com.study.test.TestApplicationTests;
import com.study.test.model.entity.User;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class UserRepositoryTest extends TestApplicationTests {

    // Dependency Injection (DI)
    @Autowired // 직접 객체를 만들지 않고, 스프링이 관리 함. 의존성 주입시켜줌.
    private UserRepository userRepository;

    @Test
    public void create() {
        // String sql = insert into user ( %s, %s ,,,) value (account, email, age); ...

        String account = "Test01";
        String password = "Test01";
        String status = "REGISTERED";
        String email = "Test01@gmail.com";
        String phoneNumber = "010-1111-2222";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);
        user.setCreatedAt(createdAt);
        user.setCreatedBy(createdBy);

        User newUser = userRepository.save(user);

        Assertions.assertNotNull(newUser);
    }

    @Test
    @Transactional
    public void read() {

        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");
        Assertions.assertNotNull(user);
    }

    @Test
    public void update() {
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectUser -> {
            selectUser.setAccount("PPPP");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            userRepository.save(selectUser);
        });

    }

    @Test
    @Transactional
    public void delete() {
        Optional<User> user = userRepository.findById(3L);

        Assertions.assertTrue(user.isPresent()); // true

        user.ifPresent(selectUser -> {
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(3L);

        Assertions.assertFalse(deleteUser.isPresent()); // false

        // if (deleteUser.isPresent()) {
        // System.out.println("데이터 존재 : " + deleteUser.get());
        // } else {
        // System.out.println("데이터 삭제 , 데이터 없음");
        // }
    }
}
