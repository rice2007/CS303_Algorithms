package labeight.hashmap;

public class HashElement {

    private int hash;
    private int key;
    private String value;

    public HashElement(int theKey, String theValue) {
        this.key = theKey;
        this.value = theValue;
    }

    public HashElement(int theKey, String theValue, int hashKey) {
        this.key = theKey;
        this.value = theValue;
        this.hash = hashKey;
    }

    public int getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public int getHashKey() {
        return this.hash;
    }

    public void setHash(int hashKey) {
        this.hash = hashKey;
    }
}
