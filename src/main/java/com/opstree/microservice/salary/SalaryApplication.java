package com.opstree.microservice.salary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import java.time.Duration;

/**
 * This class contains the main application for salary management.
 */
@SpringBootApplication
@EnableCaching
public final class SalaryApplication {

    /**
     * Configures the RedisTemplate for managing Redis operations.
     * @param connectionFactory the connection factory to be used
     * @return a configured RedisTemplate
     */
    @Bean
    public RedisTemplate<Object, Object> redisTemplate(
            final RedisConnectionFactory connectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        Jackson2JsonRedisSerializer<Employee> serializer =
                new Jackson2JsonRedisSerializer<>(Employee.class);
        template.setDefaultSerializer(serializer);
        return template;
    }

    /**
     * Configures the RedisCacheManager for caching.
     * @param connectionFactory the connection factory to be used
     * @return a configured RedisCacheManager
     */
    @Bean
    public RedisCacheManager cacheManager(
            final RedisConnectionFactory connectionFactory) {
        RedisCacheConfiguration config = RedisCacheConfiguration
    .defaultCacheConfig()
                .prefixCacheNameWith(this.getClass().getPackageName() + ".")
                .entryTtl(Duration.ofSeconds(1))
                .disableCachingNullValues();
        return RedisCacheManager.builder(connectionFactory)
                .cacheDefaults(config)
                .build();
    }

    /**
     * The main method that starts the Spring Boot application.
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        SpringApplication.run(SalaryApplication.class, args);
    }
}
