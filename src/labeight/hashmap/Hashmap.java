package labeight.hashmap;


import java.util.LinkedList;
public class Hashmap {

    private LinkedList<HashElement> hashList = new LinkedList<>();

    private static int mapSize;
    private final static int defaultMapSize = 100;

    public Hashmap() {
        this.mapSize = defaultMapSize;
        for (int i = 0; i < mapSize; i++) {
            this.hashList.add(i, null);
        }
    }

    public Hashmap(int size) {
        this.mapSize = size;
        for (int i = 0; i < mapSize; i++) {
            this.hashList.add(i, null);
        }
    }

    public String put(int key, String value) {
        HashElement element = new HashElement(key, value);
        int hashKey = element.getKey();
        hashKey = hash(hashKey);
        if (hashList.get(hashKey) == null) {
            hashList.add(hashKey, element);
            element.setHash(hashKey);
            System.out.println("Key inserted at " + hashKey);
        } else {
            hashKey = reHash(hashKey);
            hashList.add(hashKey, element);
            element.setHash(hashKey);
            System.out.println("Key inserted at " + hashKey);
        }
        return element.getValue();
    }

    public String get(int key) {
        int hashKey = hash(key);
        if (hashKey == hashList.get(key).getHashKey()) {
            return hashList.get(key).getValue();
        } else {
            hashKey = reHash(hashKey);
            return hashList.get(hashKey).getValue();
        }
    }

    private static int hash(int hashKey) {
        return (hashKey % mapSize);
    }

    private static int reHash(int hashKey) {
        return ((7 * hashKey + 1) % mapSize);
    }
}
