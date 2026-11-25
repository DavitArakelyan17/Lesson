public  class Pair<K, V> {
    K key;
    V value;
    Pair<K,V> next;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}
