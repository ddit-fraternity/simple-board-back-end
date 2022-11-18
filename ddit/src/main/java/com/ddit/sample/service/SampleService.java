package com.ddit.sample.service;

import java.util.List;

import com.ddit.entity.Board;

public interface SampleService {
 
    // 전체 조회
    public List<Board> selectAllBoard() throws Exception;

    // 단건 조회
    public Board selectOneBoard(Long boardId) throws Exception;

    // 등록
    public void insertBoard(Board board) throws Exception;

    // 수정
    public void updateBoard(Board board) throws Exception;

    // 삭제
    public void deleteBoard(Long boardId) throws Exception;

}
