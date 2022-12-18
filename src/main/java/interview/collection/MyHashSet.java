package interview.collection;

import java.util.HashMap;

class MyHashSet {

    private static final Object DUMMY = new Object();
    private final HashMap<Integer,Object> map;

    /** Initialize your data structure here. */
    public MyHashSet() {
        map = new HashMap<Integer, Object>();
    }

    public void add(int key) {
        map.put(key, DUMMY);
    }

    public void remove(int key) {
        map.remove(key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return map.containsKey(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
