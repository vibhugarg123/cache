package com.vibhugarg.cache.storage;

import com.vibhugarg.cache.exceptions.ResourceNotFoundException;
import com.vibhugarg.cache.exceptions.StorageFullException;
import java.util.HashMap;
import java.util.Map;

public class HashMapBasedStorage<Key, Value> implements Storage<Key, Value> {
  Map<Key, Value> storage;
  int capacity;

  public HashMapBasedStorage(int capacity) {
    this.storage = new HashMap<>();
    this.capacity = capacity;
  }

  @Override
  public void add(Key k, Value v) throws StorageFullException {
    if (isStorageFull()) {
      throw new StorageFullException(
          String.format("Storage is full, only %d keys can be fitted", capacity));
    }
    storage.put(k, v);
  }

  @Override
  public void remove(Key k) throws ResourceNotFoundException {
    if (!storage.containsKey(k)) {
      throw new ResourceNotFoundException(String.format("key %s not found", k));
    }
    storage.remove(k);
  }

  @Override
  public Value get(Key k) throws ResourceNotFoundException {
    if (!storage.containsKey(k)) {
      throw new ResourceNotFoundException(String.format("key %s not found", k));
    }
    return storage.get(k);
  }

  private boolean isStorageFull() {
    return this.capacity == storage.size();
  }
}
