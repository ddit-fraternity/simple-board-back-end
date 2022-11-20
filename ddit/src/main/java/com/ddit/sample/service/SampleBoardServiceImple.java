package com.ddit.sample.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ddit.entity.SampleBoard;
import com.ddit.sample.repository.SampleBoardRepository;
import com.ddit.sample.vo.SampleBoardVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SampleBoardServiceImple implements SampleBoardService {
    
    private final SampleBoardRepository sampleBoardRepository;

    @Override
    public List<SampleBoardVO> selectAllSampleBoard() throws Exception {

        List<SampleBoard> data = sampleBoardRepository.findAll();
        List<SampleBoardVO> returnData = new ArrayList<SampleBoardVO>();

        if(!data.isEmpty()){
            for(SampleBoard entity : data) {
                SampleBoardVO vo = new SampleBoardVO(entity);
    
                returnData.add(vo);
            }
        }

        return returnData;
    }

    @Override
    public SampleBoardVO selectOneSampleBoard(Long sbId) throws Exception {

        Optional<SampleBoard> data = sampleBoardRepository.findById(sbId);

        if(data.isPresent()){
            SampleBoardVO returnData = new SampleBoardVO(data.get());

            return returnData;
        }else{

            return null;
        }
    }

    @Override
    public void insertSampleBoard(SampleBoardVO sampleBoardVO) throws Exception {

        SampleBoard sampleBoard = new SampleBoard(
            sampleBoardVO.getSbId(), 
            sampleBoardVO.getSbTitle(), 
            sampleBoardVO.getSbContents(), 
            sampleBoardVO.getSbViews(), 
            sampleBoardVO.getCreateAt(), 
            sampleBoardVO.getUpdateAt()
        );

        sampleBoardRepository.save(sampleBoard);
    }

    @Override
    public void updateSampleBoard(SampleBoardVO sampleBoardVO) throws Exception {
        SampleBoard sampleBoard = new SampleBoard(
            sampleBoardVO.getSbId(), 
            sampleBoardVO.getSbTitle(), 
            sampleBoardVO.getSbContents(), 
            sampleBoardVO.getSbViews(), 
            sampleBoardVO.getCreateAt(), 
            sampleBoardVO.getUpdateAt()
        );
        
        sampleBoardRepository.save(sampleBoard);
    }

    @Override
    public void deleteSampleBoard(Long sbId) throws Exception {
        sampleBoardRepository.deleteById(sbId);
    }
}
