package com.ddit.sample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ddit.entity.Board;
import com.ddit.sample.repository.SampleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SampleServiceImple implements SampleService {
    
    private final SampleRepository sampleRepository;

    @Override
    public List<Board> selectAllBoard() throws Exception {
        return sampleRepository.findAll();
    }

    @Override
    public Board selectOneBoard(Long boardId) throws Exception {

        // Optional : NullPointerException 예외 발생을 회피하기 위해 사용
        Optional<Board> data = sampleRepository.findById(boardId);

        return data.get();
    }

    @Override
    public void insertBoard(Board board) throws Exception {
        sampleRepository.save(board);
    }

    @Override
    public void updateBoard(Board board) throws Exception {
        sampleRepository.save(board);
    }

    @Override
    public void deleteBoard(Long boardId) throws Exception {
        sampleRepository.deleteById(boardId);
    }
}
