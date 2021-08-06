package cn.liyu.utils;

import cn.liyu.constants.JwtConstants;
import cn.liyu.model.UserInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.joda.time.DateTime;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author liyu
 * date 2020/8/5 18:15
 * description
 */
public class JwtUtils {
    /**
     * 生成Token
     * @param userInfo
     * @param privateKey
     * @param expireMinutes
     * @return
     */
    public static String generateToken(UserInfo userInfo, PrivateKey privateKey, int expireMinutes) {
        return Jwts.builder()
                .claim(JwtConstants.JWT_KEY_ID, userInfo.getId())
                .claim(JwtConstants.JWT_ACCOUNT_TYPE, userInfo.getAccountType())
                .claim(JwtConstants.JWT_KEY_USER_NAME, userInfo.getName())
                .setExpiration(DateTime.now().plusMinutes(expireMinutes).toDate())
                .signWith(SignatureAlgorithm.RS256, privateKey)
                .compact();
    }

    /**
     * 生成Token
     * @param userInfo
     * @param privateKey
     * @param expireMinutes
     * @return
     * @throws Exception
     */
    public static String generateToken(UserInfo userInfo, byte[] privateKey, int expireMinutes) throws Exception {
        return Jwts.builder()
                .claim(JwtConstants.JWT_KEY_ID, userInfo.getId())
                .claim(JwtConstants.JWT_ACCOUNT_TYPE, userInfo.getAccountType())
                .claim(JwtConstants.JWT_KEY_USER_NAME, userInfo.getName())
                .setExpiration(DateTime.now().plus(expireMinutes).toDate())
                .signWith(SignatureAlgorithm.ES256, RsaUtils.getPrivateKey(privateKey))
                .compact();
    }

    /**
     * 公钥解析Token
     * @param publicKey
     * @param token
     * @return
     */
    public static Jws<Claims> parseToken(PublicKey publicKey, String token) {
        return Jwts.parser().setSigningKey(publicKey).parseClaimsJws(token);
    }


    /**
     * 公钥解析Token
     * @param publicKey
     * @param token
     * @return
     * @throws Exception
     */
    public static Jws<Claims> parseToken(byte[] publicKey, String token) throws Exception {
        return Jwts.parser().setSigningKey(RsaUtils.getPublicKey(publicKey)).parseClaimsJws(token);
    }


    /**
     * 从Token中获取用户信息（使用公钥解析）
     * @param publicKey
     * @param token
     * @return
     */
    public static UserInfo getUserInfo(PublicKey publicKey, String token) {
        Jws<Claims> claimsJws = parseToken(publicKey, token);
        Claims body = claimsJws.getBody();
        return new UserInfo(
              body.get(JwtConstants.JWT_KEY_ID,Long.class),
                body.get(JwtConstants.JWT_ACCOUNT_TYPE,Integer.class),
                body.get(JwtConstants.JWT_KEY_USER_NAME,String.class)
        );
    }

    /**
     * 从Token中获取用户信息（使用公钥解析）
     * @param publicKey
     * @param token
     * @return
     * @throws Exception
     */
    public static UserInfo getUserInfo(byte[] publicKey, String token) throws Exception {
        Jws<Claims> claimsJws = parseToken(publicKey, token);
        Claims body = claimsJws.getBody();
        return new UserInfo(
                body.get(JwtConstants.JWT_KEY_ID,Long.class),
                body.get(JwtConstants.JWT_ACCOUNT_TYPE,Integer.class),
                body.get(JwtConstants.JWT_KEY_USER_NAME,String.class)
        );
    }

}
