package edu.practice.svc.config.cache;

import javax.cache.configuration.FactoryBuilder;
import javax.cache.configuration.MutableCacheEntryListenerConfiguration;
import javax.cache.configuration.MutableConfiguration;

public final class CacheConfigurations {

    private CacheConfigurations() {
        throw new UnsupportedOperationException("This is a utility class and can not be instantiated");
    }

    public static MutableConfiguration<Object, Object> cacheConfiguration() {
        return new MutableConfiguration<>()
                .setTypes(Object.class, Object.class)
                .setStoreByValue(false)
                .setManagementEnabled(true)
                .setStatisticsEnabled(true)
                .addCacheEntryListenerConfiguration(
                        new MutableCacheEntryListenerConfiguration<>(FactoryBuilder.factoryOf(new CacheEntryListener()), null, true, true)
                );
    }
}
