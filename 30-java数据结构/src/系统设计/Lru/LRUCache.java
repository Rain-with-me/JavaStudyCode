package 系统设计.Lru;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2023/12/8 15:10
 **/
public class LRUCache<K,V> implements Cache<K,V>{
    private DoublyLinkedList<CacheElement<K,V>> doublyLinkedList;
    private Map<K,LinkedListNode<CacheElement<K,V>>> map;
    private int size;
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public LRUCache(DoublyLinkedList<CacheElement<K, V>> doublyLinkedList, Map<K, LinkedListNode<CacheElement<K, V>>> map, int size) {
        this.doublyLinkedList = new DoublyLinkedList<>();
        this.map = new ConcurrentHashMap<>();
        this.size = size;
    }

    @Override
    public Optional<V> get(K key) {
        return Optional.empty();
    }

    @Override
    public boolean put(K key, V value) {
        CacheElement<K, V> element = new CacheElement<>(key, value);
        LinkedListNode<CacheElement<K, V>> newNode;
        if (map.containsKey(key)){
            LinkedListNode<CacheElement<K, V>> node = map.get(key);
//            更新结点
            newNode = doublyLinkedList.updateAndMoveToFront(node, element);
        }else {
            if (this.size()>=this.size){
//              清除最少使用的

            }
            newNode=doublyLinkedList.add(element);
        }
        if (doublyLinkedList.isEmpty()){
            return false;
        }
        map.put(key,newNode);
        return true;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return doublyLinkedList.size();
    }

    @Override
    public void clear() {

    }
}
