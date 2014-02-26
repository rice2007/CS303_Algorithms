package labseven.redblacktree;


import labsix.bst.BinaryTree;

import static labseven.redblacktree.RBNode.nil;

public class RBTree<T extends Comparable<T>> extends BinaryTree<T> {

    public void leftRotate(RBNode<T> x) {
        RBNode<T> y = (RBNode) x.getRight();
        x.setRight(y.getLeft());
        if (y.getLeft() != nil) {
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

    public void rightRotate(RBNode<T> x) {
        RBNode y = (RBNode) x.getLeft();
        x.setLeft(y.getRight());
        if (y.getRight() != nil) {
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

    public void insert(RBNode<T> z) {
        RBNode<T> y = nil;
        RBNode<T> x = (RBNode<T>) this.getRoot();
        while (x != nil) {
            y = x;
            x = (z.getData().compareTo(x.getData()) == -1)
                    ? (RBNode<T>) x.getLeft()
                    : (RBNode<T>) x.getRight();

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

    public void insertFixup(RBNode<T> z) {
        while (!z.getParent().getColor()) {
            if (z.getParent() == z.getParent().getParent().getLeft()) {
                RBNode<T> y = z.getParent().getParent().getRight();
                if (!y.getColor()) {
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
                RBNode<T> y = z.getParent().getParent().getLeft();
                if (!y.getColor()) {
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
                this.leftRotate(z);
            }
        }
        this.setRoot(new RBNode<T>(getRoot().getData(),(RBNode) getRoot().getLeft(), (RBNode) getRoot().getRight()));
    }
}
