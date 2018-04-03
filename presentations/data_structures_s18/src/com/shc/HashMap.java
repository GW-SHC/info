package com.shc;

import java.util.Iterator;
import java.util.LinkedList;

public class HashMap <K, V> {
    private static final int DEFAULT_MAP_SIZE = 100;
    LinkedList<KeyValue<K, V>>[] map;

    public HashMap() {
        this(DEFAULT_MAP_SIZE);
    }

    public HashMap(int size) {
        map = new LinkedList[size];

        for (int i = 0; i<map.length; i++) {
            map[i] = new LinkedList<>();
        }
    }

    /**
     * Associates the specified value with the specified key in this map.
     * @param key
     * @param value
     * @return
     */
    public V put(K key, V value) {
        LinkedList<KeyValue<K, V>> list = map[key.hashCode() % map.length];

        for (int i = 0; i<list.size(); i++) {
            KeyValue<K, V> keyVal = list.get(i);

            // If key already exists in the map
            if (keyVal.key.equals(key)) {
                keyVal.value = value;
                return value;
            }
        }

        list.add(new KeyValue<>(key, value)); // first time in the list
        return value;
    }

    /**
     * Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
     * @param key
     * @return
     */
    public V get(K key) {
        LinkedList<KeyValue<K, V>> list = map[key.hashCode() % map.length];

        for (int i = 0; i<list.size(); i++) {
            KeyValue<K, V> keyVal = list.get(i);

            if (keyVal.key.equals(key)) {
                return keyVal.value;
            }
        }

        return null;
    }

    /**
     * Removes the mapping for the specified key from this map if present.
     * @param key
     * @return
     */
    public V remove(K key) {
        LinkedList<KeyValue<K, V>> list = map[key.hashCode() % map.length];
        Iterator<KeyValue<K, V>> iter = list.iterator();

        while (iter.hasNext()) {
            KeyValue<K, V> keyVal = iter.next();
            if (keyVal.key.equals(key)) {
                iter.remove();
                return keyVal.value;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LinkedList<KeyValue<K, V>> l : map) {
            if (!l.isEmpty()) {
                sb.append(l.toString());
                sb.append(",");
            }
        }

        return sb.toString();
    }

    public class KeyValue<K, V> {
        K key;
        V value;

        public KeyValue(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "(" + key + ", " + value + ")";
        }
    }
}
