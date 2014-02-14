package labfive.linkedlist;

public class Node {
    Node next;
    int data;
    
    public Node() {
        this.next = null;
    }
    
    public Node(int dataValue) {
        this.data = dataValue;
        this.next = null;
    }
    
    public Node(int dataValue, Node nextValue) {
        this.data = dataValue;
        this.next = nextValue;
    }
    
    public int getData() {
        return this.data;
    }
    
    public void setData(int dataValue) {
        this.data = dataValue;
    }
    
    public Node getNext() {
        return this.next;
    }
    
    public void setNext(Node nextValue) {
        this.next = nextValue;
    }
}