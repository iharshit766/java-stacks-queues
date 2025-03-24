import java.util.LinkedList;

class CustomHashMap<K, V> {
    private static final int SIZE = 16;
    private LinkedList<Entry<K, V>>[] map;
    
    @SuppressWarnings("unchecked")
    public CustomHashMap() {
        map = new LinkedList[SIZE];
    }
    
    private int getIndex(K key) {
        return key.hashCode() % SIZE;
    }
    
    public void put(K key, V value) {
        int index = getIndex(key);
        if (map[index] == null) {
            map[index] = new LinkedList<>();
        }
        for (Entry<K, V> entry : map[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        map[index].add(new Entry<>(key, value));
    }
    
    public V get(K key) {
        int index = getIndex(key);
        if (map[index] != null) {
            for (Entry<K, V> entry : map[index]) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
        }
        return null;
    }
    
    public void remove(K key) {
        int index = getIndex(key);
        if (map[index] != null) {
            map[index].removeIf(entry -> entry.key.equals(key));
        }
    }
    
    private static class Entry<K, V> {
        K key;
        V value;
        
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}

public class CustomHashMapDemo {
    public static void main(String[] args) {
        CustomHashMap<String, Integer> hashMap = new CustomHashMap<>();
        hashMap.put("One", 1);
        hashMap.put("Two", 2);
        hashMap.put("Three", 3);
        
        System.out.println("Value for 'Two': " + hashMap.get("Two"));
        hashMap.remove("Two");
        System.out.println("Value for 'Two' after removal: " + hashMap.get("Two"));
    }
}
