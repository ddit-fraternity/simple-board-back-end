package com.ddit.sample.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ddit.sample.service.SampleBoardService;
import com.ddit.sample.vo.SampleBoardVO;
import com.ddit.utils.ResponseBuilder;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
@ApiResponses({
    @ApiResponse(responseCode = "200", description = "SWAGGER : PASSED"),
    @ApiResponse(responseCode = "400", description = "SWAGGER : BAD REQUEST"),
    @ApiResponse(responseCode = "404", description = "SWAGGER : NOT FOUND"),
    @ApiResponse(responseCode = "500", description = "SWAGGER : INTERNAL SERVER ERROR"),
})
public class SampleBoardController {

    @Autowired
    private SampleBoardService sampleBoardService;

    // 전체 조회
    @Operation(summary = "sampleBoard", description = "selectAll sampleBoard")
    @GetMapping("/sample")
    public ResponseEntity<ResponseBuilder> selectAllSampleBoard() throws Exception {

        ResponseBuilder responseBuilder = new ResponseBuilder();
        List<SampleBoardVO> data = sampleBoardService.selectAllSampleBoard();

        if(!data.isEmpty()){
            responseBuilder = ResponseBuilder.builder()
                                .code(HttpStatus.OK.value())
                                .httpStatus(HttpStatus.OK)
                                .message("조회 성공")
                                .result(Arrays.asList(data))
                                .count(data.size())
                                .build();
        }else{
            responseBuilder = ResponseBuilder.builder()
                                .code(HttpStatus.NOT_FOUND.value())
                                .httpStatus(HttpStatus.NOT_FOUND)
                                .message("데이터 없음")
                                .result(Collections.emptyList())
                                .count(0)
                                .build();
        }

        return new ResponseEntity<>(responseBuilder, responseBuilder.getHttpStatus());
    }   

    // 한 건 조회
    @Operation(summary = "sampleBoard", description = "selectOne sampleBoard")
    @GetMapping("/sample/{id}")
    public ResponseEntity<ResponseBuilder> selectOnelSampleBoard(@PathVariable("sbId") Long sbId) throws Exception {

        ResponseBuilder responseBuilder = new ResponseBuilder();
        SampleBoardVO data = sampleBoardService.selectOneSampleBoard(sbId);

        if(data != null){
            responseBuilder = ResponseBuilder.builder()
                                .code(HttpStatus.OK.value())
                                .httpStatus(HttpStatus.OK)
                                .message("조회 성공")
                                .result(Arrays.asList(data))
                                .count(1)
                                .build();
        }else{
            responseBuilder = ResponseBuilder.builder()
                                .code(HttpStatus.NOT_FOUND.value())
                                .httpStatus(HttpStatus.NOT_FOUND)
                                .message("데이터 없음")
                                .result(Collections.emptyList())
                                .count(0)
                                .build();
        }

        return new ResponseEntity<>(responseBuilder, responseBuilder.getHttpStatus());
    }

    // 등록
    @Operation(summary = "sampleBoard", description = "insert sampleBoard")
    @PostMapping("/sample")
    public ResponseEntity<ResponseBuilder> insertSampleBoard(SampleBoardVO sampleBoardVO) throws Exception {

        return null;
    }
    
    // 수정
    @Operation(summary = "sampleBoard", description = "update sampleBoard")
    @PutMapping("/sample")
    public ResponseEntity<ResponseBuilder> updateSampleBoard(SampleBoardVO sampleBoardVO) throws Exception {
        return null;
    }

    // 삭제
    @Operation(summary = "sampleBoard", description = "delete sampleBoard")
    @DeleteMapping("/sample/{id}")
    public ResponseEntity<ResponseBuilder> deleteSampleBoard(@PathVariable("sbId") Long sbId) throws Exception {
        return null;
    }

}
