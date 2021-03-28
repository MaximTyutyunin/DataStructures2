package cosc2007lab2;


public class BinaryTree {

    // either make an external TreeNode class
    // or a private internal TreeNode class which is also static

    private static class TreeNode {//create class in class to make it visible to the main method coz its "static"
        char item;// looks wrong
        TreeNode left;
        TreeNode right;

        TreeNode(char item, TreeNode left, TreeNode right) {
            this.item = item;
            this.right = right;
            this.left = left;
        }
    }

    public static void main(String[] args) {

        //TEST #1
        StringBuilder expression = new StringBuilder("--6/3+2*481");

        System.out.println("Creating expression tree for " + expression);
        TreeNode root = makeExpressionTree(expression);

        printTree2(root);
        System.out.println();
        System.out.println();
        //TEST #2
        expression = new StringBuilder("--g/s+q*wbd");

        System.out.println("Creating expression tree for " + expression);
        root = makeExpressionTree(expression);

        printTree2(root);
        System.out.println();
        System.out.println();

    }

    public static TreeNode makeExpressionTree(StringBuilder exp) {
        char first = exp.charAt(0);
        exp.deleteCharAt(0);
        if (first == '+' || first == '-' || first == '*' || first == '/') {
            return new TreeNode(first, makeExpressionTree(exp), makeExpressionTree(exp));
        }
        return new TreeNode(first, null, null);
    }

    //converts infix to postfix
//    public static void printTree1(TreeNode r) {
//        if(r.left != null) {
//            System.out.print("( ");
//            printTree1(r.left);
//            printTree1(r.right);
//        }
//
//        System.out.print(r.item);
//
//        if(r.right != null) {
//            System.out.print(" )");
//        }
//
//    }
    //prefix to infix
    public static void printTree2(TreeNode r) {
        if (r.left != null) {
            System.out.print("(");
            printTree2(r.left);
            System.out.print(" " + r.item + " ");//prints operators
        }
        if (r.left == null && r.right == null) {
            System.out.print(r.item);//prints operands
        }

        if (r.right != null) {
            printTree2(r.right);
            System.out.print(")");
        }

    }

}

