//package DopZaniatiya;
//
//public class WordTree {
//    private class WordNode {
//        String word;
//        int count = 1; // правильно ли будет приравнять к нулю?
//        cosc2007.WordTree.WordNode left, right;
//
//        WordNode(cosc2007.WordTree.WordNode left, cosc2007.WordTree.WordNode right, String word) {
//            this.left = left;
//            this.right = right;
//            this.word = word;
//        }
//    }
//
//    private cosc2007.WordTree.WordNode root;// give start to the tree, declare field
//
//    /**
//     * • print: display the words of the tree in alphabetical order, and next to each
//     * word, prints the number of times each word occurs in the text.
//     */
//
//    public void add(String word) {
//        //add(word, new WordNode(null, null, word));
//
//
//        root = add(word, root);// или так лучше?
//    }
//
//    private cosc2007.WordTree.WordNode add(String word, cosc2007.WordTree.WordNode node) {//нужно ли этоиу методу возвращать что-то?
//        if (node == null)
//            return new cosc2007.WordTree.WordNode(null, null, word);
//        if (node.word.compareTo(word) == 0) {
//            node.count++;
//        } else if (word.compareTo(node.word) < 0) {
//            node.left = add(word, node.left);
//        } else {
//            node.right = add(word, node.right);
//        }
//        return node;
//    }
//
//    public int countNodes() {
//        return countNodes(root);
//    }
//
//    private int countNodes(cosc2007.WordTree.WordNode node) {
//        if (node == null) return 0;
//        return 1 + countNodes(node.left) + countNodes(node.right);
//    }
//
//    public int countWordsWith4Chars() {
//        return countWordsWith4Chars(root);
//    }
//
//    private int countWordsWith4Chars(cosc2007.WordTree.WordNode node) {
//        if (node == null) return 0;
//        return countWordsWith4Chars(node.left) + countWordsWith4Chars(node.right) + ((node.word.length() == 4) ? 1 : 0);
//    }
//
//    public cosc2007.WordTree.WordNode find(String word) {
//        return find(word, root);
//    }
//
//    private cosc2007.WordTree.WordNode find(String word, cosc2007.WordTree.WordNode node) {
//        if (node == null) return null;
//        if (word.compareTo(node.word) == 0) {
//            return node;
//        } else if (word.compareTo(node.word) < 0) {
//            return find(word, node.left);
//        } else {
//            return find(word, node.right);
//        }
//    }
//
//    public cosc2007.WordTree.WordNode findParent(String word) {
//        return findParent(word, root, null);
//    }
//
//    private cosc2007.WordTree.WordNode findParent(String word, cosc2007.WordTree.WordNode node, cosc2007.WordTree.WordNode parent) {
//        if (node == null) return null;
//        if (word.compareTo(node.word) == 0) {
//            return parent;
//        } else if (word.compareTo(node.word) < 0) {
//            return findParent(word, node.left, node);
//        } else {
//            return findParent(word, node.right, node);
//        }
//    }
//
//    public void delete(String word) {
//        cosc2007.WordTree.WordNode tempParent = findParent(word);
//        cosc2007.WordTree.WordNode toDelete ;
//        if (tempParent == null) return;
//
//        if (tempParent.left != null && tempParent.left.word.compareTo(word) == 0) {
//            toDelete = tempParent.left;
//            if (toDelete.left == null && toDelete.right == null) {
//                tempParent.left = null;
//                return;
//            }
//            if (toDelete.left != null && toDelete.right != null) {
//                String tempS = findAndDeleteMin(toDelete.right);
//                toDelete.word = tempS;
//                return;
//            }
//            if (toDelete.left != null){
//                tempParent.left = toDelete.left;
//                return;
//            }
//            if (toDelete.right != null){
//                tempParent.right = toDelete.right;
//                return;
//            }
//
//        } else {
//            toDelete = tempParent.right;
//            if (toDelete.left == null && toDelete.right == null) {
//                tempParent.right = null;
//                return;
//            }
//            if (toDelete.left != null && toDelete.right != null) {
//                String tempS = findAndDeleteMin(toDelete.right);
//                toDelete.word = tempS;
//                return;
//            }
//            if (toDelete.left != null){
//                tempParent.right = toDelete.left;
//                return;
//            }
//            if (toDelete.right != null){
//                tempParent.right = toDelete.right;
//                return;
//            }
//        }
//
//
//    }
//
//    private String findAndDeleteMin(cosc2007.WordTree.WordNode node) {
//        String temp;
//        //we defenetely know that node is not null and it has left subtree
//        if(node.left.left == null){
//            temp = node.left.word;
//            node.left = null;
//            return temp;
//        }else{
//            return findAndDeleteMin(node.left);
//        }
//
//        return"";
//    }
//
//}
