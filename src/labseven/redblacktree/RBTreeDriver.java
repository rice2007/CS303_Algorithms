package labseven.redblacktree;


import labsix.bst.BST;
import labsix.bst.BinaryTreeNode;

public class RBTreeDriver {

    public static void main(String[] args) {
        RBTree<Integer> tree = new RBTree<>();
        System.out.println(tree.toString());

        RBNode<Integer> node = new RBNode<>(16);
        RBNode<Integer> fakeNode = new RBNode<>(1);
        tree.insert(node);
        tree.insert(new RBNode<Integer>(10));
        tree.insert(new RBNode<Integer>(20));
        tree.insert(new RBNode<Integer>(7));
        tree.insert(new RBNode<Integer>(13));
        tree.insert(new RBNode<Integer>(18));
        tree.insert(new RBNode<Integer>(21));
        tree.insert(new RBNode<Integer>(14));
        tree.insert(new RBNode<Integer>(5));
        tree.insert(new RBNode<Integer>(3));
        tree.insert(new RBNode<Integer>(9));

        System.out.println(tree.toString());
    }
}
