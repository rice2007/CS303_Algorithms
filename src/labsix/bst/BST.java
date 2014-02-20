package labsix.bst;


public class BST<T extends Comparable<T>> extends BinaryTree<T> {

    public void insert(BinaryTreeNode<T> z) {
        BinaryTreeNode<T> y = null;
        BinaryTreeNode<T> x = this.getRoot();
        while (x != null) {
            y = x;
            x = (z.getData().compareTo(x.getData()) == -1)
                    ? x.getLeft()
                    : x.getRight();
        }
        z.setParent(y);
        if (y == null) {
            this.setRoot(z);
        } else if (z.getData().compareTo(y.getData()) == -1) {
            y.setLeft(z);
        } else {
            y.setRight(z);
        }
    }

    public void walk(BinaryTreeNode<T> x) {
        if (x != null) {
            walk(x.getLeft());
            System.out.println();
            walk(x.getRight());
        }
    }
}
