package com.ddit.sample.service;

import java.util.List;

import com.ddit.sample.vo.SampleBoardVO;

public interface SampleBoardService {
 
    // 전체 조회
    public List<SampleBoardVO> selectAllSampleBoard() throws Exception;

    // 단건 조회
    public SampleBoardVO selectOneSampleBoard(Long sbId) throws Exception;

    // 등록
    public void insertSampleBoard(SampleBoardVO sampleBoardVO) throws Exception;

    // 수정
    public void updateSampleBoard(SampleBoardVO sampleBoardVO) throws Exception;

    // 삭제
    public void deleteSampleBoard(Long sbId) throws Exception;

}
