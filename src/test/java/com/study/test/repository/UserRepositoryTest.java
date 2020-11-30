package com.study.test.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import com.study.test.TestApplicationTests;
import com.study.test.model.entity.Item;
import com.study.test.model.entity.User;

import org.junit.jupiter.api.Assertions;
import org.assertj.core.api.Assert;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.xmlunit.diff.Comparison.Detail;

public class UserRepositoryTest extends TestApplicationTests {

    // Dependency Injection (DI)
    @Autowired // 직접 객체를 만들지 않고, 스프링이 관리 함. 의존성 주입시켜줌.
    private UserRepository userRepository;

    @Test
    public void create() {
        // String sql = insert into user ( %s, %s ,,,) value (account, email, age); ...
        User user = new User();
        user.setAccount("TestUser03");
        user.setEmail("TestUser03@gmail.com");
        user.setPhoneNumber("010-1234-3333");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("TestUser3");

        User newUser = userRepository.save(user);
        System.out.println("newUser : " + newUser);
    }

    @Test
    @Transactional
    public void read() {
        Optional<User> user = userRepository.findById(4L);

        user.ifPresent(selectUser -> {
            selectUser.getOrderDetailList().stream().forEach(detail -> {

                Item item = detail.getItem();
                System.out.println(item);
            });
        });
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
