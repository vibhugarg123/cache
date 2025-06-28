package com.vibhugarg.cache.storage;

import com.vibhugarg.cache.exceptions.ResourceNotFoundException;
import com.vibhugarg.cache.exceptions.StorageFullException;

public interface Storage<Key, Value> {

  void add(Key k, Value v) throws StorageFullException;

  void remove(Key k) throws ResourceNotFoundException;

  Value get(Key k) throws ResourceNotFoundException;
}
