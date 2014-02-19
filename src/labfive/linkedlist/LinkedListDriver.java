package labfive.linkedlist;

public class LinkedListDriver {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(10);//add 10 index 0
        System.out.println(list.contains(0));
        System.out.println(list.remove());
        System.out.println(list.toString());
        list.add(30);//add 30 index 1
        list.add(40);//add 40 index 2
        System.out.println(list.toString());
        list.add(0, 0);//insert 0 index 0
        list.add(10, 1);//insert 0 index 0
        System.out.println(list.toString());
        System.out.println(list.contains(20));
        list.add(20, 2);//insert 20 index 2
        System.out.println(list.contains(20));
        System.out.println(list.toString());
        System.out.println(list.remove(0));//remove 0
        System.out.println(list.toString());
    }
}
