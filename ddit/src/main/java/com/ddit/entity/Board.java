package com.ddit.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity // 객체와 테이블 매핑
@Table(name = "BOARD") // 테이블 지정
public class Board {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO INCREMENT 설정 NULL일 경우 자동 생성
    @Column(name = "board_id")
    private Long boardId;

    @Column(name = "board_title", nullable = false, columnDefinition = "varchar(255)")
    private String boardTitle;

    @Column(name = "board_contents", nullable = false, columnDefinition = "varchar(255)")
    private String boardContents;

    @Column(name = "board_views", nullable = false)
    private Long boardViews;

    @Column(name = "create_at", nullable = false)
    private String createAt;
    
    @Column(name = "update_at", nullable = false)
    private String updateAt;

    @ManyToOne(targetEntity = Users.class)
    @JoinColumn(name = "user_id")
    private Users users;

}
