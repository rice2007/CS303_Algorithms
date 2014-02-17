package labfive.linkedlist;

public class LinkedList {

    private Node current;
    private Node head;
    private Node tail;
    private int listCount;
    
    public LinkedList() {
        // to be implemented//
    }
    
    public boolean isEmpty() {
        return (listCount == 0);
    }
    
    public void add(int data) {
        Node node = new Node(data);
        if (this.listCount == 0) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.setNext(node);
            this.tail = node;
        }
        listCount++;
    }
    
    public void add(int data, int index) {
        Node node = new Node(data);
        if (index == 0) {
            node.setNext(this.head);
            this.head = node;
        } else {

        }
        listCount++;
    }
    
    public int get(int index) {
        this.current = this.head;
        for (int i = 0; i < index; i++) {
            this.current = this.current.getNext();
        }
        return this.current.getData();
    }
    
    public int contains(int val) {
        //int i = -1;
        for (int i = 0; i < this.size(); i++) {
            if (val == this.get(i)) {
                return 1;
            }
        }
        return -1;
    }
    
    public boolean remove() {
        return true;
    }
    
    public boolean remove(int index)
    {
        // to be implemented//
        return true;
    }
    
    public int size() {
        return listCount;
    }

    @Override
    public String toString() {
        
        // to be implemented//
        return "0";
    }
}