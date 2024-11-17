package com.example.utils;

import cn.hutool.core.exceptions.ValidateException;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.config.exception.base.BizErrorCode;
import lombok.Builder;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Slf4j
@Builder
public class JwtTokenUtils {
    /**
     * 传输信息，必须是json格式
     */
    private String msg;
    /**
     * 所验证的jwt
     */
    @Setter private String token;

    private final String secret="1234567890";

    public String creatJwtToken () {
        msg = new AESUtil(msg).encrypt();//先对信息进行aes加密(防止被破解）
        String token = null;
        try {
            LocalDateTime localDateTime = LocalDateTime.now().plusDays(1);
            Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
            Date dateTime = new Date(instant.toEpochMilli());

            token = JWT.create()
                    .withIssuer("wlgzs").withExpiresAt(dateTime)
                    .withClaim("user", msg)
                    .sign(Algorithm.HMAC256(secret));

        } catch (Exception e) {

        }
        log.info("加密后：" + token);

        return token;
    }
    /**
     * 解密jwt并验证是否正确
     */
    public String freeJwt () {
        DecodedJWT decodedJWT = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret))
                    .withIssuer("wlgzs")
                    .build();
            decodedJWT = verifier.verify(token);
            log.info("签名人：" + decodedJWT.getIssuer() + " 加密方式：" + decodedJWT.getAlgorithm() + " 携带信息：" + decodedJWT.getClaim("user").asString());
        } catch (Exception e) {
            log.info("jwt解密出现错误，jwt或私钥或签证人不正确");
            throw new ValidateException(BizErrorCode.AUTH_ERROR,"");
        }
        String [] headPayload = token.split("\\.");
        String header = decodedJWT.getHeader();
        String payload = decodedJWT.getPayload();
        if(!header.equals(headPayload[0]) && !payload.equals(headPayload[1])){
            throw new ValidateException(BizErrorCode.AUTH_ERROR,"");
        }
        return new AESUtil(decodedJWT.getClaim("user").asString()).decrypt();
    }

}
