package com.jikuodong.plms.utils;

import io.jsonwebtoken.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

/*
 *
 * describe Token工具类
 * @author mingchenxu
 * @date 2018/3/12 10:03
 * @param  * @param null
 * @return
 */
public class TokenUtil {
    private static final Logger logger = LogManager.getLogger(TokenUtil.class);

    // 加密的私钥签名
    private static final String APP_KEY = "PLMS";

    // 单例模式，私有构造方法
    private TokenUtil(){}

    /*
     *
     * describe 生成JWT
     * @author JKD
     * @date 2018/3/12 10:07
     * @param  * @param id 当前用户ID
     * @param owner 该JWT的签发者，可选是否使用
     * @param subject 该JWT的面向用户，可选是否使用
     * @param ttlMillis 该JWT的过期时间，可选是否使用，单位S
     * @param audience 该JWT的接收方，可选是否使用
     * @return java.lang.String
     */
    public static String createJWT(String id, String isuser, String subject, long ttlMillis, String audience) {
        // 获取当前时间戳
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        // 加密方式为HS256
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        // 私钥签名转换为二进制编码
        byte[] apiKeySecretByBytes = DatatypeConverter.parseBase64Binary(APP_KEY);
        // 恢复加密的秘钥
        Key signingKey = new SecretKeySpec(apiKeySecretByBytes, signatureAlgorithm.getJcaName());
        // 创建jwt
        JwtBuilder jwtBuilder = Jwts.builder()
                .setId(id)
                .setIssuer(isuser)
                .setSubject(subject)
                .setIssuedAt(now)
                .setAudience(audience)
                .signWith(signatureAlgorithm, signingKey); // 设置的加密算法
        // 设置token过期时间，现在的时间戳+过期的时间
        if (ttlMillis > 0) {
            long expMillis = nowMillis + ttlMillis* 1000;
            Date expDate = new Date(expMillis);
            jwtBuilder.setExpiration(expDate);
        }
        return jwtBuilder.compact();// 返回拼接的字符串
    }

    /*
     *
     * describe 使用私钥解密jwt
     * @author JKD
     * @date 2018/3/12 10:31
     * @param  * @param jwt
     * @return io.jsonwebtoken.Claims
     */
    public static Claims getClaims(String jwt) {
        try {
            return Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(APP_KEY))
                    .parseClaimsJws(jwt).getBody();
        } catch (ExpiredJwtException e) {
            logger.error("JWT token已过期");
        } catch (UnsupportedJwtException e) {
            logger.error("不支持的JWT token");
        } catch (MalformedJwtException e) {
            logger.error("不完整的JWT token");
        } catch (SignatureException e) {
            logger.error("未签名的JWT token");
        } catch (IllegalArgumentException e) {
            logger.error("非法的JWT token");
        }
        return null;
    }

    public static void main(String[] args) {
        String token = createJWT("xmc","master","worker",300,"mingchenxu");
        logger.info("token：" + token);
        String s = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ4bWMiLCJpc3MiOiJtYXN0ZXIiLCJzdWIiOiJ3b3JrZXIiLCJpYXQiOjE1MzUwODExODIsImF1ZCI6Im1pbmdjaGVueHUiLCJleHAiOjE1MzUwODE0ODJ9.IM00-n7g_PGL0Ud3csYSRw1MPMeuHHdvSW0QCUzPNOg";
        Claims claims = getClaims(token);
        if (claims == null) {
            logger.error("解析JWT失败");
        } else {
            logger.info("==============解密后token===============");
            logger.info(claims.getId());
            logger.info(claims.getIssuedAt());
            logger.info(claims.getSubject());
            logger.info(claims.getExpiration());
        }
    }

}
