package com.ddit.sample.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ddit.common.security.JwtUtil;
import com.ddit.sample.vo.SampleVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Controller
public class SampleController {

	/**
	 * Get 방식 
	 */
    @Operation(summary = "sample", description = "this is sample")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "SWAGGER : PASSED"),
        @ApiResponse(responseCode = "400", description = "SWAGGER : BAD REQUEST"),
        @ApiResponse(responseCode = "404", description = "SWAGGER : NOT FOUND"),
        @ApiResponse(responseCode = "500", description = "SWAGGER : INTERNAL SERVER ERROR"),
    })
    @GetMapping("/sample/{id}/{pw}")
    @ResponseBody
    public ResponseEntity<String> sampleGet(@PathVariable(required = true) String id, 
    										@PathVariable String pw, 
    										HttpServletRequest request, HttpServletResponse response) throws Exception{
    	
        return ResponseEntity.ok("id : " + id + " & pw : " + pw);
    }
    
    /**
     * Post 방식
     */
    @Operation(summary = "sample", description = "this is sample")
    @ApiResponses({
    	@ApiResponse(responseCode = "200", description = "SWAGGER : PASSED"),
    	@ApiResponse(responseCode = "400", description = "SWAGGER : BAD REQUEST"),
    	@ApiResponse(responseCode = "404", description = "SWAGGER : NOT FOUND"),
    	@ApiResponse(responseCode = "500", description = "SWAGGER : INTERNAL SERVER ERROR"),
    })
    @PostMapping("/sample/login")
    public ResponseEntity<String> samplePost(HttpServletRequest request, 
											HttpServletResponse response, 
											@RequestBody SampleVO sampleVo) throws Exception{
    	
    	// 패스워드 맞는지
    	sampleVo.getUserPw();
    	
    	// 토큰 생성
    	return ResponseEntity.ok(sampleVo.getUserEmail());
    }
    
    @Operation(summary = "sample", description = "this is sample")
    @ApiResponses({
    	@ApiResponse(responseCode = "200", description = "SWAGGER : PASSED"),
    	@ApiResponse(responseCode = "400", description = "SWAGGER : BAD REQUEST"),
    	@ApiResponse(responseCode = "404", description = "SWAGGER : NOT FOUND"),
    	@ApiResponse(responseCode = "500", description = "SWAGGER : INTERNAL SERVER ERROR"),
    })
    @GetMapping("/sample/test/{id}/{email}")
    public ResponseEntity<String> testAPI(HttpServletRequest request, 
    		HttpServletResponse response, 
    		@PathVariable String id,
    		@PathVariable String email) throws Exception{
    	
    	var tp = new JwtUtil();
    	
    	String s = tp.createAuthToken();
    	
    	System.out.println("SampleCntrler :: GET JWT ::  " + s);
    	
    	// 토큰 생성
    	return ResponseEntity.ok(s);
    }
    
    
    // Get		Read 		@GetMapping	
    // Post		Create 		@PostMapping
    // Put		전체 Update 	@PutMapping
    // Patch	일부 Update 	@PatchMapping
    // Delete	Delete		@DeleteMapping
    
}
