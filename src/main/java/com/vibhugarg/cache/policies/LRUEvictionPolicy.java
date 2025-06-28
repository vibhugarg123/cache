package com.vibhugarg.cache.policies;

public class LRUEvictionPolicy implements EvictionPolicy {
  @Override
  public void keyAccessed(Object o) {}

  @Override
  public Object evictKey() {
    return null;
  }
}
