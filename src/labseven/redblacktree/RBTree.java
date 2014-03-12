package labseven.redblacktree;


import labsix.bst.BinaryTree;

import static labseven.redblacktree.RBNode.nil;

public class RBTree<T extends Comparable<T>> extends BinaryTree<T> {

    private RBNode<T> root;

    public RBTree() {
        RBNode.nil.setBlack();
        this.setRoot(nil);
        getRoot().setParent(RBNode.nil);

    }

    public RBNode<T> getRoot(){
        return (RBNode<T>) super.getRoot();
    }

    public void insert(RBNode<T> z) {
        RBNode<T> y = nil;
        RBNode<T> x = this.getRoot();
        while (x != nil) {
            y = x;
            x = (z.getData().compareTo(x.getData()) == -1)
                    ? x.getLeft()
                    : x.getRight();
        }
        z.setParent(y);
        if (y == nil) {
            this.setRoot(z);
        } else if (z.getData().compareTo(y.getData()) == -1) {
            y.setLeft(z);
        } else {
            y.setRight(z);
        }
        z.setLeft(nil);
        z.setRight(nil);
        z.setRed();
        this.insertFixup(z);
    }

    public boolean search(RBNode<T> key) {
        if (this.getRoot() == null) {
            return false;
        } else {
            return searchHelper(this.getRoot(), key);
        }
    }

    public boolean search(T key) {
        if (this.getRoot() == null) {
            return false;
        } else {
            RBNode<T> keyNode = new RBNode<>(key);
            return searchHelper(this.getRoot(), keyNode);
        }
    }

    @Override
    public String toString() {
        if (getRoot() != null) {
            System.out.println("Printing tree:");
            return getRoot().toStringPreOrder(".");
        } else {
            return "Tree is empty.\n";
        }
    }
    private void insertFixup(RBNode<T> z) {
        while (!z.getParent().isBlack()) {
            if (z.getParent() == z.getParent().getParent().getLeft()) {
                RBNode<T> y = z.getParent().getParent().getRight();
                if (y != null && !y.isBlack()) {
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
            } else {
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
                z.getParent().setBlack();
                z.getParent().getParent().setRed();
                this.leftRotate(z.getParent().getParent());
            }
        }
        this.getRoot().setBlack();
    }

    private boolean searchHelper(RBNode<T> currentNode, RBNode<T> key) {
        if (currentNode == null || currentNode == nil) {
            return false;
        } else if (key.getData().compareTo(currentNode.getData()) == 0) {
            System.out.println(currentNode.getValue());
            return true;
        }
        return (key.getData().compareTo(currentNode.getData()) == -1)
                ? searchHelper(currentNode.getLeft(), key)
                : searchHelper(currentNode.getRight(), key);
    }

    private void leftRotate(RBNode<T> x) {
        RBNode<T> y = x.getRight();
        if (y != null) {
            x.setRight(y.getLeft());
            if (y.getLeft() != nil && y.getLeft() != null) {
                y.getLeft().setParent(x);
            }
            y.setParent(x.getParent());
            if (x.getParent() == nil) {
                this.setRoot(y);
            } else if (x == x.getParent().getLeft()) {
                x.getParent().setLeft(y);
            } else {
                x.getParent().setRight(y);
            }
            y.setLeft(x);
            x.setParent(y);
        }
    }

    private void rightRotate(RBNode<T> x) {
        RBNode<T> y = x.getLeft();
        x.setLeft(y.getRight());
        if (y.getRight() != nil && y.getRight() != null) {
            y.getRight().setParent(x);
        }
        y.setParent(x.getParent());
        if (x.getParent() == nil) {
            this.setRoot(y);
        } else if (x == x.getParent().getRight()) {
            x.getParent().setRight(y);
        } else {
            x.getParent().setLeft(y);
        }
        y.setRight(x);
        x.setParent(y);
    }
}
