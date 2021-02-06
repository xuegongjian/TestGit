package leecode155;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LFUCache {
	Map<Integer,Integer> map = null;
	Queue<Integer> queue = null;
	int capacity;
    public LFUCache(int capacity) {
    	this.capacity = capacity;
    	map = new HashMap<>(capacity);
    	queue = new LinkedList<Integer>();
    }
    
    public int get(int key) {
    	Integer value = map.get(key);
    	if(value == null) return -1;
    	queue.offer(key);
    	return 0;
    }
    
    public void put(int key, int value) {
    	map.put(key, value);
    	queue.offer(key);
    	if(map.size() > capacity){
    		int de = queue.poll();
    		map.remove(de);
    	}
    }
}
