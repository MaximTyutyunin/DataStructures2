package DopZaniatiya;

public class TreeNode<T> {
    private T element;
    private TreeNode<T> left;// explycitely show that left, right have same type with the main node
    private TreeNode<T> right;

    TreeNode(T element) {
        this.element = element;
    }

    TreeNode(T element,  TreeNode<T> left,  TreeNode<T> right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public void setLeft( TreeNode<T> left) {
        this.left = left;
    }

    public void setRight( TreeNode<T> right) {
        this.right = right;
    }

    public T getElement() {
        return element;
    }

    public  TreeNode<T> getLeft() {
        return left;
    }

    public  TreeNode<T> getRight() {
        return right;
    }

    public int countNodes() {
        if (this.left == null && this.right == null) return 1;
        return 1 + (this.left == null ? 0 : this.left.countNodes())
                + (this.right == null ? 0 : this.right.countNodes());
    }

    public int checkHeight() {
        System.out.println("node value " + this.element);
        if (this.left == null && this.right == null) return 1;
        int height =  1 + Math.max(
                (this.left == null ? 0 : this.left.checkHeight()),
                (this.right == null ? 0 : this.right.checkHeight())
        );
        System.out.println("height " + height);
        return height;
    }
//
//    public int name() {
//        TreeNode<Integer> t1 = new TreeNode<Integer>(1);
//        TreeNode<Integer> t2 = new TreeNode<Integer>(2);
//
//        t1.setLeft(t2);
//    }

}
