package labseven.redblacktree;


import labsix.bst.BinaryTree;
import labsix.bst.BinaryTreeNode;

public class RBNode<T> extends BinaryTreeNode<T>{

    protected static final RBNode nil = new RBNode();
    private boolean blackFlag;
    private T data;

    public RBNode() {
        super(null, nil, nil);
        blackFlag = true;
    }

    public RBNode(T theData) {
        super(theData, nil, nil);
        blackFlag = true;
    }

    public RBNode(T theData, RBNode<T> leftChild, RBNode<T> rightChild) {
        super(theData, leftChild, rightChild);
        blackFlag = true;
    }

    public RBNode<T> getLeft() {
        return (RBNode) super.getLeft();
    }

    public RBNode<T> getRight() {
        return (RBNode) super.getRight();
    }

    public RBNode<T> getParent() {
        return (RBNode) super.getParent();
    }

    public T getData() {
        return super.getData();
    }

    public boolean isBlack() {
        return blackFlag;
    }

    public boolean setBlack() {
        return this.blackFlag = true;
    }

    public boolean setRed() {
        return this.blackFlag = false;
    }
}
