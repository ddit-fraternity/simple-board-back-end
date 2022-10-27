package com.ddit.sample.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ddit.sample.vo.SampleVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Controller
public class SampleController {

    @Operation(summary = "sample", description = "this is sample")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "SWAGGER : PASSED"),
        @ApiResponse(responseCode = "400", description = "SWAGGER : BAD REQUEST"),
        @ApiResponse(responseCode = "404", description = "SWAGGER : NOT FOUND"),
        @ApiResponse(responseCode = "500", description = "SWAGGER : INTERNAL SERVER ERROR"),
    })
    @GetMapping("/sample")
    @ResponseBody
    public ResponseEntity<String> sample(HttpServletRequest request, HttpServletResponse response,
        SampleVO sampleVO) throws Exception{
        return ResponseEntity.ok("이메일 : " + sampleVO.getUserEmail() + ", 비밀번호 : " + sampleVO.getUserPw() + ", 이름 : " + sampleVO.getUserName());
    }

}
