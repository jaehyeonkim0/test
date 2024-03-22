//package com.movie.reservation.config.jwt;
//
//import com.movie.reservation.domain.member.Member;
//import com.movie.reservation.repository.member.MemberRepository;
//import io.jsonwebtoken.io.Decoders;
//import io.jsonwebtoken.io.Encoders;
//import io.jsonwebtoken.security.Keys;
//import jakarta.annotation.PostConstruct;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import java.security.Key;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//
//@Service
//@RequiredArgsConstructor
//public class JwtTokenProvider {
//
//    private final MemberRepository memberRepository;
//    private Key key;
//
//    @Value("${jwt.secretKey}")
//    private String secretKey;
//
//    @Value("${jwt.issuer}")
//    private String issuer;
//
//    @Value("${jwt.accessExpTime}")
//    private long accessExpTime;
//
//    @Value("${jwt.refreshExpTime}")
//    private long refreshExpTime;
//
//    @PostConstruct
//    public void init() {
//        String base64EncodedSecretKey = encodeBase64SecretKey(secretKey);
//        this.key = getSigningKey(base64EncodedSecretKey);
//    }
//
//    public String encodeBase64SecretKey(String secretKey) {
//        return Encoders.BASE64URL.encode(secretKey.getBytes());
//    }
//
//    private Key getSigningKey(String base64UrlEncodedSecretKey) {
//        byte[] encodedSecretKeyBytes = Decoders.BASE64URL.decode(base64UrlEncodedSecretKey);
//        return Keys.hmacShaKeyFor(encodedSecretKeyBytes);
//    }
//
//    public String generateToken(Member member) {
//        //액세스, 리프레시 토큰 유효기간 설정
//        Date accessTokenExpTime = getTokenExpTime(accessExpTime);
//        Date refreshTokenExpTime = getTokenExpTime(refreshExpTime);
//
//        //클레임 생성
//        Map<String, Object> claims = new HashMap<>();
//        claims.put("role", member.getRoles());
//
//        //액세스 토큰 생성
//
//
//
//        return null;
//    }
//
//    private Date getTokenExpTime(long expTime) {
//        Date now = new Date();
//
//        return new Date(now.getTime() + expTime);
//    }
//
//
//}
