package com.study.test.repository;

import java.time.LocalDateTime;

import com.study.test.TestApplicationTests;
import com.study.test.model.entity.OrderDetail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderDetailRepositoryTest extends TestApplicationTests {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void create() {
        OrderDetail orderDetail = new OrderDetail();

        orderDetail.setOrderAt(LocalDateTime.now());
        orderDetail.setUserId(4L); // 어떤 사람?
        orderDetail.setItemId(1L); // 어떤 상품?

        OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);

        Assertions.assertNotNull(newOrderDetail);
    }
}
