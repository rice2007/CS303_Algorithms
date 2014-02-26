package labsix.bst;

public class BSTDriver {

    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        System.out.println(tree.toString());

        BinaryTreeNode<Integer> node = new BinaryTreeNode<>(16);
        BinaryTreeNode<Integer> fakeNode = new BinaryTreeNode<>(1);
        tree.insert(node);
        tree.insert(new BinaryTreeNode<Integer>(10));
        tree.insert(new BinaryTreeNode<Integer>(20));
        tree.insert(new BinaryTreeNode<Integer>(7));
        tree.insert(new BinaryTreeNode<Integer>(13));
        tree.insert(new BinaryTreeNode<Integer>(18));
        tree.insert(new BinaryTreeNode<Integer>(21));
        tree.insert(new BinaryTreeNode<Integer>(14));
        tree.insert(new BinaryTreeNode<Integer>(5));
        tree.insert(new BinaryTreeNode<Integer>(3));
        tree.insert(new BinaryTreeNode<Integer>(9));

        System.out.println(tree.toString());
        tree.walk(tree.getRoot());
        System.out.println(tree.search(tree.getRoot(), node));
        System.out.println(tree.search(tree.getRoot(), fakeNode));
        System.out.println(tree.delete(node));
        System.out.println(tree.toString());
        tree.walk(tree.getRoot());
        System.out.println(tree.delete(fakeNode));
        System.out.println(tree.toString());
        tree.walk(tree.getRoot());
    }
}
