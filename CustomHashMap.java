/*
 * File: CustomHashMap
 * Description: Hashmap implementation
 * @author Amir Kurmaev
 * Copyright: (c) 2024 Amir Kurmaev
 * License: This file is licensed under the MIT License
 */
public class CustomHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private int capacity;
    private float loadFactor;
    private int size;
    private Node<K, V>[] table;

    public CustomHashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public CustomHashMap(int capacity, float loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        this.table = new Node[DEFAULT_CAPACITY];
    }

    private int hash(K key) {
        return key.hashCode() % capacity;
    }

    private void resize() {
        int newCapacity = capacity * 2;
        Node<K, V>[] newTable = new Node[newCapacity];
        for (int i = 0; i < capacity; i++) {
            Node<K, V> node = table[i];
            while (node != null) {
                Node<K, V> next = node.next;
                int index = hash(node.key);
                node.next = newTable[index];
                newTable[index] = node;
                node = next;
            }
        }
        table = newTable;
        capacity = newCapacity;
    }

    public void put(K key, V value) {
        int index = hash(key);
        System.out.println(index);
        Node<K, V> node = table[index];
        while (node != null) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
            node = node.next;
        }
        Node<K, V> newNode = new Node<>(index, key, value);
        newNode.next = table[index];
        table[index] = newNode;
        size++;
        if (size > capacity * loadFactor) {
            resize();
        }
    }

    public V get(K key) {
        int index = hash(key);
        Node<K, V> node = table[index];
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        Node<K, V> node = table[index];
        Node<K, V> previous = null;
        while (node != null) {
            if (node.key.equals(key)) {
                if (previous == null) {
                    table[index] = node.next;
                } else {
                    previous.next = node.next;
                }
                size--;
                return;
            }
            previous = node;
            node = node.next;
        }
    }

    public boolean containsKey(K key) {
        int index = hash(key);
        Node<K, V> node = table[index];
        while (node != null) {
            if (node.key == key) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public boolean containsValue(V value) {
        for (Node<K, V> node : table) {
            Node<K, V> current = node;
            while (current != null) {
                if (current.value.equals(value)) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }
}