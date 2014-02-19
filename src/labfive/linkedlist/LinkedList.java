package labfive.linkedlist;

public class LinkedList {

    private Node head;
    private int listCount;
    
    public LinkedList() {
        head = null;
    }
    
    public boolean isEmpty() {
        return (listCount == 0);
    }
    
    public void add(int data) {
        if (listCount == 0) {
            head = new Node(data, null);
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.getNext();
            }
            current.next = new Node(data, null);
        }
        listCount++;
    }
    
    public void add(int data, int index) {
        if (index == 0) {
            Node node = new Node(data, head);
            head = node;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            Node node = new Node(data, current.getNext());
            current.setNext(node);
        }
        listCount++;
    }
    
    public int get(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }
    
    public int contains(int val) {
        for (int i = 0; i < this.size(); i++) {
            if (val == this.get(i)) {
                return 1;
            }
        }
        return -1;
    }
    
    public boolean remove() {
        if (listCount == 0) {
            return false;
        } else if (listCount == 1) {
            head = head.getNext();
        } else {
            Node current = head;
            Node previous = current;
            while (current.next != null) {
                previous = current;
                current = current.getNext();
            }
            previous.next = current.next;
        }
        listCount--;
        return true;
    }
    
    public boolean remove(int index) {
        if (listCount == 0 && index == 0) {
            return false;
        } else if (index == 0) {
            head = head.getNext();
        } else {
            Node current = head;
            Node previous = current;
            for (int i = 0; i < index; i++) {
                previous = current;
                current = current.getNext();
            }
            previous.next = current.getNext();
        }
        listCount--;
        return true;
    }
    
    public int size() {
        return listCount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Linked list: ");
        if (listCount == 0) {
            sb.append("empty!");
        } else {
            for (int i = 0; i < listCount; i++) {
                if (i < listCount - 1) {
                    sb.append(this.get(i));
                    sb.append(", ");
                } else {
                    try {
                        sb.append(this.get(i));
                    } catch (NullPointerException e) {
                        sb.append("empty!");
                    }
                }
            }
        }
        return sb.toString();
    }
}