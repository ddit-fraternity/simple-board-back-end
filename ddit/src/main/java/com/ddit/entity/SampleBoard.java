package com.ddit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity // 객체와 테이블 매핑
@Table(name = "SAMPLE_BOARD") // 테이블 지정
public class SampleBoard {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO INCREMENT 설정 NULL일 경우 자동 생성
    @Column(name = "sbId")
    private Long sbId;

    @Column(name = "sbTitle", nullable = false, columnDefinition = "varchar(255)")
    private String sbTitle;

    @Column(name = "sbContents", nullable = false, columnDefinition = "varchar(255)")
    private String sbContents;

    @Column(name = "sbViews", nullable = false)
    private Long sbViews;

    @Column(name = "createAt", nullable = false)
    private String createAt;
    
    @Column(name = "updateAt", nullable = false)
    private String updateAt;

    @Builder
    public SampleBoard(Long sbId, String sbTitle, String sbContents, Long sbViews, String creatAt, String updateAt){
        this.sbId = sbId;
        this.sbTitle = sbTitle;
        this.sbContents = sbContents;
        this.sbViews = sbViews;
        this.createAt = creatAt;
        this.updateAt = updateAt;
    }

}
