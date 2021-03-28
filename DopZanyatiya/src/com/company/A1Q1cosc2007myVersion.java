package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Maxim Tyutyunin
 * cosc2007
 * <p>
 * Purpose:
 * Fetch an array from user given file. Find the shortest paths to destination
 * <p>
 * <p>
 * Useful code for later:
 * <p>
 * 1)
 * 2 following lines fetch digits from string
 * Pattern pattern = Pattern.compile("[^0-9]");//2 following lines fetch digits from string
 * String numberOnly = pattern.matcher(userInput).replaceAll("");
 * <p>
 * 2)
 * System.out.println(Arrays.deepToString(maze));
 * <p>
 * 3)
 * long startTime = System.nanoTime();
 * long elapsedTime = System.nanoTime() - startTime;
 * <p>
 * 4)
 * Arrays.stream(args).forEach(System.out::println);// .forEach() means apply some code to each element, can contain many things
 *Arrays.stream(args).forEach(s -> {
 *             System.out.println(s);
 *         });
 * <p>
 * 5)
 *  Scanner sf = new Scanner(new BufferedReader(new FileReader("D:\\IJProjects\\src\\" +
 * "cosc2007\\" + userInputFile + ".txt")));
 */
public class A1Q1cosc2007myVersion {
    static int totalSteps = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int rows = 0;
        int columns = 0;
        int[][] maze = null;

