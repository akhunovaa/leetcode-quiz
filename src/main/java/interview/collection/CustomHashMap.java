package interview.collection;

public class CustomHashMap<K, V> {

    /**
     * The load factor used when none specified in constructor.
     */
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    /**
     * The maximum capacity, used if a higher value is implicitly specified
     * by either of the constructors with arguments.
     * MUST be a power of two <= 1<<30.
     */
    static final int MAXIMUM_CAPACITY = 1 << 30; // 1 (0000 0000 0000 0000 0000 0000 0000 0001) << 30 => 1 073 741 824  (0100 0000 0000 0000 0000 0000 0000 0000)


    /**
     * The default initial capacity - MUST be a power of two.
     */
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // 1 (0000 0001) << 4 => 16  (0001 0000)

    /**
     * The load factor for the hash table.
     *
     * @serial
     */
    final float loadFactor;

    transient int modCount;

    // (The javadoc description is true upon serialization.
    // Additionally, if the table array has not been allocated, this
    // field holds the initial array capacity, or zero signifying
    // DEFAULT_INITIAL_CAPACITY.)
    int threshold;

    /**
     * The number of key-value mappings contained in this map.
     */
    transient int size;

    /* ---------------- Fields -------------- */

    /**
     * The table, initialized on first use, and resized as
     * necessary. When allocated, length is always a power of two.
     * (We also tolerate length zero in some operations to allow
     * bootstrapping mechanics that are currently not needed.)
     */
    transient CustomHashMap.Node<K, V>[] table;

    public CustomHashMap(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal initial capacity: " + initialCapacity);
        if (initialCapacity > MAXIMUM_CAPACITY)
            initialCapacity = MAXIMUM_CAPACITY;
        if (loadFactor <= 0 || Float.isNaN(loadFactor))
            throw new IllegalArgumentException("Illegal load factor: " + loadFactor);
        this.loadFactor = loadFactor;
        this.threshold = tableSizeFor(initialCapacity); // a power of two size for the given target capacity
    }


