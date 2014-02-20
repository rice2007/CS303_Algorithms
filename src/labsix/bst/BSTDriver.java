package labsix.bst;

public class BSTDriver {

    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(16);
        tree.insert(node);
        tree.insert(new BinaryTreeNode<Integer>(10));
        tree.insert(new BinaryTreeNode<Integer>(20));
        tree.insert(new BinaryTreeNode<Integer>(7));
        tree.insert(new BinaryTreeNode<Integer>(13));
        tree.insert(new BinaryTreeNode<Integer>(18));
        tree.insert(new BinaryTreeNode<Integer>(21));
        tree.insert(new BinaryTreeNode<Integer>(3));
        System.out.println(tree.toString());
        tree.walk(node);
        System.out.println();
        System.out.println(tree.search(tree.getRoot(), node).getData());
    }
}
