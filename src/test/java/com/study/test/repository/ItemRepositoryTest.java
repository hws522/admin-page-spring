package com.study.test.repository;

import java.util.Optional;

import com.study.test.TestApplicationTests;
import com.study.test.model.entity.Item;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemRepositoryTest extends TestApplicationTests {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create() {

        Item item = new Item();
        item.setName("노트북");
        item.setPrice(1000000);
        item.setContent("삼성 노트북");

        Item newItem = itemRepository.save(item);
        Assertions.assertNotNull(newItem);
    }

    @Test
    public void read() {
        Long id = 1L;

        Optional<Item> item = itemRepository.findById(id);

        item.ifPresent(i -> {
            System.out.println(i);
        });
    }
}