        try {
            Scanner sf = new Scanner(new BufferedReader(new FileReader(args[0])));
            if (sf.hasNextLine()){
                String[] line = sf.nextLine().trim().split(" ");// create line array to hold elements of a string from a file
                rows = Integer.parseInt(line[0]);
                columns = Integer.parseInt(line[1]);
                maze = new int[rows][columns];
            }else{
                throw new IllegalArgumentException("Array size was not provided in file");
            }
            while (sf.hasNextLine()) {
                for (int i = 0; i < maze.length; i++) {
                    String[] line = sf.nextLine().trim().split(" ");//trim() cuts all extra spaces,
                    for (int j = 0; j < line.length; j++) {
                        maze[i][j] = Integer.parseInt(line[j]);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }

        System.out.println("Type coordinates in form (n,m)(a,b), spaces do not matter:");
        String userInputCoordinates = sc.nextLine();

        Pattern pattern = Pattern.compile("[^-0-9]");//this and the following lines fetch digits from string
        String numberOnly = pattern.matcher(userInputCoordinates).replaceAll("");

        inputCheck(numberOnly, userInputCoordinates);// check if there are any letters instead if digits

//TODO так приемлемо?
        int[] nums = new int[4];//0,0,0,0
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (numberOnly.charAt(count) == '-') {
                count++;
                nums[i] = Character.getNumericValue(numberOnly.charAt(count)) * -1;
            } else {
                nums[i] = Character.getNumericValue(numberOnly.charAt(count));
            }
            count++;
        }
        int colStart = nums[0],
                rowStart = nums[1],
                colEnd = nums[2],
                rowEnd = nums[3];

        if (startCheck(maze, rowStart, colStart) == 1
                && destinationCheck(maze, rowEnd, colEnd) == 1) {
            searchMaze(maze, rowStart, colStart, rowEnd, colEnd);
            System.out.println("The smallest number of steps to " +
                    "reach the destination is: " + totalSteps);
        }

    }

    //helper
    public static void searchMaze(int[][] maze, int rowStart, int colStart, int rowDest, int colDest) {
        int stepCounter = 0;
        totalSteps = maze.length * maze[0].length;
        searchMaze(maze, maze[0].length, maze.length, rowStart, colStart, rowDest, colDest, stepCounter);
    }

    public static void searchMaze(int[][] maze, int length, int height, int rowStart, int colStart, int rowDest, int colDest, int stepCounter) {
        /**recursive steps are moves right, left, up, down, if a
         * sequence of steps is not successful they will roll back
         * deleting al unnecessary steps and
         * keeping important ones*/
        System.out.println(totalSteps + "\n");
        printMaze(maze);
        int temp = maze[rowStart][colStart];
        //
        if (rowStart == rowDest && colStart == colDest && totalSteps > stepCounter) {
            totalSteps = stepCounter;//base case
            return;// acts as a stopper in this situation
        }

        //1) right
        if (colStart < length - 1 && maze[rowStart][colStart + 1] != 0 && maze[rowStart][colStart + 1] != 5) {
            maze[rowStart][colStart] = 5;// marks all previous positions
            searchMaze(maze, length, height, rowStart, colStart + 1, rowDest, colDest, stepCounter + 1);

        }
        //2)down
        if (rowStart < height - 1 && maze[rowStart + 1][colStart] != 0 && maze[rowStart + 1][colStart] != 5) {
            maze[rowStart][colStart] = 5;// marks all previous positions
            searchMaze(maze, length, height, rowStart + 1, colStart, rowDest, colDest, stepCounter + 1);

        }
        //3)left
        if (colStart > 0 && maze[rowStart][colStart - 1] != 0 && maze[rowStart][colStart - 1] != 5) {
            maze[rowStart][colStart] = 5;// marks all previous positions
            searchMaze(maze, length, height, rowStart, colStart - 1, rowDest, colDest, stepCounter + 1);

        }
        //4)up
        if (rowStart > 0 && maze[rowStart - 1][colStart] != 0 && maze[rowStart - 1][colStart] != 5) {
            maze[rowStart][colStart] = 5;// marks all previous positions
            searchMaze(maze, length, height, rowStart - 1, colStart, rowDest, colDest, stepCounter + 1);

        }
        maze[rowStart][colStart] = temp;
    }

    public static void inputCheck(String strNumbersOnly, String originalStr) {
        /**
         * no instructions were given about  lambda expression,
         * i wanted to see, how it works.
         *
         * These 2 lines fetch digits from string and create a new string that is of length 4(
         * if  all conditions were met) whis is only consists of digits, if
         * one or more coordinates is not a number the length of string will be less.
         * I just ahve to choose between those cases
         *
         *  Pattern pattern = Pattern.compile("[^0-9]");//this and the following lines fetch digits from string
         *  String numberOnly = pattern.matcher(userInputCoordinates).replaceAll("");
         * */
        Pattern pattern = Pattern.compile("[^0-9]");//this and the following lines fetch digits from string
        String numberOnly = pattern.matcher(strNumbersOnly).replaceAll("");

        int numberOfInvalidCoord = 0;
        if (numberOnly.length() < 4) {
            numberOfInvalidCoord = 4 - numberOnly.length();

    throw new IllegalArgumentException(numberOfInvalidCoord + " invalid Character(s): " + originalStr);

        }

    }

    public static int destinationCheck(int[][] maze, int rowDest, int colDest) {
//TODO так приемлемо?
        if (colDest >= maze.length || rowDest >= maze.length) {
            System.out.println("Invalid End with a number that’s too large ( " + colDest + "," + rowDest + " )");
            return 0;
        }
        if (colDest < 0 || rowDest < 0) {
            System.out.println("Invalid End with a number that’s too small ( " + colDest + "," + rowDest + " )");
            return 0;
        }


        if (maze[rowDest][colDest] == 0) {
            System.out.println("2 Valid positive values, but the number at destination is 0");
            return 0;
        }
        // if (maze[rowDest][colDest + 1] == 0 && maze[rowDest][colDest - 1] == 0 && maze[rowDest + 1][colDest] == 0 && maze[rowDest - 1][colDest] == 0) {
        //rowDest = row, colDest = column
        if (colDest == 0) {
            if (rowDest == 0) {
                if (maze[rowDest][colDest + 1] == 0 && maze[rowDest + 1][colDest] == 0) {
                    System.out.println("( " + colDest + "," + rowDest + " ) can not be reached");
                    return 0;
                }
            } else if (rowDest == maze.length - 1) {
                if (maze[rowDest][colDest + 1] == 0 && maze[rowDest - 1][colDest] == 0) {
                    System.out.println("( " + colDest + "," + rowDest + " ) can not be reached");
                    return 0;
                }
            } else {
                if (maze[rowDest][colDest + 1] == 0 && maze[rowDest + 1][colDest] == 0 && maze[rowDest - 1][colDest] == 0) {
                    System.out.println("( " + colDest + "," + rowDest + " ) can not be reached");
                    return 0;
                }
            }
        }

        if (colDest == maze.length - 1) {
            if (rowDest == 0) {
                if (maze[rowDest][colDest - 1] == 0 && maze[rowDest + 1][colDest] == 0) {
                    System.out.println("( " + colDest + "," + rowDest + " ) can not be reached");
                    return 0;
                }
            } else if (rowDest == maze.length - 1) {
                if (maze[rowDest][colDest - 1] == 0 && maze[rowDest - 1][colDest] == 0) {
                    System.out.println("( " + colDest + "," + rowDest + " ) can not be reached");
                    return 0;
                }
            } else {
                if (maze[rowDest][colDest - 1] == 0 && maze[rowDest + 1][colDest] == 0 && maze[rowDest - 1][colDest] == 0) {
                    System.out.println("( " + colDest + "," + rowDest + " ) can not be reached");
                    return 0;
                }
            }
        }

        if (rowDest == 0) {
            if (colDest == 0) {
                if (maze[rowDest][colDest + 1] == 0 && maze[rowDest + 1][colDest] == 0) {
                    System.out.println("( " + colDest + "," + rowDest + " ) can not be reached");
                    return 0;
                }
            } else if (colDest == maze.length - 1) {
                if (maze[rowDest][colDest - 1] == 0 && maze[rowDest + 1][colDest] == 0) {
                    System.out.println("( " + colDest + "," + rowDest + " ) can not be reached");
                    return 0;
                }
            } else {
                if (maze[rowDest][colDest + 1] == 0 && maze[rowDest][colDest - 1] == 0 && maze[rowDest + 1][colDest] == 0) {
                    System.out.println("( " + colDest + "," + rowDest + " ) can not be reached");
                    return 0;
                }
            }
        }

        if (rowDest == maze.length - 1) {
            if (colDest == 0) {
                if (maze[rowDest][colDest + 1] == 0 && maze[rowDest - 1][colDest] == 0) {
                    System.out.println("( " + colDest + "," + rowDest + " ) can not be reached");
                    return 0;
                }
            } else if (colDest == maze.length - 1) {
                if (maze[rowDest][colDest - 1] == 0 && maze[rowDest - 1][colDest] == 0) {
                    System.out.println("( " + colDest + "," + rowDest + " ) can not be reached");
                    return 0;
                }
            } else {
                if (maze[rowDest][colDest + 1] == 0 && maze[rowDest][colDest - 1] == 0 && maze[rowDest - 1][colDest] == 0) {
                    System.out.println("( " + colDest + "," + rowDest + " ) can not be reached");
                    return 0;
                }
            }
        }
        return 1;
    }

    public static int startCheck(int[][] maze, int rowStart, int colStart) {
        if (colStart >= maze.length || rowStart >= maze.length) {
            System.out.println("Invalid Start with a number that’s too large ( " + colStart + "," + rowStart + " )");
            return 0;
        }
        if (colStart < 0 || rowStart < 0) {
            System.out.println("Invalid Start with a number that’s too small ( " + colStart + "," + rowStart + " )");
            return 0;
        }
        if (maze[rowStart][colStart] == 0) {
            System.out.println("2 Valid positive values, but the number at start position is 0");
            return 0;
        }
        return 1;

    }

    public static void printMaze(int[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                System.out.print(maze[i][j] + " ");
                if (j == maze[0].length - 1) System.out.println();
            }
        }
        System.out.println("\n-----------------------------------\n");
    }
}

