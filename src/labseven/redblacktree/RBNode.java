package labseven.redblacktree;


import labsix.bst.BinaryTree;
import labsix.bst.BinaryTreeNode;

public class RBNode<T> extends BinaryTreeNode<T>{

    protected static final RBNode nil = new RBNode();
    private RBNode<T> left;
    private RBNode<T> right;
    private RBNode<T> parent;
    private boolean blackFlag;
    private T data;

    public RBNode() {
        this(null, null, null);
        this.blackFlag = true;
    }

    public RBNode(T theData) {
        this(theData, null, null);
        this.blackFlag = true;
    }

    public RBNode(T theData, RBNode<T> leftChild, RBNode<T> rightChild) {
        this.data = theData;
        this.left = leftChild;
        this.right = rightChild;
        this.blackFlag = true;
    }

    public RBNode<T> getLeft() {
        return left;
    }

    public RBNode<T> getRight() {
        return right;
    }

    public RBNode<T> getParent() {
        return parent;
    }

    public boolean getColor() {
        return blackFlag;
    }

    public boolean setBlack() {
        return this.blackFlag = true;
    }

    public boolean setRed() {
        return this.blackFlag = false;
    }

    public boolean swapColor() {
        return (this.blackFlag)
                ? false
                : true;
    }
}
