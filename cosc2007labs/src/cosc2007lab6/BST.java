package cosc2007lab6;

public class BST<T extends Comparable<T>> {
	private class Node<T extends Comparable<T>> {
		T item;
		Node<T> left;
		Node<T> right;
		private int index;// can make it global -> no need for index for treeSort anymore

		Node(T item, Node<T> left, Node<T> right) {
			this.item = item;
			this.right = right;
			this.left = left;
		}
	}

	private Node<T> root;

	public int countNodes() {
		return countNodes(root);
	}

	private int countNodes(Node<T> r) {
		if (r.left == null && r.right == null)
			return 0;
		return 1 + countNodes(r.left) + countNodes(r.right);
	}

	public void insert(T item) {
		this.root = insert(item, root);

	}

	private Node insert(T item, Node r) {
		if (r == null)
			return new Node(item, null, null);

		if (item.compareTo((T) r.item) == -1) {
			r.left = insert(item, r.left);
		} else {
			r.right = insert(item, r.right);
		}

		return r;
	}

	public Object[] treeSort() {
		Object[] sortArr =  new Object[countNodes(root)];// <T> is object at the beginning
			//this is the safest way for generic arrays then user has to convert it to <T>													// or use array list, in this case just pass index
		int index = 0;
		treeSort(sortArr, root, index);
		return sortArr;

	}



	private int treeSort(Object[] sortArr, Node r, int index) {
		if (r == null)
			return index;
		//treeSort(sortArr, r.left, index + 1);// this will not work, coz parameter is temp
		index = treeSort(sortArr, r.left, index);
		sortArr[index] = r.item;
		index++;
		index = treeSort(sortArr, r.right, index);
		return index;
	}

}
