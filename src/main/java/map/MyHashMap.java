package map;

public class MyHashMap {

    private int capacity = 1000000;
    private Entry<Integer>[] table;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        table = new Entry[capacity];
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int index = index(key);
        Entry newEntry = new Entry(key, value, null);
        if(table[index] == null){
            table[index] = newEntry;
        }else {
            Entry<Integer> previousNode = null;
            Entry<Integer> currentNode = table[index];
            while(currentNode != null){
                if(currentNode.getKey().equals(key)){
                    currentNode.setValue(value);
                    break;
                }
                previousNode = currentNode;
                currentNode = currentNode.getNext();
            }
            if(previousNode != null)
                previousNode.setNext(newEntry);
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        Integer value = -1;
        int index = index(key);
        Entry<Integer> entry = table[index];
        while (entry != null){
            if(entry.getKey().equals(key)) {
                value = entry.getValue();
                break;
            }
            entry = entry.getNext();
        }
        return value;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int index = index(key);
        Entry previous = null;
        Entry entry = table[index];
        while (entry != null){
            if(entry.getKey().equals(key)){
                if(previous == null){
                    entry = entry.getNext();
                    table[index] = entry;
                    return;
                }else {
                    previous.setNext(entry.getNext());
                    return;
                }
            }
            previous = entry;
            entry = entry.getNext();
        }
    }

    private int index(Integer key){
        if(key == null){
            return 0;
        }
        return Math.abs(key.hashCode() % capacity);
    }

    private static class Entry<Integer> {

        private Integer key;
        private Integer value;
        private Entry<Integer> next;

        public Entry(Integer key, Integer value, Entry<Integer> next){
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Integer getKey() {
            return key;
        }

        public void setKey(Integer key) {
            this.key = key;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Entry getNext() {
            return next;
        }

        public void setNext(Entry<Integer> next) {
            this.next = next;
        }
    }

}
