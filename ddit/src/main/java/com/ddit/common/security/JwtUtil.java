package com.ddit.common.security;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * <pre>
 * History:
 * 정재훈, 1.0, 2022-11-07 최초작성
 * </pre>
 * 
 * @author 정재훈
 * @version 1.0, 2022-11-07 최초작성
 * @comments JWT 토큰 발급 클래스
 * 
 */
public class JwtUtil {
	
	private String				secretKey					= "secret";	// 비밀키
//	private String 				base64EncodedSecretKey 		= Base64.getUrlEncoder().encode(secretKey.getBytes()).toString();
	private SignatureAlgorithm 	encryptionAlgorithm 		= SignatureAlgorithm.HS256;	// 대칭키 해싱 알고리즘 (비공개키)
	private long 				refreshTokenExpireTime 			= 1000L * 60 * 60;			// 1시간
	private long 				AuthTokenExpireTime 			= 1000L * 60 * 60 * 24;		// 하루
	
//	private SignatureAlgorithm	encryptionAlgorithm			= SignatureAlgorithm.RS256; // 비대칭키 해싱 알고리즘 (공개키 - 비공개키)
	
	
	public String createRefreshToken(String userEmail) {
		
		Date now = new Date();
		
		// JWT Header에 저장될 정보 생성
		Map<String, Object> header = new HashMap<>();
		header.put("alg", encryptionAlgorithm);
		header.put("typ", Header.JWT_TYPE);
		
		// JWT Payload에 저장될 정보객체(Claim) 모음 생성 : 사실상 Map<String, Object> 구조
		Claims claims = Jwts.claims().setSubject("Authentication Token");
		claims.put("email", userEmail);
		claims.put("iss", "ddit");
		claims.setIssuedAt(now);
		claims.setExpiration(new Date(now.getTime() + refreshTokenExpireTime));
		
//		String token = Jwts.builder()
//				.setHeaderParam(Header.TYPE, Header.JWT_TYPE)								// 1. 헤더 타입(typ) 지정, JWT 사용시 Header.JWT_TYPE
//				.setIssuer("ddit")															// 2. 토큰 발행자 지정 
//				.setIssuedAt(now)															// 3. 토큰 발급 시간
//				.setExpiration(new Date(now.getTime() + tokenExpireTime))					// 4. 토큰 만료 시간
//		        .claim("id", userID)														// 5. 토큰 발행을 요청한 User의 ID 	(Claim 정보)
//		        .claim("email", userEmail)													// 6. 토큰 발행을 요청한 User의 Email (Claim 정보)
//		        .signWith(encryptionAlgorithm, signSecretKey)								// 7. 암호화 정보 (암호 알고리즘, 비밀키값)
//		        .compact();																	// 8. 토큰 발행
		
		String token = Jwts.builder()
				.setHeader(header)
				.setClaims(claims)
				.signWith(encryptionAlgorithm, secretKey)
				.compact();
		
		System.out.println("TokenProvider :: Refresh Token Created :: [" + userEmail + "] :: " + token);
		
		return token;
	}
	
	public String createAuthToken() {
		
		Date now = new Date();
		
		Map<String, Object> header = new HashMap<>();
		header.put("alg", encryptionAlgorithm);
		header.put("typ", Header.JWT_TYPE);
		
		Claims claims = Jwts.claims().setSubject("Authentication Token");
		claims.put("iss", "ddit");
		claims.setIssuedAt(now);
		claims.setExpiration(new Date(now.getTime() + AuthTokenExpireTime));
		
		String token = Jwts.builder()
				.setHeader(header)
				.setClaims(claims)
				.signWith(encryptionAlgorithm, secretKey)
				.compact();
		
		System.out.println("TokenProvider :: Auth Token Created :: " + token);
		
		return null;
	}
}

/*
 * Json Web Token의 구조
 * 
 * 
 * ┌─ Json Web Token ─────────────────────────────┐
 * │  ┌────────────┐ ┌───────────┐ ┌───────────┐  │
 * │  │   Header   │ │  Payload  │ │ Signature │  │
 * │  └────────────┘.└───────────┘.└───────────┘  │
 * └──────────────────────────────────────────────┘
 * 
 * 1. Header (헤더)
 * 
 * 		- 토큰의 헤더에는 alg와 typ 두 가지 정보로 구성된다.
 * 	  	  alg는 Signature를 해싱하기 위한 알고리즘 정보
 *    	  typ은 토큰의 타입정보 ex. JWT
 * 	
 * 		- 해시 알고리즘은 HS256(HMAC with SHA-256) 또는 RS256(RSA Signature with SHA-256) 방식 사용
 * 		  HS256은 대칭키 방식으로, 비밀키를 알아야만 검증 가능하므로 검증 주체가 일부로 한정됨.
 * 		  RS256은 비대칭키 방식으로, 공개키로 검증 가능하므로 JWT를 받아서 사용하는 어떤 주체라도 Signature 검증이 가능
 * 
 * 		※ Header 예시
 * 			{
 * 				"alg" : "HS256",
 * 				"typ" : "JWT"
 * 			}
 * 
 * 
 * 2. Payload (페이로드)
 * 
 * 		- 토큰의 페이로드에는 토큰에서 사용할 정보들인 클레임(Claim)이 담겨있다.
 * 		  클레임은 총 3가지로 나누어지며, Json형태로 다수의 정보를 넣을 수 있다.
 * 
 * 		2-1. 등록된 클레임 (Registered Claim)
 * 		
 * 			- 등록된 클레임은 토큰정보를 표현하기 위해 이미 정해진 종류의 데이터.
 * 			  1) iss : 토큰 발급자(Issuer)
 * 			  2) sub : 토큰 제목(Subject)
 * 			  3) aud : 토큰 대상자(Audience)
 * 			  4) exp : 토큰 만료 시간(Expiration), NumericDate 형식으로 지정, Java에서는 Date객체로 지정하면 자동변환
 * 			  5) nbf : 토큰 활성 날짜(Not Before), 이 날이 지나기 전의 토큰은 활성화되지 않음
 * 			  6) iat : 토큰 발급 시간(Issued At), 토큰 발급 이후의 경과시간을 알 수 있음
 * 			  7) jti : JWT 토큰 식별자(JWT ID), 중복 방지를 위해 사용. 일회용 토큰(Access Token) 등에 사용
 * 
 * 		2-2. 공개 클레임 (Public Claim)
 * 			- 공개 클레임은 사용자 정의 클레임으로, 공개용 정보를 위해 사용한다.
 * 			  충돌 방지를 위해 URI 포맷을 이용한다.
 * 
 *  	2-3. 비공개 클레임 (Private Claim)
 *  		- 사용자 정의 클레임으로, 서버와 클라이언트 사이에 임의로 지정한 정보를 저장한다.
 *  
 *
 * 		※ Payload 예시
 * 			{
 * 				"iss" : "ddit",				// 토큰 발급자
 * 				"sub" : "ddit login token",	// 토큰 제목
 * 				"exp" : 1479748147370,		// 토큰 만료 시간
 * 				"iat" : 1479417333452		// 토큰 발급 시간
 * 			}
 *  
 *  
 * 3. Signature (서명)
 * 
 *  	- 서명(Signature)은 토큰을 인코딩하거나 유효성 검증을 할 때 사용하는 고유한 암호화 코드.
 *  	  Header와 Payload의 값을 각각 Base64Url로 인코딩하고, 
 *  	  인코딩한 값을 비밀 키를 이용해 Header에서 정의한 알고리즘으로 해싱한 후 
 *  	  이 값을 다시 Base64Url로 인코딩하여 생성한다.
 *  
 *  
 */











