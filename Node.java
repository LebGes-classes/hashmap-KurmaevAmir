/*
 * File: Node
 * Description: Class representing a node in a hashTable
 * @author Amir Kurmaev
 * Copyright: (c) 2024 Amir Kurmaev
 * License: This file is licensed under the MIT License
 */
public class Node<K, V> {
    int hash;
    K key;
    V value;
    Node<K, V> next;

    public Node(int hash, K key, V value) {
        this.hash = hash;
        this.key = key;
        this.value = value;
    }
}
