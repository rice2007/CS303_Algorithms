package labseven.redblacktree;


import labsix.bst.BinaryTreeNode;

public class RBNode<T> extends BinaryTreeNode<T>{

    public static RBNode nil = new RBNode();
    private boolean blackFlag;
    private RBNode<T> left;
    private RBNode<T> right;
    private RBNode<T> parent;
    private String unit;
    private String value;
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

    public RBNode(T theData, String theUnit, String theValue, RBNode<T> leftChild, RBNode<T> rightChild) {
        super(theData, nil, nil);
        blackFlag = true;
        this.unit = theUnit;
        this.value = theValue;
    }

    public RBNode<T> getLeft() {
        if (super.getLeft() == null) {
            return nil;
        } else {
        return (RBNode<T>) super.getLeft();
        }
    }

    public RBNode<T> getRight() {
        return (RBNode<T>) super.getRight();
    }

    public RBNode<T> getParent() {
        return (RBNode<T>) super.getParent();
    }

    public RBNode<T> getGrandparent() {
        return this.getParent().getParent();
    }

    public T getData() {
        return super.getData();
    }

    public String getValue() {
        return this.value;
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

    @Override
    public String toStringPreOrder(String pathString) {
        if (getData() instanceof Long) {
            return toStringPreOrderCSV(".");
        }
        String treeString = pathString + " : " + getData() + " - " + toStringColor() + "\n";

        if (getLeft() != null && getLeft() != nil) {
            treeString += getLeft().toStringPreOrder(pathString + "L");
        }

        if (getRight()!= null && getRight() != nil) {
            treeString += getRight().toStringPreOrder(pathString + "R");
        }

        return treeString;
    }

    private String toStringColor() {
        if (blackFlag) {
            return ("black");
        } else {
            return ("red");
        }
    }

    private String toStringPreOrderCSV(String pathString) {
        String treeString = pathString + " : " + getData() + " - " + getValue() + " - " + toStringColor() + "\n";

        if (getLeft() != null && getLeft() != nil) {
            treeString += getLeft().toStringPreOrderCSV(pathString + "L");
        }

        if (getRight()!= null && getRight() != nil) {
            treeString += getRight().toStringPreOrderCSV(pathString + "R");
        }

        return treeString;
    }
}
