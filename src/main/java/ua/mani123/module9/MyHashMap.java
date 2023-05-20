package ua.mani123.module9;

public class MyHashMap<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private Node<K, V>[] buckets;
    private int size;

    private interface Node<K, V> {
        K getKey();
        V getValue();
        void setValue(V value);
        Node<K, V> getNext();
        void setNext(Node<K, V> next);
    }

    private static class HashMapNode<K, V> implements Node<K, V> {
        private final K key;
        private V value;
        private Node<K, V> next;

        public HashMapNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Node<K, V> getNext() {
            return next;
        }

        public void setNext(Node<K, V> next) {
            this.next = next;
        }
    }

    public MyHashMap() {
        buckets = new Node[INITIAL_CAPACITY];
        size = 0;
    }

    public void put(K key, V value) {
        int bucketIndex = getBucketIndex(key);

        Node<K, V> newNode = new HashMapNode<>(key, value);

        if (buckets[bucketIndex] == null) {
            buckets[bucketIndex] = newNode;
        } else {
            Node<K, V> currentNode = buckets[bucketIndex];
            Node<K, V> prevNode = null;

            while (currentNode != null) {
                if (currentNode.getKey().equals(key)) {
                    currentNode.setValue(value);
                    return;
                }

                prevNode = currentNode;
                currentNode = currentNode.getNext();
            }

            assert prevNode != null;
            prevNode.setNext(newNode);
        }

        size++;
    }

    public void remove(K key) {
        int bucketIndex = getBucketIndex(key);

        Node<K, V> currentNode = buckets[bucketIndex];
        Node<K, V> prevNode = null;

        while (currentNode != null) {
            if (currentNode.getKey().equals(key)) {
                if (prevNode == null) {
                    buckets[bucketIndex] = currentNode.getNext();
                } else {
                    prevNode.setNext(currentNode.getNext());
                }

                size--;
                return;
            }

            prevNode = currentNode;
            currentNode = currentNode.getNext();
        }
    }

    public void clear() {
        buckets = new Node[INITIAL_CAPACITY];
        size = 0;
    }

    public int size() {
        return size;
    }

    public V get(K key) {
        int bucketIndex = getBucketIndex(key);

        Node<K, V> currentNode = buckets[bucketIndex];

        while (currentNode != null) {
            if (currentNode.getKey().equals(key)) {
                return currentNode.getValue();
            }

            currentNode = currentNode.getNext();
        }

        return null;
    }

    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % buckets.length;
    }

}
