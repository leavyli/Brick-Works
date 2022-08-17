package com.example.mall.security.util;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JOSEObjectType;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.crypto.ECDSASigner;
import com.nimbusds.jose.jwk.Curve;
import com.nimbusds.jose.jwk.gen.ECKeyGenerator;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Author saino
 * LastModify 12:31
 */
@Slf4j
public class JwtTokenUtil {
    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "created";
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expiration;
    @Value("${jwt.tokenHead}")
    private String tokenHead;


    /**
     * 根据负责生成JWT的token
     *
     * @param claims 内容
     * @return JWT
     *
     * @throws JOSEException 异常
     */
    private String generateToken(Map<String, Object> claims) throws JOSEException {
        return generateToken(claims, expiration);
    }

    /**
     * 根据负责生成JWT的token
     *
     * @param claims          内容
     * @param validitySeconds 有效时间
     * @return JWT
     * @throws JOSEException 异常
     */
    private String generateToken(Map<String, Object> claims, long validitySeconds) throws JOSEException {
        if (!claims.containsKey(CLAIM_KEY_USERNAME)) {
            return null;
        }
        var key = new ECKeyGenerator(Curve.P_256)
                .keyID(secret)
                .generate();

        var header = new JWSHeader.Builder(JWSAlgorithm.ES256)
                .type(JOSEObjectType.JWT)
                .keyID(key.getKeyID())
                .build();
        var payload = new JWTClaimsSet.Builder()
                .claim(CLAIM_KEY_USERNAME, claims.get("name"))
                .claim(CLAIM_KEY_CREATED, LocalDate.now().toString())
                .expirationTime(Date.from(Instant.now().plusSeconds(validitySeconds)))
                .build();

        var singedJWT = new SignedJWT(header, payload);
        singedJWT.sign(new ECDSASigner(key));

        return singedJWT.serialize();
    }

    public String generateToken(UserDetails userDetails) throws JOSEException {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
        return generateToken(claims);
    }

    public String generateToken(UserDetails userDetails, long validitySeconds) throws JOSEException {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
        return generateToken(claims, validitySeconds);
    }


}
