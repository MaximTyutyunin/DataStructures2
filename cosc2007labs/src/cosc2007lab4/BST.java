package cosc2007lab4;

public class BST<T extends Comparable<T>> {

	private class Node<T extends Comparable<T>> {
		// COMPLETE THE CODE FOR THE NODE - its just like every other treenode you made
		T item;
		Node left;
		Node right;

		Node(T item, Node left, Node right) {
			this.item = item;
			this.right = right;
			this.left = left;
		}

	}

	private Node<T> root;

	public void insert(T item) {
		// public calls the private
		this.root = insert(item, root);

	}

	private Node insert(T item, Node r) { // why its not void?
		// code insert here
		if (r == null) return new Node( item, null,  null) ;
			
		if (item.compareTo((T) r.item) == -1) {
			r.left = insert(item, r.left);
		}else {
			r.right = insert(item, r.right);
		}
		
		return r;
	}

	public void delete(T item) {
		// public calls the private
		delete(item, root);
	}

	private Node delete(T item, Node r) {
		// code delete here
		// remember that if the item is not in tree, throw an exception
	}

	public int countNodes() {
		// public calls the private
		return countNodes(root);
	}

	private int countNodes(Node r) {
		if (r.left == null && r.right == null)
			return 0;
		return 1 + countNodes(r.left) + countNodes(r.right);
	}

	public int heightTree() {
		// public calls the private
		return heightTree(root);
	}

	private int heightTree(Node r) {
		if (root.left == null && root.right == null)
			return 0;
		return 1 + Math.max(heightTree(r.left), heightTree(r.right));
	}

	public void printTree() {
		// call the private
		// keep this line to show the root
		System.out.println(", root is " + (root == null ? "empty" : root.item));
	}

	public void deleteAll() {
		// this is a one liner
	}

}
