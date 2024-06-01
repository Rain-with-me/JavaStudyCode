package 系统设计.Lru;

import java.util.Optional;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2023/12/8 15:07
 **/
public interface Cache<K,V> {
    Optional<V> get(K key);
    boolean put(K key,V value);
    boolean isEmpty();
    int size();
    void clear();
}