    /**
     * Constructs an empty {@code HashMap} with the specified initial
     * capacity and the default load factor (0.75).
     *
     * @param initialCapacity the initial capacity.
     * @throws IllegalArgumentException if the initial capacity is negative.
     */
    public CustomHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    /**
     * Constructs an empty {@code HashMap} with the default initial capacity
     * (16) and the default load factor (0.75).
     */
    public CustomHashMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR; // all other fields defaulted
    }

    /**
     * Returns a power of two size for the given target capacity.
     */
    static final int tableSizeFor(int cap) {
        int n = -1 >>> Integer.numberOfLeadingZeros(cap - 1);
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    /**
     * Computes key.hashCode() and spreads (XORs) higher bits of hash
     * to lower.  Because the table uses power-of-two masking, sets of
     * hashes that vary only in bits above the current mask will
     * always collide. (Among known examples are sets of Float keys
     * holding consecutive whole numbers in small tables.)  So we
     * apply a transform that spreads the impact of higher bits
     * downward. There is a tradeoff between speed, utility, and
     * quality of bit-spreading. Because many common sets of hashes
     * are already reasonably distributed (so don't benefit from
     * spreading), and because we use trees to handle large sets of
     * collisions in bins, we just XOR some shifted bits in the
     * cheapest possible way to reduce systematic lossage, as well as
     * to incorporate impact of the highest bits that would otherwise
     * never be used in index calculations because of table bounds.
     */
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public V get(Object key) {
        Node<K, V> e;
        int keyHash = hash(key);
        return (e = getNode(keyHash, key)) == null ? null : e.value;
    }

    public boolean containsKey(Object key) {
        int keyHash = hash(key);
        return getNode(keyHash, key) != null;
    }


    public V put(K key, V value) {
        int keyHash = hash(key);
        // keyHash => hash hash for key
        // key => key the key
        // value => value the value to put
        // false => onlyIfAbsent if true, don't change existing value
        // true => evict if false, the table is in creation mode.
        return putVal(keyHash, key, value, false, true);
    }

    final V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict) {

        CustomHashMap.Node<K, V>[] tab;
        CustomHashMap.Node<K, V> p;
        int n, i;

        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;

        if ((p = tab[i = (n - 1) & hash]) == null) {
            tab[i] = newNode(hash, key, value, null); // int hash, K key, V value, CustomHashMap.Node<K,V> next
        } else {
            CustomHashMap.Node<K, V> e;
            K k;
            // checking the hash value int the array bucket and then checking the equality
            if (p.hash == hash && ((k = p.key) == key || (key != null && key.equals(k)))) {
                // and if hash int value and key equality is true => overriding the exists value int the array (bucket)
                e = p;
            } else {
                for (int binCount = 0; ; ++binCount) {
                    // checking the next value of exists in bucket array and if it is == null
                    if ((e = p.next) == null) {
                        // creating a new node and next node in existing node stands = new node (hash collision)
                        p.next = newNode(hash, key, value, null);
                        break;
                    }
                    // checking the created hash values and if it is ok => breaking the for each loop iteration
                    if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k)))) {
                        break;
                    }
                    // making p = new created with collision node (the next value of exists in bucket array)
                    p = e;
                }
            }

            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                // afterNodeAccess(e); =>  move node to last
                return oldValue;
            }
        }
        ++modCount;
        if (++size > threshold) {
            resize();
        }
        // afterNodeInsertion(evict); possibly remove eldest
        return null;
    }

    public V getOrDefault(Object key, V defaultValue) {
        CustomHashMap.Node<K, V> e;
        int hashIntKey = hash(key);
        return (e = getNode(hashIntKey, key)) == null ? defaultValue : e.value;
    }

    public V putIfAbsent(K key, V value) {
        // true => onlyIfAbsent if true change existing value
        int hashIntKey = hash(key);
        return putVal(hashIntKey, key, value, true, true);
    }

    public boolean remove(Object key, Object value) {
        int hashIntKey = hash(key);
        return removeNode(hashIntKey, key, value, true, true) != null;
    }

    public boolean replace(K key, V oldValue, V newValue) {
        CustomHashMap.Node<K, V> e;
        V v;
        if ((e = getNode(hash(key), key)) != null && ((v = e.value) == oldValue || (v != null && v.equals(oldValue)))) {
            e.value = newValue;
            // afterNodeAccess(e); =>  move node to last
            return true;
        }
        return false;
    }

    public V replace(K key, V value) {
        CustomHashMap.Node<K, V> e;
        if ((e = getNode(hash(key), key)) != null) {
            V oldValue = e.value;
            e.value = value;
            // afterNodeAccess(e); =>  move node to last
            return oldValue;
        }
        return null;
    }


    /**
     * Implements remove and related methods.
     *
     * @param hash       hash for key
     * @param key        the key
     * @param value      the value to match if matchValue, else ignored
     * @param matchValue if true only remove if value is equal
     * @param movable    if false do not move other nodes while removing
     * @return the node, or null if none
     */
    final CustomHashMap.Node<K, V> removeNode(int hash, Object key, Object value, boolean matchValue, boolean movable) {
        CustomHashMap.Node<K, V>[] tab;
        CustomHashMap.Node<K, V> p;
        int n, index;

        if ((tab = table) != null && (n = tab.length) > 0 && (p = tab[index = (n - 1) & hash]) != null) {
            CustomHashMap.Node<K, V> node = null, e;
            K k;
            V v;

            if (p.hash == hash && ((k = p.key) == key || (key != null && key.equals(k)))) {
                node = p;
            } else if ((e = p.next) != null) {
                do {
                    if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k)))) {
                        node = e;
                        break;
                    }
                    p = e;
                } while ((e = e.next) != null);

            }

            if (node != null && (!matchValue || (v = node.value) == value || (value != null && value.equals(v)))) {

                if (node == p) {
                    tab[index] = node.next;
                } else {
                    p.next = node.next;
                }
                ++modCount;
                --size;
                // afterNodeRemoval(node);  Callbacks to allow LinkedHashMap post-actions
                return node;
            }
        }
        return null;
    }


    /*
     * The following package-protected methods are designed to be
     * overridden by LinkedHashMap, but not by any other subclass.
     * Nearly all other internal methods are also package-protected
     * but are declared final, so can be used by LinkedHashMap, view
     * classes, and HashSet.
     */

    // Create a regular (non-tree) node
    CustomHashMap.Node<K, V> newNode(int hash, K key, V value, CustomHashMap.Node<K, V> next) {
        return new CustomHashMap.Node<>(hash, key, value, next);
    }

    /**
     * Initializes or doubles table size.  If null, allocates in
     * accord with initial capacity target held in field threshold.
     * Otherwise, because we are using power-of-two expansion, the
     * elements from each bin must either stay at same index, or move
     * with a power of two offset in the new table.
     *
     * @return the table
     */
    final CustomHashMap.Node<K, V>[] resize() {

        CustomHashMap.Node<K, V>[] oldTab = table;

        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        int oldThr = threshold;
        int newCap, newThr = 0;

        if (oldCap > 0) {

            if (oldCap >= MAXIMUM_CAPACITY) {
                threshold = Integer.MAX_VALUE;
                return oldTab;
            } else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY && oldCap >= DEFAULT_INITIAL_CAPACITY) {
                newThr = oldThr << 1; // double threshold 4 (0100) << 1 => 8 (1000)
            }

        } else if (oldThr > 0) { // initial capacity was placed in threshold
            newCap = oldThr;
        } else {               // zero initial threshold signifies using defaults
            newCap = DEFAULT_INITIAL_CAPACITY;
            newThr = (int) (DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
        }
        if (newThr == 0) {
            float ft = (float) newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float) MAXIMUM_CAPACITY ? (int) ft : Integer.MAX_VALUE);
        }

        threshold = newThr;

        @SuppressWarnings({"unchecked"})
        CustomHashMap.Node<K, V>[] newTab = (CustomHashMap.Node<K, V>[]) new CustomHashMap.Node[newCap];

        table = newTab;

        if (oldTab != null) {

            for (int j = 0; j < oldCap; ++j) {

                CustomHashMap.Node<K, V> e;
                if ((e = oldTab[j]) != null) {
                    oldTab[j] = null;
                    if (e.next == null) {
                        newTab[e.hash & (newCap - 1)] = e;
                    } else { // preserve order
                        CustomHashMap.Node<K, V> loHead = null, loTail = null;
                        CustomHashMap.Node<K, V> hiHead = null, hiTail = null;
                        CustomHashMap.Node<K, V> next;

                        do {
                            next = e.next;
                            if ((e.hash & oldCap) == 0) {
                                if (loTail == null)
                                    loHead = e;
                                else
                                    loTail.next = e;
                                loTail = e;
                            } else {
                                if (hiTail == null)
                                    hiHead = e;
                                else
                                    hiTail.next = e;
                                hiTail = e;
                            }
                        } while ((e = next) != null);

                        if (loTail != null) {
                            loTail.next = null;
                            newTab[j] = loHead;
                        }
                        if (hiTail != null) {
                            hiTail.next = null;
                            newTab[j + oldCap] = hiHead;
                        }
                    }
                }
            }
        }
        return newTab;
    }

    final Node<K, V> getNode(int hash, Object key) {

        CustomHashMap.Node<K, V>[] tab;
        CustomHashMap.Node<K, V> first, e;
        int n;
        K k;

        if ((tab = table) != null && (n = tab.length) > 0 && (first = tab[(n - 1) & hash]) != null) {
            if (first.hash == hash && // always check first node
                    ((k = first.key) == key || (key != null && key.equals(k))))
                return first;
            if ((e = first.next) != null) {
                do {
                    if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k))))
                        return e;
                } while ((e = e.next) != null);
            }
        }
        return null;
    }

    /**
     * Returns the number of key-value mappings in this map.
     *
     * @return the number of key-value mappings in this map
     */
    public int size() {
        return size;
    }

    /* ---------------- Static utilities -------------- */

    /**
     * Returns {@code true} if this map contains no key-value mappings.
     *
     * @return {@code true} if this map contains no key-value mappings
     */
    public boolean isEmpty() {
        return size == 0;
    }

    private static class Node<K, V> {

        // hashcode
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
