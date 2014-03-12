package labeight.hashmap;


import java.util.LinkedList;
public class Hashmap {

    private LinkedList<HashElement> hashList = new LinkedList<>();

    private static int mapSize;
    private final static int defaultMapSize = 100;

    public Hashmap() {
        mapSize = defaultMapSize;
        for (int i = 0; i < mapSize; i++) {
            this.hashList.add(i, null);
        }
    }

    public Hashmap(int size) {
        mapSize = size;
        for (int i = 0; i < mapSize; i++) {
            this.hashList.add(i, null);
        }
    }

    public String put(int key, String value) {
        HashElement element = new HashElement(key, value);
        int hashKey = hash(key);
        if (hashList.get(hashKey) == null) {
            hashList.remove(hashKey);
            hashList.add(hashKey, element);
            element.setHash(hashKey);
            //System.out.println("Key inserted at " + hashKey);
        } else {
            hashKey = reHash(hashKey);
            hashList.remove(hashKey);
            hashList.add(hashKey, element);
            element.setHash(hashKey);
           // System.out.println("Key inserted at " + hashKey);
        }
        return element.getValue();
    }

    public String get(int key) {
        int hashKey = hash(key);
        if (hashKey == hashList.get(hashKey).getHashKey()) {
            return hashList.get(hashKey).getValue();
        } else if (reHash(hashKey) == hashList.get(reHash(hashKey)).getHashKey()) {
            return hashList.get(reHash(key)).getValue();
        } else {
            return null;
        }
    }

    private static int hash(int hashKey) {
        return (hashKey % mapSize);
    }

    private static int reHash(int hashKey) {
        return ((7 * hashKey + 1) % mapSize);
    }
}
