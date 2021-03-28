package cosc2007lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test_BST {

	public static void main(String[] args) {
		
		BST<Integer> tree = new BST<>();
		char nextOp;
		int nextVal;
		
		try(Scanner fileIn = new Scanner(new File("BST_Instructions.txt"))) {

			while(fileIn.hasNext()) {
				nextOp = fileIn.next().toUpperCase().charAt(0);
				switch(nextOp) {
				case 'A':
					nextVal = fileIn.nextInt();
					System.out.println("Adding: " + nextVal);
					tree.insert(nextVal);
					break;
				case 'D':
					nextVal = fileIn.nextInt();
					System.out.println("Deleting: " + nextVal);
					try {
						tree.delete(nextVal);
					}
					catch(BSTException bst) {
						System.out.println(bst);
					}
					break;
					
				case 'C':
					System.out.println("The number of nodes in the tree is " + tree.countNodes());
					break;
				case 'H':
					System.out.println("The height of the tree is " + tree.heightTree());
					break;
				case 'R':
					tree.deleteAll();
					System.out.println("The tree has been reset to empty!");
					break;
				case 'P':
					tree.printTree();
					break;
				default:
					System.out.println("The operation '" + nextOp + "' is not recognized.");
					fileIn.nextLine();	//clear rest of line
				}
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println("Opps - no file");
		}
		 
		

	}

}
