package cn.liyu;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.commons.codec.binary.Base64;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * @author liyu
 * date 2020/8/5 19:11
 * description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Jwt_auth0 {

    @Test
    public void test_creat_token() {
        String s = JWT.create()
                .withClaim("id", 11)
                .withClaim("name", "liyu")
                .sign(Algorithm.HMAC256("1234"));
        System.out.println("s = " + s);
    }

    @Test
    public void parseJwt() {
        String token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoibGl5dSIsImlkIjoxMX0.Wq44L40GrSrrHN1G8izoRiQTBcIk5nfAu4FxHL3DyL4";
        Integer id = JWT.decode(token)
                .getClaim("id")
                .as(Integer.class);
        System.out.println("id = " + id);

    }

    @Test
    public void testHS256() {
        System.out.println("Test HS256");
        // 生成 JWT 算法
        Algorithm algorithm = Algorithm.HMAC256("TEST");
        test(algorithm);
    }

    @Test
    public void testRSA() throws NoSuchAlgorithmException {
        System.out.println("Test RSA");
        // 生成 RSA 密钥对生成器
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        // 初始化密钥长度
        keyPairGenerator.initialize(2048);
        // 生成 RSA 密钥对
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        // 生成 JWT 算法
        Algorithm algorithm = Algorithm.RSA256((RSAPublicKey) keyPair.getPublic(), (RSAPrivateKey) keyPair.getPrivate());
        test(algorithm);
    }

    private void test(Algorithm algorithm) {
        String issuer = "Self";
        String subject = "Test Auth0 JWT";
        String jwtId = "jwt-id-1";
        // 生成 JWT Token
        String token = JWT.create()
                .withIssuer(issuer)
                .withExpiresAt(date(2020, 12, 31, 23, 59, 59))
                .withSubject(subject)
                .withAudience("Audience X", "Audience Y", "Audience Z")
                .withNotBefore(date(2020, 4, 1, 0, 0, 0))
                .withIssuedAt(date(2020, 1, 1, 0, 0, 0))
                .withJWTId(jwtId)
                .sign(algorithm);
        JWTVerifier jwtVerifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token);
        String header = decodedJWT.getHeader();
        String payload = decodedJWT.getPayload();
        String signature = decodedJWT.getSignature();
        Assert.assertEquals(token, header + "." + payload + "." + signature);
        Assert.assertEquals(algorithm.getName(), decodedJWT.getAlgorithm());
        Assert.assertEquals("JWT", decodedJWT.getType());
        Assert.assertEquals(issuer, decodedJWT.getIssuer());
        Assert.assertEquals(subject, decodedJWT.getSubject());
        Assert.assertEquals(jwtId, decodedJWT.getId());
        System.out.println(new String(Base64.decodeBase64(header)));
        System.out.println(new String(Base64.decodeBase64(payload)));
    }

    private Date date(int year, int month, int day, int hour, int minute, int second) {
        LocalDateTime localDateTime = LocalDateTime.of(year, month, day, hour, minute, second);
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
        return Date.from(zonedDateTime.toInstant());
    }
}
