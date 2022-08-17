package com.example.mall.security.util;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.ECDSASigner;
import com.nimbusds.jose.crypto.ECDSAVerifier;
import com.nimbusds.jose.crypto.Ed25519Signer;
import com.nimbusds.jose.crypto.Ed25519Verifier;
import com.nimbusds.jose.jwk.Curve;
import com.nimbusds.jose.jwk.ECKey;
import com.nimbusds.jose.jwk.OctetKeyPair;
import com.nimbusds.jose.jwk.gen.ECKeyGenerator;
import com.nimbusds.jose.jwk.gen.OctetKeyPairGenerator;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;

import java.text.ParseException;
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

    private static OctetKeyPair key = null;
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expiration;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

//    public JwtTokenUtil() throws JOSEException {
//
//    }


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
        OctetKeyPair key = new OctetKeyPairGenerator(Curve.Ed25519)
                .keyID(secret)
                .generate();
        this.key = key;

        var header = new JWSHeader.Builder(JWSAlgorithm.EdDSA)
                .type(JOSEObjectType.JWT)
                .keyID(key.getKeyID())
                .build();
        var payload = new JWTClaimsSet.Builder()
                .claim(CLAIM_KEY_USERNAME, claims.get(CLAIM_KEY_USERNAME))
                .claim(CLAIM_KEY_CREATED, LocalDate.now().toString())
                .expirationTime(Date.from(Instant.now().plusSeconds(validitySeconds)))
                .build();

        var singedJWT = new SignedJWT(header, payload);
        singedJWT.sign(new Ed25519Signer(key));

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

    public boolean parseToken(String token) throws ParseException, JOSEException {
        SignedJWT jwsObject= SignedJWT.parse(token);
        jwsObject.getJWTClaimsSet().getClaims().forEach((k,v)->{
            log.info("parseToken {}:{}",k,v);
        });
        return jwsObject.verify(new Ed25519Verifier(key.toPublicJWK()));
    }

}
