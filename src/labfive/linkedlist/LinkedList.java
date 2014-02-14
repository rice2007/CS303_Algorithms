package labfive.linkedlist;

public class LinkedList {

    private Node head;
    private int listCount;
    
    public LinkedList() {
        // to be implemented//
    }
    
    public boolean isEmpty() { //TODO
        return true;
    }
    
    public void add(int data) {
       // to be implemented//
    }
    
    public void add(int data, int index)
    {
        // to be implemented//
    }
    
    public int get(int index) {
        return 0;
    }
    
    public int contains(int val) {
        for (int i = 0; i < this.size(); i++) {
            if (val == this.get(i)) {
                return 1;
            }
        }
        return -1;
    }
    
    public boolean remove()
    {
        // to be implemented//
        return true;
    }
    
    public boolean remove(int index)
    {
        // to be implemented//
        return true;
    }
    
    public int size()
    {
        // to be implemented//
        return 0;
    }

    @Override
    public String toString() {
        
        // to be implemented//
        return "0";
    }
}