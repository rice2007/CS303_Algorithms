package labseven.redblacktree;


import labsix.bst.BinaryTree;
import labsix.bst.BinaryTreeNode;

import static labseven.redblacktree.RBNode.nil;

public class RBTree<T extends Comparable<T>> extends BinaryTree<T> {

    private RBNode<T> root;

    public RBTree() {
        RBTree.this.setRoot(null);
    }

    public RBNode<T> getRoot(){
        return (RBNode<T>) super.getRoot();
    }

    public void leftRotate(RBNode<T> x) {
        RBNode<T> y = (RBNode<T>) x.getRight();
        x.setRight(y.getLeft());
        if (y.getLeft() != null) {
            y.getLeft().setParent(x);
        }
        y.setParent(x.getParent());
        if (x.getParent() == null) {
            this.setRoot(y);
        } else if (x == x.getParent().getLeft()) {
            x.getParent().setLeft(y);
        } else {
            x.getParent().setRight(y);
        }
        y.setLeft(x);
        x.setParent(y);
    }

    public void rightRotate(RBNode<T> x) {
        RBNode y = (RBNode<T>) x.getLeft();
        x.setLeft(y.getRight());
        if (y.getRight() != null) {
            y.getRight().setParent(x);
        }
        y.setParent(x.getParent());
        if (x.getParent() == null) {
            this.setRoot(y);
        } else if (x == x.getParent().getRight()) {
            x.getParent().setRight(y);
        } else {
            x.getParent().setLeft(y);
        }
        y.setRight(x);
        x.setParent(y);
    }

    public void insert(RBNode<T> z) {
        RBNode<T> y = null;
        RBNode<T> x = (RBNode<T>) this.getRoot();
        while (x != null) {
            y = x;
            x = (z.getData().compareTo(x.getData()) == -1)
                    ? (RBNode<T>) x.getLeft()
                    : (RBNode<T>) x.getRight();
        }
        z.setParent(y);
        if (y == null) {
            this.setRoot(z);
        } else if (z.getData().compareTo(y.getData()) == -1) {
            y.setLeft(z);
        } else {
            y.setRight(z);
        }
        z.setLeft(null);
        z.setRight(null);
        z.setRed();
        if (z == this.getRoot()){
            return;
        }
        this.insertFixup(z);
    }

    public void insertFixup(RBNode<T> z) {
        while (!z.getParent().isBlack()) {
            if (z.getParent() == z.getParent().getParent().getLeft()) {
                RBNode<T> y = z.getParent().getParent().getRight();
                if (!y.isBlack()) {
                    z.getParent().setBlack();
                    y.setBlack();
                    z.getParent().getParent().setRed();
                    z = z.getParent().getParent();
                } else if (z == z.getParent().getRight()) {
                    z = z.getParent();
                    this.leftRotate(z);
                }
                z.getParent().setBlack();
                z.getParent().getParent().setRed();
                this.rightRotate(z);
            } else if (z.getParent().getParent() != null) {
                RBNode y = z.getParent().getParent().getLeft();
                if (y != null && !y.isBlack()) {
                    z.getParent().setBlack();
                    y.setBlack();
                    z.getParent().getParent().setRed();
                    z = z.getParent().getParent();
                } else if (z == z.getParent().getLeft()) {
                    z = z.getParent();
                    this.rightRotate(z);
                }
                if (z.getParent() != null) {
                    z.getParent().setBlack();
                }
                if (z.getParent().getParent() != null) {
                    z.getParent().getParent().setRed();
                }
                this.leftRotate(z);
            }
        }
        this.getRoot().setBlack();
    }
}
