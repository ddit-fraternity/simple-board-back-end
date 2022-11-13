package com.ddit.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddit.common.security.JwtUtil;
import com.ddit.vo.UserVO;

@Service
public class MemberServiceImpl {
	
//	@Autowired
//	private MemberDaoImpl memberDao;
	
	
	public Map<String, String> login(UserVO userVo){
		
		// Email/Pw 인증절차
		if(!isCorrectPw(userVo)) {
			return null;
		}
		
		// JWT 토큰 발행
		JwtUtil jp = new JwtUtil();
		
		String authToken = jp.createAuthToken();								// Auth 토큰 발행
		String refreshToken = jp.createRefreshToken(userVo.getUserEmail());		// Refresh 토큰 발행
		
		updateMemberAuthJwt(userVo.getUserEmail(), authToken);
		
		Map<String, String> returnMap = new HashMap<>();
		
		returnMap.put("auth", authToken);
		returnMap.put("refresh", refreshToken);
		
		return returnMap;
		
	}
	
	private boolean isCorrectPw(UserVO userVo) {
		
//		TODO : JPA 연결후 구현
//		String validatePassword = memberDao.getMemberPw(userVo.getUserEmail());
//		return validatePassword.equals(userVo.getUserPw());
		return true;
		
	}
	
	private boolean updateMemberAuthJwt(String userEmail, String authToken) {
		
//		TODO : JPA 연결후 구현 :: User의 AuthToken정보 변경
//		return memberDao.updateMemberAuthJwt(userEmail, authToken);
		return false;
		
	}
	
}
