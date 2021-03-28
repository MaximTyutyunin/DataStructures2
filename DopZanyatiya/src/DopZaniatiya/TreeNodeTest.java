package DopZaniatiya;


public class TreeNodeTest {
    public static void main(String[] args) {
//
//        System.out.println(createSmallTree());
//        System.out.println(createTreeOfTwoLeft());
//        System.out.println(createTreeOfTwoRight());
//        System.out.println(createTreeOfThreeLeftRight());
//        System.out.println(createTreeOfFour());
//
//        System.out.println(createTreeOfFive());
//        System.out.println( createTreeOfThreeAllLeft());
//        System.out.println(createTreeOfFourZigzag());
//        System.out.println(createTreeOfFourZigzag());
//        System.out.println(createTreeOfManyRandom());
/**--------------------------------------------------------------*/
       /** height*/
        System.out.println(createSmallTreeh());
        System.out.println(createTreeOfTwoLefth());
        System.out.println(createTreeOfTwoRighth());
        System.out.println(createTreeOfThreeLeftRighth());
        System.out.println(createTreeOfFourh());

        System.out.println(createTreeOfFiveh());
        System.out.println(createTreeOfThreeAllLefth());//
        System.out.println(createTreeOfFourZigzagh());
        System.out.println(createTreeOfFourZigzagh());
        System.out.println(createTreeOfManyRandomh());
    }

    public static boolean createSmallTree() {
        TreeNode<Integer> tree = new TreeNode<Integer>(1);
        if (tree.countNodes () != 1) return false;
        return true;
    }

    public static boolean createTreeOfTwoLeft() {
        TreeNode<Integer> tree = new TreeNode<Integer>(1, new TreeNode<Integer>(2), null);
        if (tree.countNodes () != 2) return false;
        return true;
    }

    public static boolean createTreeOfTwoRight() {
        TreeNode<Integer> tree = new TreeNode<Integer>(1, null, new TreeNode<Integer>(3));
        if (tree.countNodes () != 2) return false;
        return true;
    }

    public static boolean createTreeOfThreeLeftRight() {
        TreeNode<Integer> tree = new TreeNode<Integer>(1,
                new TreeNode<Integer>(2), new TreeNode<Integer>(3));
        if (tree.countNodes () != 3) return false;
        return true;
    }

    public static boolean createTreeOfFour() {
        TreeNode<Integer> tree = new TreeNode<Integer>(1,
                new TreeNode<Integer>(2),
                new TreeNode<Integer>(3,
                        new TreeNode<Integer>(4),
                        null));
        if (tree.countNodes () != 4) return false;
        return true;
    }

    public static boolean createTreeOfFive() {
        TreeNode<Integer> tree = new TreeNode<Integer>(1,
                new TreeNode<Integer>(2),
                new TreeNode<Integer>(3,
                        new TreeNode<Integer>(4),
                        new TreeNode<Integer>(5))
        );
        if (tree.countNodes () != 5) return false;
        return true;
    }

    public static boolean createTreeOfThreeAllLeft() {
        TreeNode<Integer> tree = new TreeNode<Integer>(1,
                new TreeNode<Integer>(2,
                        new TreeNode<Integer>(3, new TreeNode<Integer>(4), null),
                        null),
                null);
        if (tree.countNodes () != 4) return false;
        return true;
    }

    public static boolean createTreeOfFourZigzag() {
        TreeNode<Integer> tree = new TreeNode<Integer>(1,
                new TreeNode<Integer>(2,
                        null,
                        new TreeNode<Integer>(3, new TreeNode<Integer>(4), null)),
                null);
        if (tree.countNodes () != 4) return false;
        return true;
    }

    public static boolean createTreeOfManyRandom() {
        TreeNode<Integer> tree2 = new TreeNode<Integer>(6,
                new TreeNode<Integer>(7),
                new TreeNode<Integer>(8));

        TreeNode<Integer> tree1 = new TreeNode<Integer>(1,
                new TreeNode<Integer>(2),
                new TreeNode<Integer>(3,
                        new TreeNode<Integer>(4),
                        new TreeNode<Integer>(5, tree2, null))
        );
        if (tree1.countNodes() != 8) return false;
        return true;
    }

    public static boolean createSmallTreeh() {
        TreeNode<Integer> tree = new TreeNode<Integer>(1);
        if (tree.checkHeight () != 1) return false;
        return true;
    }

    public static boolean createTreeOfTwoLefth() {
        TreeNode<Integer> tree = new TreeNode<Integer>(1, new TreeNode<Integer>(2), null);
        if (tree.checkHeight () != 2) return false;
        return true;
    }

    public static boolean createTreeOfTwoRighth() {
        TreeNode<Integer> tree = new TreeNode<Integer>(1, null, new TreeNode<Integer>(3));
        if (tree.checkHeight () != 2) return false;
        return true;
    }

    public static boolean createTreeOfThreeLeftRighth() {
        TreeNode<Integer> tree = new TreeNode<Integer>(1,
                new TreeNode<Integer>(2), new TreeNode<Integer>(3));
        if (tree.checkHeight () != 2) return false;
        return true;
    }

    public static boolean createTreeOfFourh() {
        TreeNode<Integer> tree = new TreeNode<Integer>(1,
                new TreeNode<Integer>(2),
                new TreeNode<Integer>(3,
                        new TreeNode<Integer>(4),
                        null));
        if (tree.checkHeight () != 3) return false;
        return true;
    }

    public static boolean createTreeOfFiveh() {
        TreeNode<Integer> tree = new TreeNode<Integer>(1,
                new TreeNode<Integer>(2),
                new TreeNode<Integer>(3,
                        new TreeNode<Integer>(4),
                        new TreeNode<Integer>(5))
        );
        if (tree.checkHeight () != 3) return false;
        return true;
    }

    public static boolean createTreeOfThreeAllLefth() {
        TreeNode<Integer> tree = new TreeNode<Integer>(1,
                new TreeNode<Integer>(2,
                        new TreeNode<Integer>(3,
                                new TreeNode<Integer>(4), null),
                        null),
                null);
        if (tree.checkHeight () != 4) return false;
        return true;
    }

    public static boolean createTreeOfFourZigzagh() {
        TreeNode<Integer> tree = new TreeNode<Integer>(1,
                new TreeNode<Integer>(2,
                        null,
                        new TreeNode<Integer>(3, new TreeNode<Integer>(4), null)),
                null);
        if (tree.checkHeight () != 4) return false;
        return true;
    }

    public static boolean createTreeOfManyRandomh() {
        TreeNode<Integer> tree2 = new TreeNode<Integer>(6,
                new TreeNode<Integer>(7),
                new TreeNode<Integer>(8));

        TreeNode<Integer> tree1 = new TreeNode<Integer>(1,
                new TreeNode<Integer>(2),
                new TreeNode<Integer>(3,
                        new TreeNode<Integer>(4),
                        new TreeNode<Integer>(5, tree2, null))
        );
        if (tree1.checkHeight() != 5) return false;
        return true;
    }

}
