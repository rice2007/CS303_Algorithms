package labeight.hashmap;

public class HashElement {

    private boolean collision;
    private int hash;
    private int key;
    private String value;

    public HashElement(int theKey, String theValue) {
        this.key = theKey;
        this.value = theValue;
        this.collision = false;
        this.hash = 0;
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

    public boolean getCollision() {
        return this.collision;
    }

    public void setHash(int hashKey) {
        this.hash = hashKey;
    }

    public boolean collided() {
        if (this.collision) {
            return this.collision = false;
        } else {
            return this.collision = true;
        }
    }
}
