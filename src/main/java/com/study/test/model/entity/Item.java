package com.study.test.model.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private String name;

    private String title;

    private Integer price;

    private String content;

    private String brandName;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

    private Long partnerId;

    // 1 : N
    // LAZY = 지연로딩, EAGER = 즉시로딩

    // LAZY = SELECT * FROM item where id = ?

    // 연관관계설정된 모든 테이블에 대해 조인이 일어남.
    // EAGER는 그래서 성능저하가 있을 수도 있고, 상실이 있을 수 있음.
    // EAGER는 한건만 존재할 때 추천. 1:1

    // EAGER = 1:1
    // item_id = order_detail.item_id
    // user_id = order_detail.user_id
    // wher item.id = ?
    // JOIN item ~~
}
