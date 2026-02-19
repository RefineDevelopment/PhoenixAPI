package xyz.refinedev.phoenix.utils.repository;

import xyz.refinedev.phoenix.utils.repository.filters.api.FilterOptions;
import xyz.refinedev.phoenix.utils.repository.sorting.api.SortingOptions;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface IListRepository<K, V> {
    void addToCache(V value);

    void removeFromCache(V value);

    List<V> getCache();

    Optional<V> getFromCache(K key);

    CompletableFuture<Optional<V>> fetch(K key);

    CompletableFuture<Optional<V>> fetch(FilterOptions bson);

    CompletableFuture<Optional<V>> fetch(FilterOptions bson, SortingOptions sorts);

    Optional<V> fetchSync(K key);

    Optional<V> fetchSync(FilterOptions bson);

    Optional<V> fetchSync(FilterOptions bson, SortingOptions sorts);

    CompletableFuture<List<V>> fetchAll();

    CompletableFuture<List<V>> fetchAll(FilterOptions bson);

    CompletableFuture<List<V>> fetchAll(FilterOptions bson, SortingOptions sorts);

    List<V> fetchAllSync();

    List<V> fetchAllSync(FilterOptions bson);

    List<V> fetchAllSync(FilterOptions bson, SortingOptions sorts);

    CompletableFuture<Void> save(V value);

    CompletableFuture<Void> save(List<V> values);

    void saveSync(V values);

    void saveSync(List<V> values);

    CompletableFuture<Void> delete(V value);

    CompletableFuture<Long> delete(FilterOptions options);

    void deleteSync(V value);

    long deleteSync(FilterOptions options);

    CompletableFuture<Void> deleteAll();

    void deleteAllSync();

    long count(FilterOptions options);

    long count();

}