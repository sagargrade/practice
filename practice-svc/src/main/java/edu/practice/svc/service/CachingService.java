package edu.practice.svc.service;

import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
@Slf4j
public class CachingService {
    private final CacheManager cacheManager;

    public CachingService(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    public void evictAllCaches() {
        log.debug("Evicting all caches.");

        cacheManager.getCacheNames().stream()
                .map(cacheManager::getCache)
                .filter(Objects::nonNull)
                .forEach(Cache::clear);
    }
    public void evictCache(@NotNull String cacheName) {
        Cache cache = cacheManager.getCache(cacheName);
        if(cache != null) {
            log.debug("Evicting cache {}", cacheName);
            cache.clear();
        } else {
            log.error("Undefined cache {}", cacheName);
        }
    }
}
