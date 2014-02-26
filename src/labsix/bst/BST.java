package labsix.bst;


public class BST<T extends Comparable<T>> extends BinaryTree<T> {

    private static boolean searchFlag;

    public void insert(BinaryTreeNode<T> value) {
        BinaryTreeNode<T> currentParent = null;
        BinaryTreeNode<T> currentNode = this.getRoot();
        while (currentNode != null) {
            currentParent = currentNode;
            currentNode = (value.getData().compareTo(currentNode.getData()) == -1)
                    ? currentNode.getLeft()
                    : currentNode.getRight();
        }
        value.setParent(currentParent);
        if (currentParent == null) {
            this.setRoot(value);
        } else if (value.getData().compareTo(currentParent.getData()) == -1) {
            currentParent.setLeft(value);
        } else {
            currentParent.setRight(value);
        }
    }

    public boolean search(BinaryTreeNode<T> currentNode, BinaryTreeNode<T> key) {
        if (currentNode == null) {
            return false;
        } else if (key.getData().compareTo(currentNode.getData()) == 0) {
            return true;
        }
        return (key.getData().compareTo(currentNode.getData()) == -1)
                ? search(currentNode.getLeft(), key)
                : search(currentNode.getRight(), key);
    }

    public void walk(BinaryTreeNode<T> node) {
        if (node != null) {
            System.out.println("Walking the tree:");
            walkSuccess(node);
            System.out.println();
        } else {
            System.out.println("Tree is empty\n");
        }
    }

    public boolean delete(BinaryTreeNode<T> z) {
        return (search(this.getRoot(), z)) && deleteSuccess(z);
    }

    private void walkSuccess(BinaryTreeNode<T> node) {
        if (node != null) {
            walkSuccess(node.getLeft());
            System.out.println(node.getData());
            walkSuccess(node.getRight());
        }
    }

    private boolean deleteSuccess(BinaryTreeNode<T> z) {
        if (z.getLeft() == null) {
            this.transplant(z, z.getRight());
        } else if (z.getRight() == null) {
            this.transplant(z, z.getLeft());
        } else {
            BinaryTreeNode<T> y = minimum(z.getRight());
            if (y.getParent() != z) {
                this.transplant(y, y.getRight());
                y.setRight(z.getRight());
                y.getRight().setParent(y);
            }
            this.transplant(z, y);
            y.setLeft(z.getLeft());
            y.getLeft().setParent(y);
        }
        return true;
    }

    private void transplant(BinaryTreeNode<T> u, BinaryTreeNode v) {
        if (u.getParent() == null) {
            this.setRoot(v);
        } else if (u == u.getParent().getLeft()) {
            u.getParent().setLeft(v);
        } else {
            u.getParent().setRight(v);
        }
        if (v != null) {
            v.setParent(u.getParent());
        }
    }

    private BinaryTreeNode<T> minimum(BinaryTreeNode<T> min) {
        while (min.getLeft() != null) {
            min = min.getLeft();
        }
        return min;
    }
}
