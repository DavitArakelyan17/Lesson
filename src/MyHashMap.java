public class MyHashMap <K, V>{
private  Pair<K,V> [] buckets;
private int capacity;
private int size;
    // Initializing HashMap( The way it is stored in the memory)
    public MyHashMap() {
        capacity = 16;
        size = 0;
        buckets = (Pair<K, V>[]) new Pair[capacity];
    }
    // GetIndex function (Calculates the Array's position, where the key should be stored)
    private int getIndex(K key){
        int hash = hashCode();
        if(hashCode() < 0){
            hash = hash * -1;
        }
        return (hash % capacity);
    }

    // Put function
    public void put (K key, V value){
        int index = getIndex(key);

        Pair<K, V> current = buckets[index];

        while (current != null){
            if(current.key.equals(key)){
                current.value = value;
                return;
            }
            current = current.next;
        }
        Pair<K,V> newPair = new Pair<>(key, value);
        newPair.next = buckets[index];
        buckets[index] = newPair;

        size++;
    }
        // Get function (returns the value)
    public V get(K key){
        int index = getIndex(key);
        Pair<K,V> current = buckets[index];
        while (current !=null){
            if(current.key.equals(key)){
                return current.value;
            }

            current = current.next;
        }
        return null;
    }




}
