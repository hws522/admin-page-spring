package com.study.test.model.network;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Header<T> {
    // api 통신 시간
    private LocalDateTime transactionTime; // ISO, YYYY-MM-DD , hh:mm:ss 여러 형식이 있으나 디폴트로 할거라서 String 대신 LocalDateTime

    // api 응답 코드
    private String resultCode;

    // api 부가 설명
    private String description;

    private T data;

    // OK
    public static <T> Header<T> OK() {
        return (Header<T>) Header.builder().transactionTime(LocalDateTime.now()).resultCode("OK").description("OK")
                .build();
    }

    // DATA OK
    public static <T> Header<T> OK(T data) {
        return (Header<T>) Header.builder().transactionTime(LocalDateTime.now()).resultCode("OK").description("OK")
                .data(data).build();
    }

    // ERROR
    public static <T> Header<T> ERROR(String description) {
        return (Header<T>) Header.builder().transactionTime(LocalDateTime.now()).resultCode("ERROR")
                .description(description).build();
    }

}
