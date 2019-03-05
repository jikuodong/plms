package com.jikuodong.plms.interceptor.shiro.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;

/**
 *
 * describe Shiro的Redis 缓存管理器
 * @author xmc
 * @date 2018/10/18 10:35
 * @param  * @param null
 * @return
 */
public class RedisCacheManager implements CacheManager {
    @Override
    public <K, V> Cache<K, V> getCache(String s) {
        return new RedisCache<>();
    }
}
