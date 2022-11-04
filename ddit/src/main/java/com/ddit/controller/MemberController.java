package com.ddit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ddit.sample.vo.UserVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Controller
public class MemberController {

	/**
	 * <pre>
	 * History:
	 * 정재훈, 1.0, 2022-11-04 최초작성
	 * </pre>
	 * 
	 * @author 정재훈
	 * @version 1.0, 2022-11-04 최초작성
	 * @comments 로그인 메서드
	 * 
	 */
	@Operation(summary = "Login", description = "Login request")
	@ApiResponses({
        @ApiResponse(responseCode = "200", description = "SWAGGER : PASSED"),
        @ApiResponse(responseCode = "400", description = "SWAGGER : BAD REQUEST"),
        @ApiResponse(responseCode = "404", description = "SWAGGER : NOT FOUND"),
        @ApiResponse(responseCode = "500", description = "SWAGGER : INTERNAL SERVER ERROR")
	})
	@PostMapping("/user/login")
	public ResponseEntity<String> login(HttpServletRequest request,
										HttpServletResponse response,
										@RequestBody UserVO userVo){
		
		//TODO : 자체 로그인
		//TODO : 연동 로그인 (OAUTH)
		
		return ResponseEntity.ok("");
		
	}
	
	/**
	 * <pre>
	 * History:
	 * 정재훈, 1.0, 2022-11-04 최초작성
	 * </pre>
	 * 
	 * @author 정재훈
	 * @version 1.0, 2022-11-04 최초작성
	 * @comments 로그인 메서드
	 * 
	 */
	@Operation(summary = "OAuth Login", description = "Login request")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "SWAGGER : PASSED"),
		@ApiResponse(responseCode = "400", description = "SWAGGER : BAD REQUEST"),
		@ApiResponse(responseCode = "404", description = "SWAGGER : NOT FOUND"),
		@ApiResponse(responseCode = "500", description = "SWAGGER : INTERNAL SERVER ERROR")
	})
	@PostMapping("/user/login/oauth")
	public ResponseEntity<String> OAuthLogin(HttpServletRequest request,
			HttpServletResponse response,
			@RequestBody UserVO userVo){
		
		//TODO : 자체 로그인
		//TODO : 연동 로그인 (OAUTH)
		
		return ResponseEntity.ok("");
		
	}
	
	
	/**
	 * <pre>
	 * History:
	 * 정재훈, 1.0, 2022-11-04 최초작성
	 * </pre>
	 * 
	 * @author 정재훈
	 * @version 1.0, 2022-11-04 최초작성
	 * @comments 로그아웃 메서드
	 * 
	 */
	@Operation(summary = "LogOut", description = "Logout request")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "SWAGGER : PASSED"),
		@ApiResponse(responseCode = "400", description = "SWAGGER : BAD REQUEST"),
		@ApiResponse(responseCode = "404", description = "SWAGGER : NOT FOUND"),
		@ApiResponse(responseCode = "500", description = "SWAGGER : INTERNAL SERVER ERROR")
	})
	@PostMapping("/user/logout")
	public ResponseEntity<String> logout(){
		
		
		return ResponseEntity.ok("");
	}
	
	/**
	 * <pre>
	 * History:
	 * 정재훈, 1.0, 2022-11-04 최초작성
	 * </pre>
	 * 
	 * @author 정재훈
	 * @version 1.0, 2022-11-04 최초작성
	 * @comments 패스워드 변경 메서드
	 * 
	 */
	@Operation(summary = "Forget Password", description = "Change your password")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "SWAGGER : PASSED"),
		@ApiResponse(responseCode = "400", description = "SWAGGER : BAD REQUEST"),
		@ApiResponse(responseCode = "404", description = "SWAGGER : NOT FOUND"),
		@ApiResponse(responseCode = "500", description = "SWAGGER : INTERNAL SERVER ERROR")
	})
	@PatchMapping("/user/chpasswd/{email}")
	public ResponseEntity<String> changePw(HttpServletRequest request,
											HttpServletResponse response,
											@PathVariable(required = true) String email){
		
		//TODO : 이메일 가입여부 확인
		//TODO : 임시 패스워드 생성
		//TODO : 임시 패스워드 발송
		//TODO : 코멘트 반환
		
		return ResponseEntity.ok("");
	}
	
	
    // Get		Read 		@GetMapping	
    // Post		Create 		@PostMapping
    // Put		전체 Update 	@PutMapping
    // Patch	일부 Update 	@PatchMapping
    // Delete	Delete		@DeleteMapping
	
}
