package edu.practice.svc.config.cache;

import edu.practice.svc.uril.CacheConstant;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.cache.Caching;
import javax.cache.spi.CachingProvider;

@Configuration
@EnableCaching
public class CacheConfig implements CachingConfigurer {

    @Bean
    @Override
    public CacheManager cacheManager(){
        CachingProvider cachingProvider = Caching.getCachingProvider();
        javax.cache.CacheManager cacheManager = cachingProvider.getCacheManager();
        cacheManager.createCache(CacheConstant.CACHE_APPLICATION_CONSTANT, CacheConfigurations.cacheConfiguration());
        return new JCacheCacheManager(cacheManager);
    }
}
