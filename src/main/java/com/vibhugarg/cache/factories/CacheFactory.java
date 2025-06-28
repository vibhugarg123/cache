package com.vibhugarg.cache.factories;

import com.vibhugarg.cache.Cache;
import com.vibhugarg.cache.policies.LRUEvictionPolicy;
import com.vibhugarg.cache.storage.HashMapBasedStorage;

public class CacheFactory<Key, Value> {

  public Cache<Key, Value> defaultCache(final int capacity) {
    return new Cache<Key, Value>(
        new LRUEvictionPolicy<Key>(), new HashMapBasedStorage<Key, Value>(capacity));
  }
}
