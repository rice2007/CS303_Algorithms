package labfive.linkedlist;

public class LinkedListDriver {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        System.out.println(list.size()); //check size
        System.out.println(list.isEmpty()); //empty
        list.add(10); //add 10 index 0
        System.out.println(list.contains(0)); //check for non-existent data
        System.out.println(list.toString());
        System.out.println(list.remove()); //remove 10
        System.out.println(list.isEmpty()); //empty with null head
        System.out.println(list.toString());
        list.add(30);//add 30 index 0
        list.add(40);//add 40 index 1
        System.out.println(list.toString());
        list.add(0, 0);//insert 0 index 0
        list.add(10, 1);//insert 10 index 1
        list.add(20, 2);//insert 20 index 2
        System.out.println(list.contains(20)); //check for existing data
        System.out.println(list.toString());
        System.out.println(list.remove(0));//remove 0
        System.out.println(list.remove(2));//remove 30
        System.out.println(list.toString());
        System.out.println(list.size()); //check size
        System.out.println(list.isEmpty()); //empty check
    }

}
