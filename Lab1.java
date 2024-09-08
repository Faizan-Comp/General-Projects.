package primary;
import java.util.Scanner;

/**
 * CET - CS Academic Level 3
 * This class contains the dynamically allocated array, and it's processing
 * Student Name: Khaled Hamail
 * Student Number: 041136483
 * Course: CST8130 - Data Structures
 * Professor: Prof. Narges Tabar
 *
 */
public class Lab1 {
public static Scanner s = new Scanner(System.in);
    /**
     * @param args
     */
    public static void main(String[] args) {
        Numbers n = new Numbers();
        int x;
        do {
            displayMainMenu();
            x = s.nextInt();
            switch (x) {
                case 1:
                    n = new Numbers();
                    break;
                case 2:
                    System.out.print("Enter the new size of the array: ");
                    int size = s.nextInt();
                    n= new Numbers(size);
                    break;
                case 3:
                    System.out.print("Enter value: ");
                    float value = s.nextFloat();
                    n.addValue(value);
                    break;
                case 4:
                    String str = n.toString();
                    System.out.print("Numbers are: " + str + "\n");

                    break;
                case 5:
                    System.out.print("Average is: " + n.calcAverage() + ", ");
                    System.out.print(n.findMinMax());
                    System.out.print(" Factorial of min is: " + n.getFactorialMin() + "\n");
                    break;
                case 6:
                    System.out.println("Exiting...");
            }
        } while (x != 6);

    }

    public static void displayMainMenu() {
        System.out.println("Please select one of the following:");
        System.out.println("1. Initialize a default array");
        System.out.println("2. Specify the max size of the array");
        System.out.println("3. Add value to the array");
        System.out.println("4. Display values in the array");
        System.out.println("5. Display average of the values, minimum value, maximum value, max mod min, factorial min");
        System.out.println("6. To Exit");
    }



}

