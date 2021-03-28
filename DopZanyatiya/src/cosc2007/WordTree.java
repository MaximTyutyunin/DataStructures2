package cosc2007;

import java.util.regex.Pattern;
/**
 * Maxim Tyutyunin
 * cosc2007
 * <p>
 * Purpose:
 * Get words from text from a file and place them in a binary tree
 * <p>
 */
public class WordTree {
    private class WordNode {
        String word;
        int count = 1;
        WordNode left, right;

        WordNode(WordNode left, WordNode right, String word) {
            this.left = left;
            this.right = right;
            this.word = word;
        }
    }

    private WordNode root;// give start to the tree, declare field

    public void add(String word) {
        /**useing regex to get rid of all unnecessary characters */
        Pattern pattern = Pattern.compile("['.+/*-<>=)(\"?\\]\\[ ]");
        String lettersOnly = pattern.matcher(word).replaceAll("");

        root = add(lettersOnly, root);
    }

    private WordNode add(String word, WordNode node) {
        if (node == null)
            return new WordNode(null, null, word);
        if (node.word.toLowerCase().compareTo(word.toLowerCase()) == 0) {
            node.count++;
        } else if (word.compareTo(node.word) < 0) {
            node.left = add(word, node.left);
        } else {
            node.right = add(word, node.right);
        }
        return node;
    }
/**i decided to keep it just in case ill need it later, but its not used*/
    //    public final boolean isDigit(String s) {
//        boolean isDigit = false;
//
//        if (s != null && !s.isEmpty()) {
//            for (char c : s.toCharArray()) {
//                if (isDigit = Character.isDigit(c)) {
//                    break;
//                }
//            }
//        }
//
//        return isDigit;
//    }
    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(WordNode node) {/**pre-order*/
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    public int countWordsWith4Chars() {
        return countWordsWith4Chars(root);
    }

    private int countWordsWith4Chars(WordNode node) {/**post-order*/
        if (node == null) return 0;
        return countWordsWith4Chars(node.left) + countWordsWith4Chars(node.right) + ((node.word.length() == 4) ? 1 : 0);
    }

    public void print() {
        print(root);
    }

    private void print(WordNode node) {/**in-order*/
        if (node.left != null) {
            print(node.left);
        }
        System.out.printf("%20s %3s %n", node.word + " #: ", node.count);

        if (node.right != null) {
            print(node.right);
        }

    }

    public WordNode find(String word) {
        return find(word, root);
    }

    private WordNode find(String word, WordNode node) {
        if (node == null) return null;
        if (word.compareTo(node.word) == 0) {
            return node;
        } else if (word.compareTo(node.word) < 0) {
            return find(word, node.left);
        } else {
            return find(word, node.right);
        }
    }


}
