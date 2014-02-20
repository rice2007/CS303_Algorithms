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

    public BinaryTreeNode<T> search(BinaryTreeNode<T> x, BinaryTreeNode<T> k) {
        if ( (x == null) || (k.getData().compareTo(x.getData()) == 0) ) {
            return x;
        }
        return (k.getData().compareTo(x.getData()) == -1)
                ? search(x.getLeft(), k)
                : search(x.getRight(), k);
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
		if (root != null) {
			return root.toStringPreOrder(".");
		} else {
			return "";
		}
	}
}
