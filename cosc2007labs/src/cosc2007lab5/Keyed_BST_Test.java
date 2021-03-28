package cosc2007lab5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// syso -> ctrl + space + enter ==>System.out.println

public class Keyed_BST_Test {

	public static void main(String[] args) {

		Keyed_BST tree = new Keyed_BST();

		// THING TO DO
		// show tree is empty
		System.out.println("is empty " + tree.isEmpty() + "\n");

		// try(Scanner fileIn = new Scanner(new File("./src/PersonData.txt"))) {
		try (Scanner fileIn = new Scanner(new File("D:\\EclipceProjects\\cosc2007labs\\src\\cosc2007lab5\\PersonData.txt"))) {
			while (fileIn.hasNext()) {
				String lastName = fileIn.next();
				String firstName = fileIn.next();
				int age = fileIn.nextInt();
				int year = fileIn.nextInt();
				char gender = fileIn.next().toUpperCase().charAt(0);
				Person person = new Person(firstName, lastName, age, year, gender);

				// printing is just to test the file read operation
				System.out.println(person);

				// THING TO DO
				// add the person to the tree
				tree.insert(person);

			}

		} catch (FileNotFoundException e) {
			System.out.println("Opps - no file");
		}

		// THINGS TO DO
		// show tree is not empty
		System.out.println("is empty " + tree.isEmpty() + "\n");

		// print tree
		tree.printTree();
		System.out.println();
		// show number of nodes and tree height
		System.out.println("Number of nodes " +  tree.countNodes() + "\n");
		System.out.println("Height of the tree " + tree.heightTree()  + "\n");
		// announce you are emptying the tree and then do so
		System.out.println("The tree is empty now");
		tree.deleteAll();
		// show tree is empty
		System.out.println("is empty " + tree.isEmpty());
	}

}
