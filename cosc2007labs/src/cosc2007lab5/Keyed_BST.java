package cosc2007lab5;


public class Keyed_BST {

	private static class Node {
		// COMPLETE THE CODE FOR THE NODE - its just like every other treenode you made
		// except this one always holds a person object (not generic)

		// add a getKey() that returns a comparable object

		// optional: create a static method called makeKey() that accepts a Person
		// object and returns the key
		Person item;
		Node left;
		Node right;

		Node(Person item, Node left, Node right) {
			this.item = item;
			this.right = right;
			this.left = left;
		}

		private static Comparable makeKey(Person p) {
			return p.getLastName() + p.getFirstName() + p.getYear();

		}

		public Comparable getKey() {
			return makeKey(item);
		}
	}

	private Node root;

	public boolean isEmpty() {
		if (root == null)
			return true;
		return false;
	}

	public void insert(Person item) {
		// public calls the private
		if (root == null) {
			root = new Node(item, null, null);// is correct?
		}
		root = insert(item, root);
	}

	private Node insert(Person item, Node r) {
		if (r == null)
			return new Node(item, null, null);

		if (Node.makeKey(item).compareTo(r.getKey()) < 0 ) {// why it compare should be parameterized
			r.left = insert(item, r.left);
		} else {
			r.right = insert(item, r.right);// go right
		}

		return r;
	}

	public int countNodes() {
		// public calls the private
		return countNodes(root);
	}

	private int countNodes(Node r) {
		
		if (r == null)
			return 0;
		return 1 + countNodes(r.left) + countNodes(r.right);

	}

	public int heightTree() {
		// public calls the private
		return heightTree(root);
	}
	
	private int heightTree(Node r) {
		if(r == null) return 0;
		return 1 + Math.max(heightTree(r.left), heightTree(r.right));
	}

	public void printTree() {
		// call the private
		printTree(root);
	}

	private void printTree(Node r) {
		// print an asterisk before the root using (r==root?"* ":"") + ...

		if (r == null)
			return;
		printTree(r.left);
		System.out.println((r == root ? "* " : "") + r.item);
		printTree(r.right);

	}

	public void deleteAll() {
		// this is a one liner
		root = null;
	}

}
