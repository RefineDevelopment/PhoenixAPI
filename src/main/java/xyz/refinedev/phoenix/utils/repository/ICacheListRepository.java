package xyz.refinedev.phoenix.utils.repository;

import com.github.benmanes.caffeine.cache.Cache;
import xyz.refinedev.phoenix.utils.repository.filters.api.FilterOptions;
import xyz.refinedev.phoenix.utils.repository.updates.api.UpdateOptions;

import java.util.List;

public interface ICacheListRepository<K, V> extends IMapRepository<K, V> {
    boolean isLocked(K key);

    void lock(K key);

    void unlock(K key);

    void putInCache(K key, List<V> values);

    List<V> getListFromCache(K key);

    Cache<K, List<V>> getListCache();

    void updateMany(FilterOptions filterOptions, UpdateOptions updateOptions);
}