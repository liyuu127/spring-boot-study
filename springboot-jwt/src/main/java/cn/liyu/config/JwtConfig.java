package cn.liyu.config;

import cn.liyu.utils.RsaUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.File;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author liyu
 * date 2020/8/5 17:49
 * description
 */
@Slf4j
@Data
@Configuration
@ConfigurationProperties(prefix = "ly.jwt")
public class JwtConfig {
    /**
     * 密钥
     */
    private String secret;
    /**
     * 公钥
     */
    private String pubKeyPath;
    /**
     * 私钥
     */
    private String priKeyPath;

    /**
     * token过期时间
     */
    private int expire;

    /**
     * 公钥
     */
    private PublicKey publicKey;

    /**
     * 私钥
     */
    private PrivateKey privateKey;


    @PostConstruct
    public void init() {
        try {
            String prefix = JwtConfig.class.getClassLoader().getResource("") + "/";
            File pubKey = new File(prefix + pubKeyPath);
            File priKey = new File(prefix + priKeyPath);
            if (!pubKey.exists() || !priKey.exists()) {
                // 生成公钥和私钥
                RsaUtils.generateKey(pubKeyPath, priKeyPath, secret);
            }
            // 获取公钥和私钥
            this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
            this.privateKey = RsaUtils.getPrivateKey(priKeyPath);
        } catch (Exception e) {
            log.error("初始化公钥和私钥失败！", e);
            throw new RuntimeException();
        }
    }
}
