package Assignment3;

import java.util.Scanner;

public class MenuApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MathOperations math = new MathOperations();
        int choice;

        do {
            System.out.println("\n===== Math Utility Menu =====");
            System.out.println("1. Print Multiplication Table");
            System.out.println("2. Calculate Factorial");
            System.out.println("3. Check Prime Number");
            System.out.println("4. Print Fibonacci Series");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            int number;
            switch (choice) {
                case 1:
                    System.out.print("Enter a number: ");
                    number = scanner.nextInt();
                    math.printTable(number);
                    break;

                case 2:
                    System.out.print("Enter a number: ");
                    number = scanner.nextInt();
                    math.calculateFactorial(number);
                    break;

                case 3:
                    System.out.print("Enter a number: ");
                    number = scanner.nextInt();
                    math.checkPrime(number);
                    break;

                case 4:
                    System.out.print("Enter number of terms: ");
                    number = scanner.nextInt();
                    math.printFibonacci(number);
                    break;

                case 5:
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please enter between 1-5.");
            }

        } while (choice != 5);

        scanner.close();
    }
}

