package com.ddit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity // 객체와 테이블 매핑
@Table(name = "USERS") // 테이블 지정
public class Users {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO INCREMENT 설정 NULL일 경우 자동 생성
    @Column(name = "user_id")
    private Long userId;        // pk

    @Column(name = "user_pw", nullable = false, columnDefinition = "varchar(255)")
    private String userPw;      // 비밀번호

    @Column(name = "user_email", nullable = false, columnDefinition = "varchar(255)")
    private String userEmail;   // 이메일

    @Column(name = "user_name", nullable = false, columnDefinition = "varchar(255)")
    private String userName;    // 아이디

}
