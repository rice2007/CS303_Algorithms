package labsix.bst;

public class BinaryTree<T extends Comparable<T>> {

    private BinaryTreeNode<T> root; // the root of the tree
	private BinaryTreeNode<T> cursor; // the current node

	public void toRoot() {
		cursor = root;
	}

	public boolean hasLeftChild() {
		return cursor.getLeft() != null;
	}

	public boolean hasRightChild() {
		return cursor.getRight() != null;
	}

	public void toLeftChild() {
		cursor = cursor.getLeft();
	}

	public void toRightChild() {
		cursor = cursor.getRight();
	}

	public T get() {
		return cursor.getData();
	}

    public BinaryTreeNode<T> getRoot(){
        return root;
    }

	public void set(T data) {
		cursor.setData(data);
	}

    public void setRoot(BinaryTreeNode<T> data) {
        this.root = data;
    }

	public int height() {
		if (root != null) {
			return root.height();
		} else {
			return 0;
		}
	}

	public String toString() {
        if (this.root != null) {
            System.out.println("Printing tree:");
			return this.root.toStringPreOrder(".");
		} else {
			return "Tree is empty.\n";
		}
	}
}
