package com.jikuodong.plms.interceptor.shiro.cache;

import com.jikuodong.plms.utils.redis.RedisUtil;
import org.apache.shiro.cache.Cache;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 *
 * describe Shiro的Redis 缓存
 * @author xmc
 * @date 2018/10/18 10:35
 * @param  * @param null
 * @return
 */
public class RedisCache<K, V> implements Cache<K, V> {

    private RedisUtil redisUtil = RedisUtil.getInstance();

    /**
     * 过期时间
     */
    private static final long EXPIRE_TIME = 600;

    /**
     * 缓存的key前缀
     */
    private static final String KEY_PREFIX = "shiro:cache:redis";

    @Override
    public V get(K k) {
        return (V) redisUtil.get(getKey(k));
    }

    @Override
    public V put(K k, V v) {
        redisUtil.set(getKey(k), v, EXPIRE_TIME);
        return (V) redisUtil.get(getKey(k));
    }

    @Override
    public V remove(K k) {
        V o = (V) redisUtil.get(getKey(k));
        redisUtil.del(getKey(k));
        return o;
    }

    @Override
    public void clear() {
        redisUtil.batchDel(KEY_PREFIX);
    }

    @Override
    public int size() {
        return redisUtil.getKeySize(KEY_PREFIX);
    }

    @Override
    public Set<K> keys() {
        return redisUtil.getKeys(KEY_PREFIX);
    }

    @Override
    public Collection values() {
        List<Object> v = new ArrayList<>();
        Set set = keys();
        for (Object item:set) {
            v.add(redisUtil.get((String) item));
        }
        return v;
    }

    /**
     * 转换KEY 前缀
     *
     */
    private String getKey(Object k) {
        return KEY_PREFIX + k;
    }
}
