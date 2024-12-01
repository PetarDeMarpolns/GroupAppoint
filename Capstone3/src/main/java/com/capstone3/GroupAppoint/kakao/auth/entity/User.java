package com.capstone3.GroupAppoint.kakao.auth.entity;


import jakarta.persistence.*;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.ColumnDefault;

@Slf4j
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity // 테이블과 매핑
public class User {

    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increment
    private Long userId;

    private String name;

    private String email;

    @Column(length = 2500)
    private String profile;

    @Column(nullable = false)
    @ColumnDefault("0")
    private int accumulatedTime;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
