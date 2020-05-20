package com.zju.nir.file.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import java.time.Duration;

/**
 * Created by white_wolf on 2020/5/13.
 *
 * @author thebestwj
 */

@Configuration
public class RedisConfig extends CachingConfigurerSupport {

    @Value("${lab-file-system.cache-time}")
    static long CACHE_TIME;

    @Value("${lab-file-system.cache-prefix}")
    static String CACHE_PREFIX;

    @Autowired
    RedisConnectionFactory factory;

    @Override
    public CacheManager cacheManager() {
        RedisCacheConfiguration configuration = RedisCacheConfiguration
                .defaultCacheConfig()
                .entryTtl(Duration.ofSeconds(CACHE_TIME))
                .disableCachingNullValues()
                .computePrefixWith(s -> CACHE_PREFIX + ":" + s + ":" );
        RedisCacheManager cacheManager = new RedisCacheManager(RedisCacheWriter.nonLockingRedisCacheWriter(factory),configuration);
        return cacheManager;
    }

}
