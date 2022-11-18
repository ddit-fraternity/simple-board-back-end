package com.ddit.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ddit.entity.Board;
import com.ddit.sample.service.SampleService;
import com.ddit.sample.vo.SampleVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class SampleController {

    @Autowired
    private SampleService sampleService;

    // 전체 조회
    @Operation(summary = "sample", description = "selectAll sample")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "SWAGGER : PASSED"),
        @ApiResponse(responseCode = "400", description = "SWAGGER : BAD REQUEST"),
        @ApiResponse(responseCode = "404", description = "SWAGGER : NOT FOUND"),
        @ApiResponse(responseCode = "500", description = "SWAGGER : INTERNAL SERVER ERROR"),
    })
    @GetMapping("/sample")
    public ResponseEntity selectAllSample() throws Exception {

        return ResponseEntity.ok(sampleService.selectAllBoard());
    }   

    // 한 건 조회
    @Operation(summary = "sample", description = "selectOne sample")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "SWAGGER : PASSED"),
        @ApiResponse(responseCode = "400", description = "SWAGGER : BAD REQUEST"),
        @ApiResponse(responseCode = "404", description = "SWAGGER : NOT FOUND"),
        @ApiResponse(responseCode = "500", description = "SWAGGER : INTERNAL SERVER ERROR"),
    })
    @GetMapping("/sample/{id}")
    public ResponseEntity selectOnelSample(@PathVariable("id") Long id) throws Exception {
        return null;
    }

    // 등록
    @Operation(summary = "sample", description = "insert sample")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "SWAGGER : PASSED"),
        @ApiResponse(responseCode = "400", description = "SWAGGER : BAD REQUEST"),
        @ApiResponse(responseCode = "404", description = "SWAGGER : NOT FOUND"),
        @ApiResponse(responseCode = "500", description = "SWAGGER : INTERNAL SERVER ERROR"),
    })
    @PostMapping("/sample")
    public ResponseEntity insertSample(Board board) throws Exception {

        sampleService.insertBoard(board);

        return ResponseEntity.ok("저장 완료");
    }
    
    // 수정
    @Operation(summary = "sample", description = "update sample")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "SWAGGER : PASSED"),
        @ApiResponse(responseCode = "400", description = "SWAGGER : BAD REQUEST"),
        @ApiResponse(responseCode = "404", description = "SWAGGER : NOT FOUND"),
        @ApiResponse(responseCode = "500", description = "SWAGGER : INTERNAL SERVER ERROR"),
    })
    @PutMapping("/sample")
    public ResponseEntity updateSample(SampleVO sampleVO) throws Exception {
        return null;
    }

    // 삭제
    @Operation(summary = "sample", description = "delete sample")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "SWAGGER : PASSED"),
        @ApiResponse(responseCode = "400", description = "SWAGGER : BAD REQUEST"),
        @ApiResponse(responseCode = "404", description = "SWAGGER : NOT FOUND"),
        @ApiResponse(responseCode = "500", description = "SWAGGER : INTERNAL SERVER ERROR"),
    })
    @DeleteMapping("/sample/{id}")
    public ResponseEntity deleteSample(@PathVariable("id") Long id) throws Exception {
        return null;
    }

}
