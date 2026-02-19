
package xyz.refinedev.phoenix.utils.repository;

import xyz.refinedev.phoenix.utils.repository.filters.api.FilterOptions;
import xyz.refinedev.phoenix.utils.repository.sorting.api.SortingOptions;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface IMapRepository<K, V> {
    String toJson(V value);

    Map<K, V> getMap();

    Optional<V> getFromCache(K key);

    void addToCache(K key, V value);

    void removeFromCache(K key);

    CompletableFuture<Optional<V>> fetch(K key);

    CompletableFuture<Optional<V>> fetch(FilterOptions bson);

    CompletableFuture<Optional<V>> fetch(FilterOptions bson, SortingOptions sort);

    Optional<V> fetchSync(K key);

    Optional<V> fetchSync(FilterOptions bson);

    Optional<V> fetchSync(FilterOptions bson, SortingOptions sorts);

    CompletableFuture<List<V>> fetchAll();

    CompletableFuture<List<V>> fetchAll(FilterOptions bson);

    CompletableFuture<List<V>> fetchAll(FilterOptions bson, SortingOptions sorts);

    List<V> fetchAllSync();

    List<V> fetchAllSync(FilterOptions bson);

    List<V> fetchAllSync(FilterOptions bson, SortingOptions sorts);

    CompletableFuture<Boolean> isInDatabase(K key);

    boolean isInDatabaseSync(K key);

    CompletableFuture<Void> save(K key, V value);

    CompletableFuture<Void> save(List<V> values);

    CompletableFuture<Void> saveGson(K key, String value);

    void saveSync(K key, V value);

    void saveSync(List<V> values);

    void saveGsonSync(K key, String value);

    CompletableFuture<Void> delete(K key);

    CompletableFuture<Long> delete(FilterOptions options);

    void deleteSync(K key);

    long deleteSync(FilterOptions options);

    CompletableFuture<Void> deleteAll();

    void deleteAllSync();

    long count(FilterOptions options);

    long count();
}