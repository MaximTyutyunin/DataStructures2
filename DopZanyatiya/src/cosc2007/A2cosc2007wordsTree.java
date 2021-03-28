package cosc2007;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.Scanner;

/**
 * Maxim Tyutyunin
 * cosc2007
 * <p>
 * Sentinel value: stop (upper / lower case)
 * <p>
 * Purpose:
 * Get words from text from a file and place them in a binary tree
 * <p>
 */
public class A2cosc2007wordsTree {
    public static void main(String[] args) {
        WordTree tree = new WordTree();
        Scanner sc = new Scanner(System.in);
        String userInputFile = "";
        while (!userInputFile.toLowerCase().equals("stop")) {
            userInputFile = sc.nextLine();
            if (userInputFile.toLowerCase().equals("stop")){
                tree.print();
                System.out.println("Number of nodes in the tree: " + tree.countNodes());
                System.out.println("Number of nodes with 4 chars: " + tree.countWordsWith4Chars());
                System.exit(1);
            }
/**i give up here, i cant find a way to read a file using just the name given
 * by user. */
            try {
                /**2 following line get you the file in the same directory*/
                URL path = A2cosc2007wordsTree.class.getResource(userInputFile + ".txt");
                File f = new File(path.getFile());
                /**i will keep 2 following lines here in case they are useful
                 * i assume 2 previous lines of code might not be suitable*/
//                Scanner sf = new Scanner(new BufferedReader(new FileReader("D:\\IJProjects\\DopZanyatiya\\src\\" +
//                        "cosc2007\\" + userInputFile + ".txt")));
                Scanner sf = new Scanner(new BufferedReader(new FileReader(f)));
                while (sf.hasNextLine()) {
                    String[] line = sf.nextLine().trim().split(" ");//trim() cuts all extra spaces,
                    for (int j = 0; j < line.length; j++) {
                        tree.add(line[j]);
                    }

                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }



    }
}
