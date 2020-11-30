package com.study.test.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity // order_detail
@ToString(exclude = { "user", "item" }) // user, item 변수 제외시킴. 서로 상호참조하고 있는 부분 제외 시켜주지 않으면 오버플로우 생김.
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime orderAt;

    // N : 1
    @ManyToOne
    // Hibernate를 통한 연관관계 설정시에는 반드시 객체 이름을 적어줘야됨.
    private User user; // user_id 를 자동으로 찾음.

    // N : 1
    @ManyToOne
    private Item item;

}
