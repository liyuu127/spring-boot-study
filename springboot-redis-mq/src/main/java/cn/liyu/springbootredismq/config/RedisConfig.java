package cn.liyu.springbootredismq.config;


import cn.liyu.springbootredismq.service.ConsumerImpl;
import cn.liyu.springbootredismq.service.ConsumerImpl2;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.lang.reflect.Method;
import java.time.Duration;

@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

    @Autowired
    LettuceConnectionFactory lettuceConnectionFactory;

    @Override
    @Bean
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder sb = new StringBuilder();
                sb.append(target.getClass().getName());
                sb.append(method.getName());
                for (Object obj : params) {
                    sb.append(obj.toString());
                }
                return sb.toString();
            }
        };
    }

    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofHours(1)); // 设置缓存有效期一小时
        return RedisCacheManager
                .builder(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory))
                .cacheDefaults(redisCacheConfiguration).build();

    }


    @Bean(name = "redisTemplate")
    RedisTemplate redisTemplate() {
        RedisTemplate rt = new RedisTemplate();
        rt.setConnectionFactory(lettuceConnectionFactory);
        rt.setKeySerializer(new StringRedisSerializer());
        rt.setHashKeySerializer(new StringRedisSerializer());
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        rt.setValueSerializer(jackson2JsonRedisSerializer);
        rt.setHashValueSerializer(jackson2JsonRedisSerializer);
        rt.setEnableTransactionSupport(true);
        rt.afterPropertiesSet();
        return rt;
    }

    @Bean
    RedisMessageListenerContainer container(@Value("${redis.channel}") String channel,
            //监听方法一
            @Qualifier("listenerAdapter") MessageListenerAdapter listenerAdapter,
            //监听方法二
            @Qualifier("listenerAdapter2") MessageListenerAdapter listenerAdapter2
    ) {

        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(lettuceConnectionFactory);
//        container.addMessageListener(listenerAdapter, new PatternTopic(channel));
//        container.addMessageListener(listenerAdapter2, new PatternTopic(channel));

        return container;
    }

    @Bean(name = "listenerAdapter")
    MessageListenerAdapter listenerAdapter(ConsumerImpl consumer) {
        return new MessageListenerAdapter(consumer, "onMessage");
    }

    @Bean(name = "listenerAdapter2")
    MessageListenerAdapter listenerAdapter2(ConsumerImpl2 consumer) {
        return new MessageListenerAdapter(consumer, "onMessage");
    }

}
