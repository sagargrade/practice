package edu.practice.svc.config.cache;

import lombok.extern.slf4j.Slf4j;

import javax.cache.event.*;
import java.io.Serializable;
import java.util.function.Consumer;

@Slf4j
public class CacheEntryListener implements CacheEntryCreatedListener<Object, Object>, CacheEntryUpdatedListener<Object, Object>,
        CacheEntryRemovedListener<Object, Object>,
        CacheEntryExpiredListener<Object, Object>,
        Serializable {

    @Override
    public void onCreated(Iterable<CacheEntryEvent<?, ?>> cacheEntryEvents) throws CacheEntryListenerException {
        this.logCacheEntryEvents(cacheEntryEvents);
    }

    @Override
    public void onExpired(Iterable<CacheEntryEvent<?, ?>> cacheEntryEvents) throws CacheEntryListenerException {
        this.logCacheEntryEvents(cacheEntryEvents);
    }

    @Override
    public void onRemoved(Iterable<CacheEntryEvent<?, ?>> cacheEntryEvents) throws CacheEntryListenerException {
        this.logCacheEntryEvents(cacheEntryEvents);
    }

    @Override
    public void onUpdated(Iterable<CacheEntryEvent<?, ?>> cacheEntryEvents) throws CacheEntryListenerException {
        this.logCacheEntryEvents(cacheEntryEvents);
    }

    private void logCacheEntryEvents(Iterable<CacheEntryEvent<?, ? extends Object>> cacheEntryEvents) {
        cacheEntryEvents.forEach((Consumer<CacheEntryEvent>) cacheEntryEvent -> log.info("Event {} on Cache[{}] with Key {}: Old value[{}], New value[{}]",
                cacheEntryEvent.getEventType().name(),
                cacheEntryEvent.getSource().getName(),
                cacheEntryEvent.getKey(),
                cacheEntryEvent.getOldValue(),
                cacheEntryEvent.getValue()));
    }
}
