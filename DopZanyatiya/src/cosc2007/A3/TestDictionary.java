package cosc2007.A3;

/**
 * Maxim Tyutyunin
 * cosc2007
 * <p>
 * Purpose:
 * get commands from file and input results into another file
 */

import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class TestDictionary {
    public static void main(String[] args) throws DictionaryException {
        Writer writer = null;
        SortedTable at = null;
        Scanner sc = new Scanner(System.in);

        String userInputFile = "";
        int userOption;

        /**InputMismatchException appears because the value from the last iteration is still in the scanner*/
        while (true) {

            System.out.println("Enter file name(stop to exit): ");
            userInputFile = sc.nextLine();

            if (userInputFile.toLowerCase().equals("stop")) {
                break;
            }

/**TODO problem here .NullPointerException: Cannot invoke "java.net.URL.getFile()" because "path" is null
 i couldn't figure out how to fix it in a better way rather than creating a new scanner specifically to read new user input*/
            Scanner sc1 = new Scanner(System.in);
            System.out.println("0 to initialize Sorted array,\n" +
                    "1 to initialize SortedList");
            userOption = sc1.nextInt();
            if (userOption == 0) {
                at = new SortedArrayTable(10);// at - variable of type SortedTable
            } else if (userOption == 1) {
                at = new SortedListTable(10);// at - variable of type SortedTable
            }

            try {
                URL path = TestDictionary.class.getResource(userInputFile + ".txt");
                File f = new File(path.getFile());
/**full directory required for the next line instead of output.txt as far as i understand
 * otherwise */
                writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.txt"), "utf-8"));
                Scanner sf = new Scanner(new BufferedReader(new FileReader(f)));

                char command;
                int element;
                while (sf.hasNextLine()) {
                    String commandString = sf.nextLine();
                    command = getLetter(commandString);
                    /**
                     * display is here so i don't have to deal
                     * with absent element part D(nothing here)
                     * instead of I(number)
                     * */
                    if (command == 'D') {
                        at.display();
                        continue;
                    }
                    element = getNumber(commandString);

                    switch (command) {
                        case 'I':
                            writer.write("Inserted Element " + element + "\n");
                            try {
                                at.insert(element);
                            } catch (DictionaryException e) {
                                writer.write("Duplicate_Element_Found\n");
                                continue;
                            }
                            break;
                        case 'R':
                            writer.write("Delete Element " + element + "\n");
                            at.delete(element);
                            break;
                        case 'F':
                            writer.write("Searching for: " + element + "\n");
                            if (at.find(element)) {
                                writer.write(element + " is Found\n");
                            } else {
                                writer.write(element + " is not Found\n");
                            }
                            break;
                        case 'D':
                            at.display();
                            break;
                        default:
                            System.out.println("Wrong input command");
                    }
                }


            } catch (DictionaryException | IOException e) {
                continue;
//                e.printStackTrace();
//                System.exit(1);
            }

        }
        try {
            writer.flush();
            writer.close();
        } catch (Exception ex) {
        }
    }

    /**get char from the first position of the string passed from
     * a file*/
    public static char getLetter(String s) {
        return s.charAt(0);
    }

    /**get only the number*/
    public static int getNumber(String s) {

        String temp = s.substring(2, s.length() - 1);
        int a = Integer.parseInt(temp);
        return a;
    }


}
